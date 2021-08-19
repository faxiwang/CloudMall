package com.faxi.cloudmall.product.vo;

import com.faxi.cloudmall.product.entity.Attr;
import lombok.Data;

import java.util.List;

/**
 * @date 2021-07-29 22:23
 */

@Data
public class AttrGroupWithAttrsVo {


    /**
     * 分组id
     */
    private Long attrGroupId;
    /**
     * 组名
     */
    private String attrGroupName;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 描述
     */
    private String descript;
    /**
     * 组图标
     */
    private String icon;
    /**
     * 所属分类id
     */
    private Long catelogId;

    private List<Attr> attrs;
}
