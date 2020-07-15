package cn.jucheng.sell.service.impl;

import cn.jucheng.sell.service.PushService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class PushServiceImplTest {


    @Autowired
    private PushService service;

    @Test
    public void test(){
        service.orderStatus(null);
    }
}