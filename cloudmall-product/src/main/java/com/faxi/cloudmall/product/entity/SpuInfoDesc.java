package com.faxi.cloudmall.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * spu信息介绍
 *
 * @author faxi
 * @date 2021-07-04 22:19:40
 */
@Data
@TableName("pms_spu_info_desc")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "spu信息介绍")
public class SpuInfoDesc extends Model<SpuInfoDesc> {
private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    @TableId(type = IdType.INPUT)
    @ApiModelProperty(value="商品id")
    private Long spuId;
    /**
     * 商品介绍
     */
    @ApiModelProperty(value="商品介绍")
    private String decript;
    }
