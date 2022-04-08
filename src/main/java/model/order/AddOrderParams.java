package model.order;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import model.BaseRequestParams;

@Data
public class AddOrderParams extends BaseRequestParams {

    @JSONField(name = "package_order")
    private String packageOrder;
}
