package model.order;

import lombok.Data;
import model.BaseResponseResult;

import java.util.List;

@Data
public class AddOrderResult extends BaseResponseResult {

    private Data data;

    @lombok.Data
    public static class Data {
        private String tradeTag;
        private List<StockOutProduct> stockout_products;
    }

    @lombok.Data
    public static class StockOutProduct {
        private Integer count;
        private String description;
        private String product_name;
        private String id;
    }

    @Override
    public String toString() {
        return "code:" + getCode() + " msg:" + getMsg();
    }
}
