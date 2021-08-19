package com.faxi.cloudmall.product.vo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/** faxi
 * @date 2021-08-09 21:53
 */

@Data
@ToString
public class SkuItemSaleAttrVo {

    private Long attrId;

    private String attrName;

    private List<AttrValueWithSkuIdVo> attrValues;

}
