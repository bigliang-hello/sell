package cn.jucheng.sell.service.impl;

import cn.jucheng.sell.dataobject.SellerInfo;
import cn.jucheng.sell.repository.SellerInfoRepository;
import cn.jucheng.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}
