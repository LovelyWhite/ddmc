package utils;

public class Configs {

    /**
     * 默认为给到 APP
     * 如需设置小程序，请修改：
     *  appClientId 3 -> 4
     */

    public static final String stationId = "";
    public static final String addressId = "";
    public static final String cityNumber = "0101";
    public static final Double latitude = 0.00;
    public static final Double longitude = 0.00;
    public static final String appClientId = "4"; // 小程序请设置为 4

    public static final String cookie = "";
    public static final String uid = "";
    public static final String deviceToken = "";

    /**
     * 注意，小程序的 api 版本与给到不同
     * 给到: apiVersion 9.44.0、 appVersion 2.74.2
     * 小程序: apiVersion 9.49.2、 appVersion 2.82.0
     */
    public static final String apiVersion = "9.44.0";
    public static final String appVersion = "2.74.2";

}
