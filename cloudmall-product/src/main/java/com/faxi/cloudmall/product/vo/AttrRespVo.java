package com.faxi.cloudmall.product.vo;

import lombok.Data;

/** faxi
 * @date 2021-08-02 21:37
 */
@Data
public class AttrRespVo extends AttrVo {

    private String catelogName;

    private String groupName;

    private Long[] catelogPath;

}