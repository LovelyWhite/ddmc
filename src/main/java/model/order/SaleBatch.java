package model.order;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class SaleBatch {

    @JSONField(name = "batch_type")
    private Integer batchType;
}