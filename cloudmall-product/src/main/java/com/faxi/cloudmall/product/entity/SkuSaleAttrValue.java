package com.faxi.cloudmall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * sku销售属性&值
 *
 * @author faxi
 * @date 2021-07-04 22:19:39
 */
@Data
@TableName("pms_sku_sale_attr_value")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "sku销售属性&值")
public class SkuSaleAttrValue extends Model<SkuSaleAttrValue> {
private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty(value="id")
    private Long id;
    /**
     * sku_id
     */
    @ApiModelProperty(value="sku_id")
    private Long skuId;
    /**
     * attr_id
     */
    @ApiModelProperty(value="attr_id")
    private Long attrId;
    /**
     * 销售属性名
     */
    @ApiModelProperty(value="销售属性名")
    private String attrName;
    /**
     * 销售属性值
     */
    @ApiModelProperty(value="销售属性值")
    private String attrValue;
    /**
     * 顺序
     */
    @ApiModelProperty(value="顺序")
    private Integer attrSort;
    }
