package cn.jucheng.sell.aspect;

import cn.jucheng.sell.constant.RedisConstant;
import cn.jucheng.sell.exception.SellerAuthException;
import cn.jucheng.sell.utils.CookieUtil;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class TestAspect {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Before("execution(public * cn.jucheng.sell.controller.Seller*.*(..))" +
            "&& !execution(public * cn.jucheng.sell.controller.SellerUserController.*(..))")
    public void doVerify(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        Cookie cookie = CookieUtil.get(request, "token");
        if (cookie == null){
            throw new SellerAuthException();
        }

        String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));
        if (StringUtils.isEmpty(tokenValue)){
            throw new SellerAuthException();
        }
    }
}
