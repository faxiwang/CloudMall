package com.faxi.cloudmall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * spu属性值
 *
 * @author faxi
 * @date 2021-07-04 22:19:39
 */
@Data
@TableName("pms_product_attr_value")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "spu属性值")
public class ProductAttrValue extends Model<ProductAttrValue> {
private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty(value="id")
    private Long id;
    /**
     * 商品id
     */
    @ApiModelProperty(value="商品id")
    private Long spuId;
    /**
     * 属性id
     */
    @ApiModelProperty(value="属性id")
    private Long attrId;
    /**
     * 属性名
     */
    @ApiModelProperty(value="属性名")
    private String attrName;
    /**
     * 属性值
     */
    @ApiModelProperty(value="属性值")
    private String attrValue;
    /**
     * 顺序
     */
    @ApiModelProperty(value="顺序")
    private Integer attrSort;
    /**
     * 快速展示【是否展示在介绍上；0-否 1-是】
     */
    @ApiModelProperty(value="快速展示【是否展示在介绍上；0-否 1-是】")
    private Integer quickShow;
    }
