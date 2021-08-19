package com.faxi.cloudmall.coupon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.faxi.cloudmall.coupon.entity.CouponHistory;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券领取历史记录
 *
 * @author faxi
 * @date 2021-07-05 21:58:42
 */
@Mapper
public interface CouponHistoryMapper extends BaseMapper<CouponHistory> {

}
