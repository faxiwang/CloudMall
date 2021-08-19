package com.faxi.cloudmall.product.feign;


import com.faxi.common.to.SkuReductionTo;
import com.faxi.common.to.SpuBoundTo;
import com.faxi.common.utis.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient("cloudmall-coupon")
public interface CouponFeignService {

    /**
     * @param spuBoundTo
     * @return
     */
    @PostMapping("/coupon/spubounds/save")
    R saveSpuBounds(@RequestBody SpuBoundTo spuBoundTo);

    @PostMapping("/coupon/skufullreduction/saveinfo")
    R saveSkuReduction(@RequestBody SkuReductionTo skuReductionTo);
}
