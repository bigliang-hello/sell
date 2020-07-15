package cn.jucheng.sell.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    SUCCESS(0, "成功"),
    PARAMS_ERROR(1, "参数错误"),
    PRODUCT_NOT_EXIT(10, "商品不存在"),
    PRODUCT_STOCK_ERROR(11, "库存不正常"),
    ORDER_NOT_EXIST(12, "订单不存在"),
    ORDER_DETAIL_NOT_EXIST(13, "订单详情不存在"),
    ORDER_STATUS_ERROR(14, "订单状态错误"),
    ORDER_UPDATE_FAIL(15, "订单更新错误"),
    ORDER_PAY_STATUS_ERROR(16, "订单状态错误"),
    CART_EMPTY_ERROR(17, "购物车不能为空"),
    ORDER_OWNER_ERROR(18, "订单不属于你"),
    WECHAT_OATH_ERROR(19, "微信授权失败"),
    ORDER_FINISH_SUCCESS(22, "订单完成"),
    PRODUCT_STATUS_ERROR(23, "商品状态错误"),
    Login_FAIL(24, "登录失败"),
    LOGOUT_SUCCESS(26, "登出成功"),
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
