package com.faxi.cloudmall.coupon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.faxi.cloudmall.coupon.entity.CouponSpuRelation;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券与产品关联
 *
 * @author faxi
 * @date 2021-07-05 21:58:42
 */
@Mapper
public interface CouponSpuRelationMapper extends BaseMapper<CouponSpuRelation> {

}
