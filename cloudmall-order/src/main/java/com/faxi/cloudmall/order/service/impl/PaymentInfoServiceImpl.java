package com.faxi.cloudmall.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.faxi.cloudmall.order.entity.PaymentInfo;
import com.faxi.cloudmall.order.mapper.PaymentInfoMapper;
import com.faxi.cloudmall.order.service.PaymentInfoService;
import org.springframework.stereotype.Service;

/**
 * 支付信息表
 *
 * @author faxi
 * @date 2021-07-05 21:30:12
 */
@Service
public class PaymentInfoServiceImpl extends ServiceImpl<PaymentInfoMapper, PaymentInfo> implements PaymentInfoService {

}
