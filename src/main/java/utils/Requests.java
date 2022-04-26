package utils;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import model.BaseRequestParams;
import model.BaseResponseResult;
import model.cart.FetchCartResult;
import model.order.AddOrderParams;
import model.order.AddOrderResult;
import model.order.PackageOrder;
import okhttp3.*;

import java.io.IOException;
import java.net.URLEncoder;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Requests {
    private static final OkHttpClient client = new OkHttpClient();

    private static final Headers headers = new Headers.Builder()
            .set("Cookie", Configs.cookie)
            .set("ddmc-station-id", Configs.stationId)
            .set("ddmc-latitude", String.valueOf(Configs.latitude))
            .set("ddmc-longitude", String.valueOf(Configs.longitude))
            .set("ddmc-uid", Configs.uid)
            .set("ddmc-app-client-id", Configs.appClientId)
            .set("ddmc-city-number", Configs.cityNumber)
            .set("ddmc-api-version", Configs.apiVersion)
            .set("ddmc-build-version",Configs.appVersion)
            .build();

    public static List<TimeRange> getTimeRange() {
        final List<TimeRange> collect = Configs.PERIODS.stream().map(e -> new TimeRange(e, e.plusSeconds(Configs.TIME_INTERVAL))).collect(Collectors.toList());
        collect.removeIf(e -> Duration.between(LocalDateTime.now(), e.getEnd()).getSeconds() <= 30 * 60);
        if (collect.isEmpty()) {
            System.out.println("可选时间段为空");
            System.exit(0);
        }
        final LocalDateTime newStart = LocalDateTime.now().plusMinutes(5);
        final TimeRange firstTimeRange = collect.get(0);
        if (newStart.isAfter(firstTimeRange.getStart()) && newStart.isBefore(firstTimeRange.getEnd())) {
            firstTimeRange.setStart(newStart);
        }
        return collect;
    }

    public static TimeRange getRandomTimeRange() {
        final List<TimeRange> timeRange = getTimeRange();
        int randomIndex = new Random(System.currentTimeMillis()).nextInt(timeRange.size());
        return timeRange.get(randomIndex);
    }

    /**
     * 新增订单
     *
     * @param packageOrder 请求包
     */
    public static AddOrderResult addNewOrder(PackageOrder packageOrder) throws IOException {
        AddOrderParams params = new AddOrderParams();
        params.setPackageOrder(JSON.toJSONString(packageOrder));
        return baseRequest("http://maicai.api.ddxq.mobi/order/addNewOrder", "POST", params, AddOrderResult.class);
    }

    public static FetchCartResult fetchCart() throws IOException {
        BaseRequestParams params = new BaseRequestParams();
        return baseRequest("http://maicai.api.ddxq.mobi/cart/index", "GET", params, FetchCartResult.class);
    }

    /**
     * 请求函数
     *
     * @param url    请求地址
     * @param method 请求方式 POST GET PUT DELETE
     * @param params 参数
     * @param clz    返回类型
     * @param <R>    返回类型
     * @param <P>    参数类型
     * @return 请求结果
     * @throws IOException
     */
    public static <R extends BaseResponseResult, P extends BaseRequestParams> R baseRequest(String url, String method, P params, Class<R> clz) throws IOException {

        final Map<String, String> map = !Objects.isNull(params) ? JSON.parseObject(JSON.toJSONString(params), Map.class) : new HashMap<>();
        FormBody.Builder builder = new FormBody.Builder();
        Log.log("request start", url, method, map);
        if (method.equals("GET")) {
            List<String> _params = new ArrayList<>();
            map.forEach((k, v) -> {
                _params.add(URLEncoder.encode(k) + "=" + URLEncoder.encode(v));
            });
            final String join = String.join("&", _params);
            if (join.length() > 0) {
                url = url + "?" + join;
            }
        } else {
            map.forEach(builder::addEncoded);
        }
        Request request = new Request.Builder().url(url).headers(headers).method(method, "GET".equals(method) ? null : builder.build()).build();
        final Response response = client.newCall(request).execute();
        String result = Objects.requireNonNull(response.body()).string();
        if (result.contains("AssertError")) {
            result = "{\"msg\":\"AssertError\",\"code\":405,\"data\":null,\"isSuccess\":false}";
        }
        Log.log("request response", url, method, result);
        return JSON.parseObject(result, clz);
    }

    @AllArgsConstructor
    @Data
    public static class TimeRange {
        LocalDateTime start;
        LocalDateTime end;
    }
}
