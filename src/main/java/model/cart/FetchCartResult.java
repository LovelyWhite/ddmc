package model.cart;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import model.BaseResponseResult;
import model.order.SaleBatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class FetchCartResult extends BaseResponseResult {

    private Data data;

    @lombok.Data
    public static class Data {
        private Product product;
        private String toast;
        private String alert;
        @JSONField(name = "all_activity_cart")
        private List<AllActivityCart> allActivityCart;
        @JSONField(name = "station_id")
        private String stationId;
        @JSONField(name = "order_product_list")
        private List<String> orderProductList;
        @JSONField(name = "new_order_product_list")
        private List<NewOrderProductList> newOrderProductList;
        @JSONField(name = "order_product_list_sign")
        private String orderProductListSign;
        @JSONField(name = "full_to_off")
        private String fullToOff;
        @JSONField(name = "freight_money")
        private String freightMoney;
        @JSONField(name = "free_freight_type")
        private Integer freeFreightType;
        @JSONField(name = "instant_rebate_money")
        private String instantRebateMoney;
        @JSONField(name = "goods_real_money")
        private String goodsRealMoney;
        @JSONField(name = "total_money")
        private String totalMoney;
        @JSONField(name = "is_select_detail")
        private Integer isSelectDetail;
        @JSONField(name = "good_max_count_toast")
        private String goodMaxCountToast;
        @JSONField(name = "is_all_check")
        private Integer isAllCheck;
        @JSONField(name = "onion_id")
        private String onionId;
        @JSONField(name = "onion_tip")
        private OnionTip onionTip;
        @JSONField(name = "cart_notice")
        private String cartNotice;
        @JSONField(name = "cart_notice_new")
        private String cartNoticeNew;
        @JSONField(name = "free_freight_notice")
        private FreeFreightNotice freeFreightNotice;
        @JSONField(name = "cart_top_floor_info")
        private List<String> cartTopFloorInfo;
        @JSONField(name = "cart_count")
        private Integer cartCount;
        @JSONField(name = "total_count")
        private Integer totalCount;
        @JSONField(name = "product_num")
        private Map<String, Integer> productNum;
        @JSONField(name = "stop_order_toast")
        private String stopOrderToast;
        @JSONField(name = "gift_no_size_tip")
        private String giftNoSizeTip;
        @JSONField(name = "is_hit_onion")
        private Boolean isHitOnion;
        @JSONField(name = "onion_ab_config")
        private Integer onionAbConfig;
        @JSONField(name = "is_hit_gift_size")
        private Boolean isHitGiftSize;
        @JSONField(name = "coupon_text_a")
        private String couponTextA;
        @JSONField(name = "coupon_text_b")
        private String couponTextB;
        @JSONField(name = "need_amount")
        private String needAmount;
        @JSONField(name = "is_vip_ticket")
        private Integer isVipTicket;
        @JSONField(name = "coupon_amount")
        private String couponAmount;
        @JSONField(name = "coupon_state")
        private Integer couponState;
        @JSONField(name = "coupon_type")
        private Integer couponType;
        @JSONField(name = "next_recommend_coupon")
        private NextRecommendCoupon nextRecommendCoupon;
        @JSONField(name = "show_coupon_detail")
        private Boolean showCouponDetail;
        @JSONField(name = "contains_advent_gift")
        private Integer containsAdventGift;
        @JSONField(name = "parent_order_info")
        private ParentOrderInfo parentOrderInfo;
        @JSONField(name = "is_support_merge_payment")
        private Integer isSupportMergePayment;
        @JSONField(name = "sodexo_nonsupport_product_list")
        private List<String> sodexoNonsupportProductList;
        @JSONField(name = "valid_product_counts")
        private Map<String, Integer> validProductCounts;
    }

    @lombok.Data
    public static class ActivityInfo {

        private String id;
        private String gifts;
    }


    @lombok.Data
    public static class Effective {

        @JSONField(name = "activity_info")
        private ActivityInfo activityInfo;
        private List<Products> products;
    }

    @lombok.Data
    public static class Products {
        private String id;
        private Integer type;
        private String category;
        private String price;
        private List<String> sizes = new ArrayList<>();
        private Integer count;
        private Integer status;
        private List<String> gifts;
        @JSONField(name = "addTime")
        private Integer addtime;
        @JSONField(name = "cart_id")
        private String cartId;
        @JSONField(name = "activity_id")
        private String activityId;
        @JSONField(name = "sku_activity_id")
        private String skuActivityId;
        @JSONField(name = "conditions_num")
        private String conditionsNum;
        @JSONField(name = "activity_tag")
        private String activityTag;
        @JSONField(name = "category_path")
        private String categoryPath;
        @JSONField(name = "manage_category_path")
        private String manageCategoryPath;
        @JSONField(name = "total_price")
        private String totalPrice;
        @JSONField(name = "origin_price")
        private String originPrice;
        @JSONField(name = "no_supplementary_price")
        private String noSupplementaryPrice;
        @JSONField(name = "no_supplementary_total_price")
        private String noSupplementaryTotalPrice;
        @JSONField(name = "size_price")
        private String sizePrice;
        @JSONField(name = "add_price")
        private String addPrice;
        @JSONField(name = "add_vip_price")
        private String addVipPrice;
        @JSONField(name = "price_type")
        private Integer priceType;
        @JSONField(name = "buy_limit")
        private Integer buyLimit;
        @JSONField(name = "promotion_num")
        private Integer promotionNum;
        @JSONField(name = "product_name")
        private String productName;
        @JSONField(name = "product_type")
        private Integer productType = 0;
        @JSONField(name = "small_image")
        private String smallImage;
        @JSONField(name = "all_sizes")
        private List<String> allSizes;
        @JSONField(name = "only_new_user")
        private Boolean onlyNewUser;
        @JSONField(name = "is_check")
        private Integer isCheck;
        @JSONField(name = "is_gift")
        private Integer isGift;
        @JSONField(name = "is_bulk")
        private Integer isBulk;
        @JSONField(name = "view_total_weight")
        private String viewTotalWeight;
        @JSONField(name = "net_weight")
        private String netWeight;
        @JSONField(name = "net_weight_unit")
        private String netWeightUnit;
        @JSONField(name = "is_stock")
        private Boolean isStock;
        @JSONField(name = "old_count")
        private Integer oldCount;
        @JSONField(name = "stock_number")
        private Integer stockNumber;
        @JSONField(name = "not_meet")
        private List<String> notMeet;
        @JSONField(name = "is_presale")
        private Integer isPresale;
        @JSONField(name = "presale_id")
        private String presaleId;
        @JSONField(name = "presale_type")
        private Integer presaleType;
        @JSONField(name = "delivery_start_time")
        private Integer deliveryStartTime;
        @JSONField(name = "delivery_end_time")
        private Integer deliveryEndTime;
        @JSONField(name = "is_invoice")
        private Integer isInvoice;
        @JSONField(name = "is_onion")
        private Integer isOnion;
        @JSONField(name = "sub_list")
        private List<String> subList;
        @JSONField(name = "is_booking")
        private Integer isBooking = 0;
        @JSONField(name = "today_stockout")
        private String todayStockout;
        @JSONField(name = "storage_value_id")
        private Integer storageValueId;
        @JSONField(name = "temperature_layer")
        private String temperatureLayer;
        @JSONField(name = "is_shared_station_product")
        private Integer isSharedStationProduct;
        @JSONField(name = "is_fresh_food")
        private Integer isFreshFood;
        @JSONField(name = "accessory_gifts")
        private List<String> accessoryGifts;
        @JSONField(name = "accessory_text")
        private String accessoryText;
        @JSONField(name = "supplementary_list")
        private List<String> supplementaryList;
        private String description;
        @JSONField(name = "parent_id")
        private String parentId = "";
        @JSONField(name = "parent_batch_type")
        private Integer parentBatchType;
        @JSONField(name = "total_origin_price")
        private String totalOriginPrice;
        @JSONField(name = "instant_rebate_money")
        private String instantRebateMoney;
        @JSONField(name = "sale_batches")
        private SaleBatch saleBatches;
        @JSONField(name = "order_sort")
        private Integer orderSort = 3;
        @JSONField(name = "promotion_info")
        private String promotionInfo;
    }

    @lombok.Data
    public static class Invalid {

        private List<Products> products;
    }

    @lombok.Data
    public static class Product {

        private List<Effective> effective;
        private List<Invalid> invalid;
    }

    @lombok.Data
    public static class Conditions {

        private String desc;
        private List<String> gifts;
        @JSONField(name = "conditions_num")
        private String conditionsNum;
        @JSONField(name = "is_meet")
        private Boolean isMeet;
        @JSONField(name = "is_attend")
        private Boolean isAttend;
        @JSONField(name = "meet_count")
        private Integer meetCount;
        @JSONField(name = "limit_count")
        private Integer limitCount;
        @JSONField(name = "barter_title")
        private String barterTitle;
    }

    @lombok.Data
    public static class DescTags {

        private Integer type;
        private String name;
    }

    @lombok.Data
    public static class ProductGifts {

        private String id;
        private String name;
        private String price;
        private String spec;
        private List<String> sizes;
        private Integer status;
        private Integer type;
        private List<String> activity;
        private Integer oid;
        @JSONField(name = "product_name")
        private String productName;
        @JSONField(name = "origin_price")
        private String originPrice;
        @JSONField(name = "vip_price")
        private String vipPrice;
        @JSONField(name = "small_image")
        private String smallImage;
        @JSONField(name = "category_id")
        private String categoryId;
        @JSONField(name = "month_sales")
        private Integer monthSales;
        @JSONField(name = "buy_limit")
        private Integer buyLimit;
        @JSONField(name = "station_stock")
        private Integer stationStock;
        @JSONField(name = "mark_discount")
        private Integer markDiscount;
        @JSONField(name = "mark_new")
        private Integer markNew;
        @JSONField(name = "category_path")
        private String categoryPath;
        @JSONField(name = "stockout_reserved")
        private Boolean stockoutReserved;
        @JSONField(name = "is_promotion")
        private Integer isPromotion;
        @JSONField(name = "sale_point_msg")
        private List<String> salePointMsg;
        @JSONField(name = "is_presale")
        private Integer isPresale;
        @JSONField(name = "presale_delivery_date_display")
        private String presaleDeliveryDateDisplay;
        @JSONField(name = "is_gift")
        private Integer isGift;
        @JSONField(name = "is_bulk")
        private Integer isBulk;
        @JSONField(name = "net_weight")
        private String netWeight;
        @JSONField(name = "net_weight_unit")
        private String netWeightUnit;
        @JSONField(name = "is_onion")
        private Integer isOnion;
        @JSONField(name = "is_invoice")
        private Integer isInvoice;
        @JSONField(name = "sub_list")
        private List<String> subList;
        @JSONField(name = "badge_img")
        private String badgeImg;
        @JSONField(name = "badge_position")
        private Integer badgePosition;
        @JSONField(name = "is_vod")
        private Boolean isVod;
        @JSONField(name = "decision_information")
        private List<String> decisionInformation;
        @JSONField(name = "stock_number")
        private Integer stockNumber;
        @JSONField(name = "today_stockout")
        private String todayStockout;
        @JSONField(name = "is_booking")
        private Integer isBooking;
        @JSONField(name = "user_bought")
        private Integer userBought;
        @JSONField(name = "temperature_layer")
        private String temperatureLayer;
        @JSONField(name = "storage_value_id")
        private Integer storageValueId;
        @JSONField(name = "attribute_tags")
        private List<String> attributeTags;
        @JSONField(name = "desc_tags")
        private List<DescTags> descTags;
        @JSONField(name = "marketing_tags")
        private List<String> marketingTags;
        @JSONField(name = "image_preferential_choice")
        private String imagePreferentialChoice;
    }

    @lombok.Data
    public static class AllActivityCart {

        private String id;
        private String name;
        private Integer type;
        private String desc;
        private List<String> subtitle;
        private List<String> gifts;
        private List<Conditions> conditions;
        private String lack;
        private String condition;
        @JSONField(name = "is_all")
        private Integer isAll;
        @JSONField(name = "type_name")
        private String typeName;
        @JSONField(name = "tries_limit")
        private Integer triesLimit;
        @JSONField(name = "is_meet")
        private Boolean isMeet;
        @JSONField(name = "is_attend")
        private Boolean isAttend;
        @JSONField(name = "meet_count")
        private Integer meetCount;
        @JSONField(name = "conditions_value")
        private String conditionsValue;
        @JSONField(name = "conditions_num")
        private String conditionsNum;
        @JSONField(name = "activity_money")
        private String activityMoney;
        @JSONField(name = "barter_limit")
        private String barterLimit;
        @JSONField(name = "product_gifts")
        private List<ProductGifts> productGifts;
    }


    @lombok.Data
    public static class NewOrderProductList {

        private List<Products> products;
        @JSONField(name = "total_money")
        private String totalMoney;
        @JSONField(name = "total_origin_money")
        private String totalOriginMoney;
        @JSONField(name = "goods_real_money")
        private String goodsRealMoney;
        @JSONField(name = "total_count")
        private Integer totalCount;
        @JSONField(name = "cart_count")
        private Integer cartCount;
        @JSONField(name = "is_presale")
        private Integer isPresale;
        @JSONField(name = "instant_rebate_money")
        private String instantRebateMoney;
        @JSONField(name = "total_rebate_money")
        private String totalRebateMoney;
        @JSONField(name = "used_balance_money")
        private String usedBalanceMoney;
        @JSONField(name = "can_used_balance_money")
        private String canUsedBalanceMoney;
        @JSONField(name = "used_point_num")
        private Integer usedPointNum;
        @JSONField(name = "used_point_money")
        private String usedPointMoney;
        @JSONField(name = "can_used_point_num")
        private Integer canUsedPointNum;
        @JSONField(name = "can_used_point_money")
        private String canUsedPointMoney;
        @JSONField(name = "is_share_station")
        private Integer isShareStation;
        @JSONField(name = "only_today_products")
        private List<String> onlyTodayProducts;
        @JSONField(name = "only_tomorrow_products")
        private List<String> onlyTomorrowProducts;
        @JSONField(name = "package_type")
        private Integer packageType;
        @JSONField(name = "package_id")
        private Integer packageId;
        @JSONField(name = "front_package_text")
        private String frontPackageText;
        @JSONField(name = "front_package_type")
        private Integer frontPackageType;
        @JSONField(name = "front_package_stock_color")
        private String frontPackageStockColor;
        @JSONField(name = "front_package_bg_color")
        private String frontPackageBgColor;
    }

    @lombok.Data
    public static class OnionTip {

        @JSONField(name = "tip_name_type")
        private Integer tipNameType;
        @JSONField(name = "tip_name")
        private String tipName;
    }

    @lombok.Data
    public static class FreeFreightNotice {

        private String title1;
        @JSONField(name = "applet_title2")
        private String appletTitle2;
        private String title2;
        @JSONField(name = "addon_money")
        private String addonMoney;
        @JSONField(name = "is_more")
        private Boolean isMore;
    }

    @lombok.Data
    public static class NextRecommendCoupon {

        @JSONField(name = "coupon_text_a")
        private String couponTextA;
        @JSONField(name = "coupon_text_b")
        private String couponTextB;
        @JSONField(name = "need_amount")
        private String needAmount;
        @JSONField(name = "is_vip_ticket")
        private String isVipTicket;
        @JSONField(name = "is_common_ticket")
        private String isCommonTicket;
    }

    @lombok.Data
    public static class ParentOrderInfo {

        @JSONField(name = "parent_order_sign")
        private String parentOrderSign;
        @JSONField(name = "total_rebate_money")
        private String totalRebateMoney;
        @JSONField(name = "total_origin_money")
        private String totalOriginMoney;
        @JSONField(name = "stockout_gift_product")
        private List<String> stockoutGiftProduct;
        @JSONField(name = "stockout_gift_text")
        private String stockoutGiftText;
        @JSONField(name = "is_open_presale_use_virtual_stock")
        private Boolean isOpenPresaleUseVirtualStock;
    }

    public String preview(){
        List<String> _list = new ArrayList<>();
        final List<Effective> effectives = this.getData().getProduct().getEffective();
        if(effectives.isEmpty()){
            return "";
        }
        effectives.get(0).getProducts().forEach(e -> _list.add(e.getProductName() + "\t¥" + e.getPrice() + "\t 数量:" + e.getCount()));
        StringBuilder builder = new StringBuilder();
        _list.forEach(e-> builder.append(e).append("\n"));
        return builder.toString();
    }
}
