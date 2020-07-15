package cn.jucheng.sell.handler;

import cn.jucheng.sell.config.ProjectUrl;
import cn.jucheng.sell.exception.SellerAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class SellExceptionHandler {

    @Autowired
    private ProjectUrl projectUrl;

    //拦截登录异常
    @ExceptionHandler(value = SellerAuthException.class)
    public ModelAndView handlerAuthException(){
        return new ModelAndView("redirect:".concat(projectUrl.getSell()).concat("/sell/seller/login"));
    }
}
