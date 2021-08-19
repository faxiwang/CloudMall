package com.faxi.cloudmall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * sku图片
 *
 * @author faxi
 * @date 2021-07-04 22:19:39
 */
@Data
@TableName("pms_sku_images")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "sku图片")
public class SkuImages extends Model<SkuImages> {
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
     * 图片地址
     */
    @ApiModelProperty(value="图片地址")
    private String imgUrl;
    /**
     * 排序
     */
    @ApiModelProperty(value="排序")
    private Integer imgSort;
    /**
     * 默认图[0 - 不是默认图，1 - 是默认图]
     */
    @ApiModelProperty(value="默认图[0 - 不是默认图，1 - 是默认图]")
    private Integer defaultImg;
    }
