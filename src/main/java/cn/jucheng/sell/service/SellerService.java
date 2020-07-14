package cn.jucheng.sell.service;

import cn.jucheng.sell.dataobject.SellerInfo;

public interface SellerService {

    SellerInfo findSellerInfoByOpenid(String openid);
}
