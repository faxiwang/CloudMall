package com.faxi.cloudmall.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.faxi.cloudmall.order.entity.OrderItem;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 *
 * @author faxi
 * @date 2021-07-05 21:30:12
 */
@Mapper
public interface OrderItemMapper extends BaseMapper<OrderItem> {

}
