import com.alibaba.fastjson.JSON;
import model.cart.FetchCartResult;
import model.order.AddOrderResult;
import model.order.PackageOrder;
import utils.Log;
import utils.Requests;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Entry {

    static FetchCartResult fetchCartResult = null;
    static PackageOrder packageOrder = null;

    public static void main(String[] args) {
        init();
        System.out.println("当前购物车商品:\n" + fetchCartResult.preview());
        Scanner scanner = new Scanner(System.in);
        System.out.println("已刷新购物车是否继续？(Y/N)");
        if (!"Y".equals(scanner.nextLine())) {
            System.exit(0);
        }
        final List<Requests.TimeRange> range = Requests.getTimeRange();
        range.forEach(e -> new Thread(() -> action(e)).start());
    }

    public static void action(Requests.TimeRange range) {
        while (true) {
            PackageOrder _packageOrder = JSON.parseObject(JSON.toJSONString(packageOrder), PackageOrder.class);
            _packageOrder.setTimeRange(range);
            try {
                final AddOrderResult result = Requests.addNewOrder(_packageOrder);
                if (result.getSuccess()) {
                    System.out.println("Range:【 " + range.getStart() + " | " + range.getEnd() + " 】->>>Success");
                    System.exit(0);
                }
                System.out.println("Range:【 " + range.getStart() + " | " + range.getEnd() + " 】->>>" + result);
                if (NEED_REFETCH_CART_TAGS.contains(result.getData().getTradeTag())) {
                    fetchCartResult = null;
                    init();
                }
            } catch (Exception e) {
                Log.log("add new order error", e);
            }
            try {
                Thread.sleep(1000);
            } catch (Exception ignored) {
            }
        }
    }

    private synchronized static void init() {
        while (fetchCartResult == null) {
            try {
                fetchCartResult = Requests.fetchCart();
            } catch (Exception e) {
                Log.log("fetch cart error", e);
            }
            if (!fetchCartResult.getSuccess()) {
                System.out.println("购物车拉取失败 msg:" + fetchCartResult.getMsg());
                fetchCartResult = null;
                continue;
            }
            if (fetchCartResult.getData().getProduct().getEffective().size() == 0) {
                System.out.println("购物车可购商品为空");
                System.exit(0);
            }
            packageOrder = PackageOrder.generate(fetchCartResult);
        }
    }

    /**
     * 需要重新拉去购物车的 TAGS
     * - PRODUCT_OUT_OF_STOCK: 有商品库存不足
     * - PRODUCT_INFO_HAS_CHANGED: 商品信息已经更改
     */
    private static final List<String> NEED_REFETCH_CART_TAGS = Arrays.asList(
            "PRODUCT_OUT_OF_STOCK",
            "PRODUCT_INFO_HAS_CHANGED"
    );
}
