package com.faxi.cloudmall.product.fallback;


import com.faxi.cloudmall.product.feign.SeckillFeignService;
import com.faxi.common.exception.BizCodeEnum;
import com.faxi.common.utis.R;
import org.springframework.stereotype.Component;



@Component
public class SeckillFeignServiceFallBack implements SeckillFeignService {
    @Override
    public R getSkuSeckilInfo(Long skuId) {
        return R.failed(BizCodeEnum.TO_MANY_REQUEST.getCode(),BizCodeEnum.TO_MANY_REQUEST.getMessage());
    }
}
