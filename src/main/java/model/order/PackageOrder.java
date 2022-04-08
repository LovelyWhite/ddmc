package model.order;

import lombok.Data;
import model.cart.FetchCartResult;
import utils.Configs;
import utils.Requests;

import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class PackageOrder {
    private PaymentOrder payment_order;
    private List<Package> packages;

    public void setTimeRange(Requests.TimeRange timeRange) {
        final long start = timeRange.getStart().toEpochSecond(ZoneOffset.ofHours(8));
        final long end = timeRange.getEnd().toEpochSecond(ZoneOffset.ofHours(8));
        payment_order.setReserved_time_start(start);
        payment_order.setReserved_time_end(end);
        packages.forEach(e -> {
            e.setReserved_time_start(start);
            e.setReserved_time_end(end);
        });
    }

    @Data
    public static class Package {
        private List<Product> products;
        private String total_money;
        private String total_origin_money;
        private String goods_real_money;
        private Integer total_count;
        private Integer cart_count;
        private Integer is_presale;
        private String instant_rebate_money;
        private String total_rebate_money;
        private String used_balance_money;
        private String can_used_balance_money;
        private Integer used_point_num;
        private String used_point_money;
        private Integer can_used_point_num;
        private String can_used_point_money;
        private Integer is_share_station;
        private List<String> only_today_products;
        private List<String> only_tomorrow_products;
        private Integer package_type;
        private Integer package_id;
        private String front_package_text;
        private Integer front_package_type;
        private String front_package_stock_color;
        private String front_package_bg_color;
        private String eta_trace_id;
        private Long reserved_time_start;
        private Long reserved_time_end;
        private String soon_arrival;
    }

    @Data
    public static class Product {
        private String id;
        private String parent_id;
        private Integer count;
        private String cart_id;
        private String price;
        private Integer product_type;
        private String delivery_date_tag;
        private Integer is_booking;
        private String product_name;
        private String small_image;
        private SaleBatch sale_batches;
        private Integer order_sort;
        private List<String> sizes;
    }

    @Data
    public static class PaymentOrder {
        private Long reserved_time_start;
        private Long reserved_time_end;
        private String price;
        private String freight_discount_money;
        private String freight_money;
        private String order_freight;
        private String parent_order_sign;
        private Integer product_type;
        private String address_id;
        private String receipt_without_sku;
        private Integer pay_type;
        private String vip_money;
        private String vip_buy_user_ticket_id;
        private String coupons_money;
        private String coupons_id;
    }

    public static PackageOrder generate(FetchCartResult result) {
        final FetchCartResult.Data data = result.getData();
        PackageOrder params = new PackageOrder();
        PaymentOrder payment_order = new PaymentOrder();
        payment_order.setPrice(data.getTotalMoney());
        payment_order.setFreight_discount_money("5.00");
        payment_order.setFreight_money("5.00");
        payment_order.setOrder_freight("0.00");
        payment_order.setParent_order_sign(data.getParentOrderInfo().getParentOrderSign());
        payment_order.setProduct_type(1);
        payment_order.setAddress_id(Configs.addressId);
        payment_order.setReceipt_without_sku(null);
        payment_order.setPay_type(11);
        payment_order.setVip_money("");
        payment_order.setVip_buy_user_ticket_id("");
        payment_order.setCoupons_money("");
        payment_order.setCoupons_id("");
        params.setPayment_order(payment_order);
        final List<Product> products = data.getProduct().getEffective().get(0).getProducts().stream().map(e -> {
            Product product = new Product();
            product.setId(e.getId());
            product.setParent_id(e.getParentId());
            product.setCount(e.getCount());
            product.setCart_id(e.getCartId());
            product.setPrice(e.getAddPrice());
            product.setDelivery_date_tag("");
            product.setProduct_type(e.getProductType());
            product.setIs_booking(e.getIsBooking());
            product.setProduct_name(e.getProductName());
            product.setSmall_image("");
            product.setSale_batches(e.getSaleBatches());
            product.setOrder_sort(e.getOrderSort());
            product.setSizes(e.getSizes());
            return product;
        }).collect(Collectors.toList());
        Package pkg = new Package();
        pkg.setProducts(products);
        pkg.setTotal_money(data.getTotalMoney());
        pkg.setTotal_origin_money(data.getGoodsRealMoney());
        pkg.setTotal_count(data.getTotalCount());
        pkg.setCart_count(data.getCartCount());
        pkg.setIs_presale(0);
        pkg.setInstant_rebate_money(data.getInstantRebateMoney());
        pkg.setTotal_rebate_money("0.00");
        pkg.setUsed_balance_money("0.00");
        pkg.setUsed_point_num(0);
        pkg.setUsed_point_money("0.00");
        pkg.setIs_share_station(0);
        pkg.setOnly_today_products(new ArrayList<>());
        pkg.setOnly_tomorrow_products(new ArrayList<>());
        pkg.setPackage_type(2);
        pkg.setPackage_id(1);
        pkg.setFront_package_type(0);
        pkg.setSoon_arrival("");
        params.setPackages(Collections.singletonList(pkg));
        return params;
    }
}
