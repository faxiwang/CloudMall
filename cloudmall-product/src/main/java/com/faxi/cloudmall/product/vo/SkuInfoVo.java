package com.faxi.cloudmall.product.vo;

import lombok.Data;
import lombok.ToString;

/**
 * @date 2021-08-17 22:14
 */
@Data
@ToString
public class SkuInfoVo {
    private String key;
    private String catelogId;
    private String brandId;
    private String min;
    private String max;
}
