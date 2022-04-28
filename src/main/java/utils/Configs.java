package utils;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.*;

/**
 * 配置项
 */
public class Configs {

    /**
     * 基础信息配置：请参照 README.md 填写下列参数。
     */
    public static final String stationId = "";
    public static final String addressId = "";
    public static final String cityNumber = "";
    public static final Double latitude = 0.0;
    public static final Double longitude = 0.0;
    public static final String cookie = "";
    public static final String uid = "";
    public static final String deviceToken = "";

    /**
     * 渠道配置：目前支持
     * - GAT 给到
     * - WEAPP 小程序
     * - CUSTOM 自定义
     * 给到、小程序的参数已经配置好，只需配置下面的 channel 即可
     */

    public static final String channel = "WEAPP";

    /**
     * 时间段配置：
     * - INTERVAL_2  2 小时间隔
     * 6:30 - 8:30、 8:30 - 10:30、 10:30 - 12:30 ... 20:30 - 22:30
     * - INTERVAL_4  4 小时间隔
     * 6:30 - 10:30、 10:30 - 14:30、 14:30 - 18:30、 18:30 - 22:30
     * - INTERVAL_8  8 小时间隔
     * 6:30 - 14:30、 14:30 - 22:30
     * - AUTO 自动选择可选时间 ps: 有时候早上的时候时间段会变成这个，实际上请求的时间段是 2023-03-30 05:00:00 - 2023-03-30 23:00:00
     * <p>
     * 由于时间段有时会更新，所以需要配置一下时间段，单位 秒
     * 请根据购物车结算页面实际的日期范围填写
     * 如需禁用某个具体的某个时间段，将该时间段注释掉即可。
     */
    public static final String TIME_RANGE = "AUTO";

    /*
     * 当渠道选择为 CUSTOM 时请配置 CUSTOM 对应的 channel
     */
    private static final Map<String, Channel> CHANNELS = new HashMap<String, Channel>() {{
        put("GAT", new Channel("3", 11, "9.44.0", "2.74.2"));
        put("WEAPP", new Channel("4", 6, "9.49.2", "2.82.0"));
        put("CUSTOM", new Channel("", -1, "", ""));
    }};

    private static final LocalDateTime TODAY_ZERO = getTodayZero();

    private static final Map<String, List<LocalDateTime>> TIME_RANGES = new HashMap<String, List<LocalDateTime>>() {{
        put("INTERVAL_2", Arrays.asList(
                TODAY_ZERO.plusSeconds(BEGIN),   // 6:30 - 8:30
                TODAY_ZERO.plusSeconds(BEGIN + 2 * 60 * 60), // 8:30 - 10:30
                TODAY_ZERO.plusSeconds(BEGIN + 2 * 2 * 60 * 60), // 10:30 - 12:30
                TODAY_ZERO.plusSeconds(BEGIN + 3 * 2 * 60 * 60), // 12:30 - 14:30
                TODAY_ZERO.plusSeconds(BEGIN + 4 * 2 * 60 * 60), // 14:30 - 16:30
                TODAY_ZERO.plusSeconds(BEGIN + 5 * 2 * 60 * 60), // 16:30 - 18:30
                TODAY_ZERO.plusSeconds(BEGIN + 6 * 2 * 60 * 60), // 18:30 - 20:30
                TODAY_ZERO.plusSeconds(BEGIN + 7 * 2 * 60 * 60)) // 20:30 - 22:30 (注释掉以后将不会下单到此时间))
        );
        put("INTERVAL_4", Arrays.asList(
                TODAY_ZERO.plusSeconds(BEGIN),   // 6:30 - 10:30
                TODAY_ZERO.plusSeconds(BEGIN + 4 * 60 * 60), // 10:30 - 14:30
                TODAY_ZERO.plusSeconds(BEGIN + 2 * 4 * 60 * 60), // 14:30 - 18:30
                TODAY_ZERO.plusSeconds(BEGIN + 3 * 4 * 60 * 60)) // 18:30 - 22:30
        );
        put("INTERVAL_8", Arrays.asList(
                TODAY_ZERO.plusSeconds(BEGIN),   // 6:30 - 14:30
                TODAY_ZERO.plusSeconds(BEGIN + 8 * 60 * 60)) // 14:30 - 22:30
        );
        put("AUTO", Collections.singletonList(LocalDateTime.of(2023, 3, 30, 5, 0, 0)));
    }};

    private static final Map<String, Integer> TIME_INTERVALS = new HashMap<String, Integer>() {{
        put("INTERVAL_2", 60 * 60);
        put("INTERVAL_4", 4 * 60 * 60);
        put("INTERVAL_8", 8 * 60 * 60);
        put("AUTO", 18 * 60 * 60);
    }};

    public static final long TIME_INTERVAL = TIME_INTERVALS.get(TIME_RANGE);
    public static final List<LocalDateTime> PERIODS = TIME_RANGES.get(TIME_RANGE);
    public static final long BEGIN = 6 * 60 * 60 + 30 * 60;

    private static LocalDateTime getTodayZero() {
        return LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0);
    }

    public static final String appClientId = CHANNELS.get(channel).appClientId;
    public static final Integer payType = CHANNELS.get(channel).payType;
    public static final String apiVersion = CHANNELS.get(channel).apiVersion;
    public static final String appVersion = CHANNELS.get(channel).appVersion;

    @AllArgsConstructor
    public static class Channel {
        private String appClientId;
        private Integer payType;
        private String apiVersion;
        private String appVersion;
    }
}
