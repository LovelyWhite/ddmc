# 给到叮咚买菜

**目前仅支持给到叮咚买菜，其他的懒得适配了，应该是通用的只需要改几个参数，我自己用不着**

Step1: 使用抓包工具抓取给到叮咚买菜的请求。

Step2: 填入参数到 configs.java 中。

- stationId: 站点 id  // 川东站: 5d52973126c3d1af2f8b4570
- cityNumber: 城市代码 // shanghai: 0101
- latitude: 纬度
- longitude: 精度
- COOKIE: cookie
- uid: 用户编号
- deviceToken: 设备 token

Step3: 将你需要的菜加入到购物车并打上勾。

Step4: Run Entry.main，会自动拉你的购物车。

Step5: 打开给到叮咚付款

**tip 最好在第一个 init（请求购物车并构造新订单参数） 之后暂停，等到点了再继续（提前请求购物车**

## 原理

- 根据时间段建立多个线程，调用新增订单接口 /order/addNewOrder
- 时间段的定义在 Requests 中。（仅适用于上海，其他的时间段貌似不同）

## 免责声明

仅供学习交流
