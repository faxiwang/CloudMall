package com.faxi.cloudmall.product.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @date 2021-08-09 22:51
 */
@Data
public class SkuInfoParam implements Serializable {
    private String key;
    private String catelogId;
    private String brandId;
    private String min;
    private String max;
}
