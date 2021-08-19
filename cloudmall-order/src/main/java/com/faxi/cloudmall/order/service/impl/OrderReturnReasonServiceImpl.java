package com.faxi.cloudmall.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.faxi.cloudmall.order.entity.OrderReturnReason;
import com.faxi.cloudmall.order.mapper.OrderReturnReasonMapper;
import com.faxi.cloudmall.order.service.OrderReturnReasonService;
import org.springframework.stereotype.Service;

/**
 * 退货原因
 *
 * @author faxi
 * @date 2021-07-05 21:30:12
 */
@Service
public class OrderReturnReasonServiceImpl extends ServiceImpl<OrderReturnReasonMapper, OrderReturnReason> implements OrderReturnReasonService {

}
