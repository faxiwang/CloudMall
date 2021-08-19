package com.faxi.cloudmall.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.faxi.cloudmall.order.entity.PaymentInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 支付信息表
 *
 * @author faxi
 * @date 2021-07-05 21:30:12
 */
@Mapper
public interface PaymentInfoMapper extends BaseMapper<PaymentInfo> {

}
