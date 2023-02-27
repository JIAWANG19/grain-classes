package com.atcjw.order.dao;

import com.atcjw.model.order.PaymentInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PaymentInfoMapperTest implements BaseMapperTest {
    @Autowired
    PaymentInfoMapper paymentInfoMapper;

    @Test
    public void testSelectList() {
        List<PaymentInfo> infos = paymentInfoMapper.selectList(null);
        infos.forEach(System.out::println);
    }
}
