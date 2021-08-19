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
 * 商品阶梯价格
 *
 * @author faxi
 * @date 2021-07-05 21:58:41
 */
@Data
@TableName("sms_sku_ladder")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "商品阶梯价格")
public class SkuLadder extends Model<SkuLadder> {
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
     * 满几件
     */
    @ApiModelProperty(value="满几件")
    private Integer fullCount;
    /**
     * 打几折
     */
    @ApiModelProperty(value="打几折")
    private BigDecimal discount;
    /**
     * 折后价
     */
    @ApiModelProperty(value="折后价")
    private BigDecimal price;
    /**
     * 是否叠加其他优惠[0-不可叠加，1-可叠加]
     */
    @ApiModelProperty(value="是否叠加其他优惠[0-不可叠加，1-可叠加]")
    private Integer addOther;
    }
