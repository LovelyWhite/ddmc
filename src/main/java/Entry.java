import lombok.SneakyThrows;
import model.cart.FetchCartResult;
import model.order.AddOrderResult;
import model.order.PackageOrder;
import utils.Requests;

import java.util.List;
import java.util.Objects;

public class Entry {

    static boolean success = false;
    static FetchCartResult fetchCartResult = null;
    static PackageOrder packageOrder = null;
    static boolean updating = true;

    @SneakyThrows
    public static void main(String[] args) {
        init();
        // 建议在此处打个断点，到点再继续。
        updating = false;
        final List<Requests.TimeRange> range = Requests.getTimeRange();
        range.forEach(e -> new Thread(() -> action(packageOrder, e)).start());
    }

    public static void action(PackageOrder packageOrder, Requests.TimeRange range) {
        while (!success) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                packageOrder.setTimeRange(range);
                final AddOrderResult result = Requests.addNewOrder(packageOrder);
                if (Objects.equals(result.getData().getTradeTag(), "PRODUCT_OUT_OF_STOCK")
                        || Objects.equals(result.getData().getTradeTag(), "PRODUCT_INFO_HAS_CHANGED")) {
                    if (!updating) {
                        init();
                    }
                    while (updating) {
                        System.out.println("updating");
                    }
                }
                if (result.getSuccess()) {
                    success = true;
                    System.out.println("Range:【 " + range.getStart() + " | " + range.getEnd() + " 】->>>Success");
                    return;
                } else {
                    System.out.println("Range:【 " + range.getStart() + " | " + range.getEnd() + " 】->>>" + result);
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void init() {
        updating = true;
        while (updating) {
            try {
                fetchCartResult = Requests.fetchCart();
                System.out.println("updating cart  code:" + fetchCartResult.getCode() + " msg:" + fetchCartResult.getMsg());
                if (fetchCartResult.getCode() != 0) {
                    continue;
                }
                if (fetchCartResult.getData().getProduct().getEffective().size() == 0) {
                    System.out.println("cart is empty");
                    System.exit(0);
                }
                packageOrder = PackageOrder.generate(fetchCartResult);
                updating = false;
            } catch (Exception ignored) {
            }
        }
    }
}
