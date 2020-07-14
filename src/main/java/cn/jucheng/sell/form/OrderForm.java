package cn.jucheng.sell.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class OrderForm {

    @NotEmpty(message = "姓名不为空")
    private String name;

    @NotEmpty(message = "手机号不为空")
    private String phone;

    @NotEmpty(message = "地址不为空")
    private String address;

    @NotEmpty(message = "openid必填")
    private String openid;

    @NotEmpty(message = "购物车不为空")
    private String items;

}
