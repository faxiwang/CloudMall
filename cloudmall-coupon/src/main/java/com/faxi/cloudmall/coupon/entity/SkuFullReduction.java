package com.faxi.cloudmall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.math.BigDecimal;

/**
 * 商品满减信息
 *
 * @author faxi
 * @date 2021-07-05 21:58:42
 */
@Data
@TableName("sms_sku_full_reduction")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "商品满减信息")
public class SkuFullReduction extends Model<SkuFullReduction> {
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
    private Long skuId;
    /**
     * 满多少
     */
    @ApiModelProperty(value="满多少")
    private BigDecimal fullPrice;
    /**
     * 减多少
     */
    @ApiModelProperty(value="减多少")
    private BigDecimal reducePrice;
    /**
     * 是否参与其他优惠
     */
    @ApiModelProperty(value="是否参与其他优惠")
    private Integer addOther;
    }
