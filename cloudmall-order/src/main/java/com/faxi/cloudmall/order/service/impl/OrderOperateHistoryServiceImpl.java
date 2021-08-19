package com.faxi.cloudmall.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.faxi.cloudmall.order.entity.OrderOperateHistory;
import com.faxi.cloudmall.order.mapper.OrderOperateHistoryMapper;
import com.faxi.cloudmall.order.service.OrderOperateHistoryService;
import org.springframework.stereotype.Service;

/**
 * 订单操作历史记录
 *
 * @author faxi
 * @date 2021-07-05 21:30:12
 */
@Service
public class OrderOperateHistoryServiceImpl extends ServiceImpl<OrderOperateHistoryMapper, OrderOperateHistory> implements OrderOperateHistoryService {

}
