package com.faxi.cloudmall.product.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/** faxi
 * @date 2021-08-09 21:51
 */
@Data
public class SpuSaveVo {

    private String spuName;
    private String spuDescription;
    private Long catalogId;
    private Long brandId;
    private BigDecimal weight;
    private int publishStatus;
    private List<String> decript;
    private List<String> images;
    private Bounds bounds;
    private List<BaseAttrs> baseAttrs;
    private List<Skus> skus;


}
