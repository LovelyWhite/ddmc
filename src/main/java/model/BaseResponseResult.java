package model;

import lombok.Data;

@Data
public class BaseResponseResult {
    private Integer code = -1;
    private String msg;
    private Boolean success;
}
