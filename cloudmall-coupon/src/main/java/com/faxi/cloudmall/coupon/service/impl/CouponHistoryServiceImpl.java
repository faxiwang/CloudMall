package com.faxi.cloudmall.coupon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.faxi.cloudmall.coupon.entity.CouponHistory;
import com.faxi.cloudmall.coupon.mapper.CouponHistoryMapper;
import com.faxi.cloudmall.coupon.service.CouponHistoryService;
import org.springframework.stereotype.Service;

/**
 * 优惠券领取历史记录
 *
 * @author faxi
 * @date 2021-07-05 21:58:42
 */
@Service
public class CouponHistoryServiceImpl extends ServiceImpl<CouponHistoryMapper, CouponHistory> implements CouponHistoryService {

}
