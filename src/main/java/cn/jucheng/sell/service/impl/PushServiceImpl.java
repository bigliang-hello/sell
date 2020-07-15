package cn.jucheng.sell.service.impl;

import cn.jucheng.sell.dto.OrderDTO;
import cn.jucheng.sell.service.PushService;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PushServiceImpl implements PushService {

    @Autowired
    private WxMpService service;

    @Override
    public void orderStatus(OrderDTO orderDTO) {
        WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
        templateMessage.setTemplateId("M_HWVJssruzfQV6ui0RxVMnRxSwZUjydns6tt-9tyeg");
        templateMessage.setToUser("ocqdywgcoHk7AwGI-n9ylUIEssxo");
        List<WxMpTemplateData> dataList = Arrays.asList(
                new WxMpTemplateData("name", "bigliang")
        );
        templateMessage.setData(dataList);
        try {
            service.getTemplateMsgService().sendTemplateMsg(templateMessage);
        }catch (WxErrorException e){
            System.out.println("WxErrorException:" + e.getMessage());
        }

    }
}
