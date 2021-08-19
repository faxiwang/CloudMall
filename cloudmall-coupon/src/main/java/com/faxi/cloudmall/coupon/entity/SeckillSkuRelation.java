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
 * 秒杀活动商品关联
 *
 * @author faxi
 * @date 2021-07-05 21:58:42
 */
@Data
@TableName("sms_seckill_sku_relation")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "秒杀活动商品关联")
public class SeckillSkuRelation extends Model<SeckillSkuRelation> {
private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty(value="id")
    private Long id;
    /**
     * 活动id
     */
    @ApiModelProperty(value="活动id")
    private Long promotionId;
    /**
     * 活动场次id
     */
    @ApiModelProperty(value="活动场次id")
    private Long promotionSessionId;
    /**
     * 商品id
     */
    @ApiModelProperty(value="商品id")
    private Long skuId;
    /**
     * 秒杀价格
     */
    @ApiModelProperty(value="秒杀价格")
    private BigDecimal seckillPrice;
    /**
     * 秒杀总量
     */
    @ApiModelProperty(value="秒杀总量")
    private BigDecimal seckillCount;
    /**
     * 每人限购数量
     */
    @ApiModelProperty(value="每人限购数量")
    private BigDecimal seckillLimit;
    /**
     * 排序
     */
    @ApiModelProperty(value="排序")
    private Integer seckillSort;
    }
