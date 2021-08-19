package com.faxi.cloudmall.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.faxi.cloudmall.order.entity.Order;
import com.faxi.cloudmall.order.mapper.OrderMapper;
import com.faxi.cloudmall.order.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * 订单
 *
 * @author faxi
 * @date 2021-07-05 21:30:12
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
