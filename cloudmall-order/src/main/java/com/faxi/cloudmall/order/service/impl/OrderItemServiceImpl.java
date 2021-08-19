package com.faxi.cloudmall.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.faxi.cloudmall.order.entity.OrderItem;
import com.faxi.cloudmall.order.mapper.OrderItemMapper;
import com.faxi.cloudmall.order.service.OrderItemService;
import org.springframework.stereotype.Service;

/**
 * 订单项信息
 *
 * @author faxi
 * @date 2021-07-05 21:30:12
 */
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements OrderItemService {

}
