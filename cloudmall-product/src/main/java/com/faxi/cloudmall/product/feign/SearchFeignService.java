package com.faxi.cloudmall.product.feign;


import com.faxi.common.utis.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@FeignClient("cloudmall-search")
public interface SearchFeignService {

//    @PostMapping(value = "/search/save/product")
//    public R productStatusUp(@RequestBody List<SkuEsModel> skuEsModels);

}
