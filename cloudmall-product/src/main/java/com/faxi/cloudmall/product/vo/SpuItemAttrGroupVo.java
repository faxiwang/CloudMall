package com.faxi.cloudmall.product.vo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/** faxi
 * @date 2021-08-09 21:51
 */
@Data
@ToString
public class SpuItemAttrGroupVo {

    private String groupName;

    private List<AttrVo2> attrs;

}
