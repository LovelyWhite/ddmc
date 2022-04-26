# 叮咚买菜

> 由于项目更新频繁，每次使用前请拉取最新代码！！！！

~~**目前仅支持给到叮咚买菜，其他的懒得适配了，应该是通用的只需要改几个参数，我自己用不着**~~

**已支持微信小程序，Configs 中的 appClientId 设置 为 4。**

**Step0**: Star 本项目。

**Step1**: 使用抓包工具抓取 给到/小程序 叮咚买菜的请求。

抓包工具:

- Android: AndroidHttpCapture https://github.com/JZ-Darkal/AndroidHttpCapture

- IOS: Stream https://apps.apple.com/cn/app/stream/id1312141691

开启抓包后，进入购物车，重新选一下地址触发 这个 -> `GET https://sunquan.api.ddxq.mobi/api/v1/user/address` <- 请求。

**在 Query 里找到相关参数，在 Header 里找到 Cookie，在返回值里找到 addressId。**

以下为示例：

Query:

```txt
uid=62427ff916d86b0002834a53&longitude=123.693285&latitude=34.644&station_id=5b779e6d01a6eaaf09379ebc&city_number=0101&api_version=9.44.0&app_version=2.74.2&applet_source=&app_client_id=3&h5_source=gat&sharer_uid=&s_id=&openid=&device_token=BT9a60L6MXLxuPmfe6A2J%2FGN%2BOyrichLkaDQNbNssWgsAqF3zHtjLLvBzcK%2F1VsHAwYxD4ZYNII79tjxMMXqRew%3D%3D&source_type=5
```

Header:

```txt
Host: sunquan.api.ddxq.mobi
Content-Type: application/x-www-form-urlencoded
Origin: https://gat.m.ddxq.mobi
Cookie: DDXQSESSID=75d1cc10b3b06944956e2cd54b51e16a
Connection: keep-alive
Accept: application/json, text/plain, */*
User-Agent: Mozilla/5.0 (iPhone; CPU iPhone OS 15_4 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15E148 GatApp/4.3.5 com.guanaitong.Guanaitong/4.3.5.29 (iOS 15.4.0; iPhone/iPhone 12 mini/2340*1080; WWAN) Alamofire/4.8.2(language/cn)
Referer: https://gat.m.ddxq.mobi/
Accept-Language: zh-CN,zh-Hans;q=0.9
Accept-Encoding: gzip, deflate, br
```

Response:

```txt
{
  "success" : true,
  "code" : 0,
  "message" : "",
  "data" : {
    "valid_address" : [
      {
        "id" : "624280f4c1f17400017b2249",   // 这个就是 addressId
        "station_id" : "5b779e6d01a6eaaf048b9ebc",
        "label" : "",
        "village_id" : "***",
        "mobile" : "***",
        "city_number" : "0101",
        "location" : {
          "typecode" : "**",
          "id" : "****",
          "name" : "***",
          "location" : [
            ***,
            ***
          ],
          "address" : "**"
        },
        ...
      }
    ],
    ...
  }
}
```

**Step2**: 填入参数到 Configs.java 中。

|  参数   | 含义  | 示例  |
|  ----  | ----  | ----  |
| stationId | 站点 id，用于标识你是哪个站点的，比如川沙站、川南站 | 5b779e6d01a6eaaf09379ebc |
| cityNumber  | 城市代码，上海为 0101 | 0101 |
| latitude | 纬度 | 34.644 |
| longitude  | 经度 | 123.693285 |
| cookie | 用户验证信息，没有这个将无法发送请求 | DDXQSESSID=75d1cc10b3b06944956e2cd54b51e16a |
| uid  | 用户编号，你的用户 id | 62427ff916d86b0002834a53 |
| addressId  | 地址id | 624280f4c1f17400017b2249 |
| channel  | GAT 给到、WEAPP 小程序| GAT |
| TIME_RANGE  | INTERVAL_2 以两小时为间隔的时间段、INTERVAL_4、INTERVAL_8 | INTERVAL_8 |
| deviceToken | 设备编码，暂时不知道有什么用，但是必填，需要 url decode [decode tool](https://tool.chinaz.com/tools/urlencode.aspx) | BT9a60L6MXLxuPmfe6A2J... |

**Step2**: 看一下结算页面的时间段配置，然后在 Configs.java 中配置好 PERIODS，如有禁用的时间段，注释相关代码即可。

**Step4**: 将你需要的菜加入到购物车并打上勾。

**Step5**: Run Entry.main()。

**Step6**: 输入 Y，确认开始买菜。

**Step7**: 开始抢菜后会滚动刷新请求信息直到 success。

**Step8**: 打开给到叮咚/叮咚小程序付款。

## 原理

- 根据时间段建立多个线程，调用新增订单接口 /order/addNewOrder
- 时间段的定义在 Requests 中。（仅适用于上海，其他的时间段貌似不同）

## 免责声明

本项目仅供交流学习，严禁用作商业行为，特别禁止黄牛加价代抢等！

因违法违规等不当使用导致的后果与本人无关，如有任何问题可联系本人删除！

## 写在最后

祝大家平安度过疫情，不要在家饿着。 💗
