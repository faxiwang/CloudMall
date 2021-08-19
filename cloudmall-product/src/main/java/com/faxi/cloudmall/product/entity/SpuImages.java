package com.faxi.cloudmall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * spu图片
 *
 * @author faxi
 * @date 2021-07-04 22:19:39
 */
@Data
@TableName("pms_spu_images")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "spu图片")
public class SpuImages extends Model<SpuImages> {
private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty(value="id")
    private Long id;
    /**
     * spu_id
     */
    @ApiModelProperty(value="spu_id")
    private Long spuId;
    /**
     * 图片名
     */
    @ApiModelProperty(value="图片名")
    private String imgName;
    /**
     * 图片地址
     */
    @ApiModelProperty(value="图片地址")
    private String imgUrl;
    /**
     * 顺序
     */
    @ApiModelProperty(value="顺序")
    private Integer imgSort;
    /**
     * 是否默认图
     */
    @ApiModelProperty(value="是否默认图")
    private Integer defaultImg;
    }
