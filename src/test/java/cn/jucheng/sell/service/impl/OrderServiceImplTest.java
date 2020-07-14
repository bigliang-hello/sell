package cn.jucheng.sell.service.impl;

import cn.jucheng.sell.dataobject.OrderDetail;
import cn.jucheng.sell.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    @Test
    void createOrder() throws Exception {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("igliang");
        orderDTO.setBuyerAddress("ruihe");
        orderDTO.setBuyerPhone("16632222222");
        orderDTO.setBuyerOpenid("21212");

        List<OrderDetail> orderDetailList = new ArrayList<>();

        OrderDetail o1 = new OrderDetail();
        o1.setProductId("1");
        o1.setProductQuantity(1);

        OrderDetail o2 = new OrderDetail();
        o2.setProductId("2");
        o2.setProductQuantity(2);

        orderDetailList.add(o1);
        orderDetailList.add(o2);

        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result = orderService.createOrder(orderDTO);

        log.info("result={}", result);
    }

    @Test
    void findOne() {
    }

    @Test
    void findList() {
    }

    @Test
    void cancel() {
        OrderDTO orderDTO = orderService.findOne("1594266713530989767");
        orderService.cancel(orderDTO);
    }

    @Test
    void finish() {
    }

    @Test
    void paid() {
    }
}