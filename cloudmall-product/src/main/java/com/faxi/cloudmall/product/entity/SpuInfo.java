package com.faxi.cloudmall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * spu信息
 *
 * @author faxi
 * @date 2021-07-04 22:19:39
 */
@Data
@TableName("pms_spu_info")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "spu信息")
public class SpuInfo extends Model<SpuInfo> {
private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    @TableId
    @ApiModelProperty(value="商品id")
    private Long id;
    /**
     * 商品名称
     */
    @ApiModelProperty(value="商品名称")
    private String spuName;
    /**
     * 商品描述
     */
    @ApiModelProperty(value="商品描述")
    private String spuDescription;
    /**
     * 所属分类id
     */
    @ApiModelProperty(value="所属分类id")
    private Long catalogId;
    /**
     * 品牌id
     */
    @ApiModelProperty(value="品牌id")
    private Long brandId;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private BigDecimal weight;
    /**
     * 上架状态[0 - 下架，1 - 上架]
     */
    @ApiModelProperty(value="上架状态[0 - 下架，1 - 上架]")
    private Integer publishStatus;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private LocalDateTime createTime;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private LocalDateTime updateTime;
    }
