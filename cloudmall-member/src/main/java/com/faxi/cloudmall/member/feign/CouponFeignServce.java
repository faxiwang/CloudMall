package com.faxi.cloudmall.member.feign;

import com.faxi.common.utis.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @date 2021-07-07 21:31
 */
@FeignClient("cloudmall-coupon")
public interface CouponFeignServce {

    @GetMapping("/coupon/coupon/getcoupon")
    public R getcoupon();
}
