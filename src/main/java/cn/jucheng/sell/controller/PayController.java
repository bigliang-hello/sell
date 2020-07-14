package cn.jucheng.sell.controller;

import cn.jucheng.sell.dto.OrderDTO;
import cn.jucheng.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/pay")
@Slf4j
public class PayController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId, @RequestParam("returnUrl") String returnUrl){
        Map<String, String> map = new HashMap<>();
        map.put("returnUrl", returnUrl);

        //直接支付
        OrderDTO orderDTO = orderService.findOne(orderId);
        orderService.paid(orderDTO);
        return new ModelAndView("pay/create", map);
    }
}
