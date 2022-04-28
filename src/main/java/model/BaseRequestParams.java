package model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import utils.Configs;

@Data
public class BaseRequestParams {

    private String uid = Configs.uid;
    private String longitude = String.valueOf(Configs.longitude);
    private String latitude = String.valueOf(Configs.latitude);
    @JSONField(name = "station_id")
    private String stationId = Configs.stationId;
    @JSONField(name = "city_number")
    private String cityNumber = Configs.cityNumber;
    @JSONField(name = "api_version")
    private String apiVersion = Configs.apiVersion;
    @JSONField(name = "app_version")
    private String appVersion = Configs.appVersion;
    @JSONField(name = "applet_source")
    private String appletSource = "";
    @JSONField(name = "app_client_id")
    private String appClientId = Configs.appClientId;
    @JSONField(name = "h5_source")
    private String h5Source = "gat";
    @JSONField(name = "sharer_uid")
    private String sharerUid = "";
    @JSONField(name = "s_id")
    private String sId = "";
    private String openid = "";
    @JSONField(name = "device_token")
    private String deviceToken = Configs.deviceToken;
    @JSONField(name = "is_load")
    private String isLoad = "1";
    @JSONField(name = "ab_config")
    private String abConfig = "{\"key_onion\":\"C\"}";
    private String sesi;
    private String nars;
}
