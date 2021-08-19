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
 * 商品会员价格
 *
 * @author faxi
 * @date 2021-07-05 21:58:42
 */
@Data
@TableName("sms_member_price")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "商品会员价格")
public class MemberPrice extends Model<MemberPrice> {
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
     * 会员等级id
     */
    @ApiModelProperty(value="会员等级id")
    private Long memberLevelId;
    /**
     * 会员等级名
     */
    @ApiModelProperty(value="会员等级名")
    private String memberLevelName;
    /**
     * 会员对应价格
     */
    @ApiModelProperty(value="会员对应价格")
    private BigDecimal memberPrice;
    /**
     * 可否叠加其他优惠[0-不可叠加优惠，1-可叠加]
     */
    @ApiModelProperty(value="可否叠加其他优惠[0-不可叠加优惠，1-可叠加]")
    private Integer addOther;
    }
