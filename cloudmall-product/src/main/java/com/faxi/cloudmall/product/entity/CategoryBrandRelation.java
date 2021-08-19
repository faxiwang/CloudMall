package com.faxi.cloudmall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 品牌分类关联
 *
 * @author faxi
 * @date 2021-07-04 22:19:39
 */
@Data
@TableName("pms_category_brand_relation")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "品牌分类关联")
public class CategoryBrandRelation extends Model<CategoryBrandRelation> {
private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @TableId
    @ApiModelProperty(value="")
    private Long id;
    /**
     * 品牌id
     */
    @ApiModelProperty(value="品牌id")
    private Long brandId;
    /**
     * 分类id
     */
    @ApiModelProperty(value="分类id")
    private Long catelogId;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String brandName;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String catelogName;
    }
