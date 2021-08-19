package com.faxi.cloudmall.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.faxi.cloudmall.order.entity.OrderSetting;
import com.faxi.cloudmall.order.mapper.OrderSettingMapper;
import com.faxi.cloudmall.order.service.OrderSettingService;
import org.springframework.stereotype.Service;

/**
 * 订单配置信息
 *
 * @author faxi
 * @date 2021-07-05 21:30:12
 */
@Service
public class OrderSettingServiceImpl extends ServiceImpl<OrderSettingMapper, OrderSetting> implements OrderSettingService {

}
