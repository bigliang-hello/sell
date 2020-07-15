package cn.jucheng.sell.service;

import cn.jucheng.sell.dto.OrderDTO;

public interface PushService {

    void orderStatus(OrderDTO orderDTO);
}
