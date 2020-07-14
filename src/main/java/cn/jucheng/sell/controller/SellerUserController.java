package cn.jucheng.sell.controller;

import cn.jucheng.sell.config.ProjectUrl;
import cn.jucheng.sell.constant.RedisConstant;
import cn.jucheng.sell.dataobject.SellerInfo;
import cn.jucheng.sell.enums.ResultEnum;
import cn.jucheng.sell.service.SellerService;
import cn.jucheng.sell.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/seller")
public class SellerUserController {

    @Autowired
    private SellerService service;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private ProjectUrl projectUrl;

    @GetMapping("/login")
    public ModelAndView login(@RequestParam("openid") String openid, HttpServletResponse response, Map<String, Object> map){

        SellerInfo sellerInfo = service.findSellerInfoByOpenid(openid);
        if (sellerInfo == null){
            map.put("msg", ResultEnum.Login_FAIL.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error");
        }

        String token = UUID.randomUUID().toString();
        Integer expire = RedisConstant.EXPIRE;

        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX, token), openid, expire, TimeUnit.SECONDS);

        //设置cookie
        CookieUtil.set(response, "token", token, expire);
        return new ModelAndView("redirect:" + projectUrl.getSell() + "/sell/seller/order/list");
    }

//    @GetMapping("/logout")
//    public ModelAndView logout(){
//
//    }
}
