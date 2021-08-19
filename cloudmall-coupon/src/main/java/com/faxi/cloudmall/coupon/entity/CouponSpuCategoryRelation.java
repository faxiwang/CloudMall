package com.faxi.cloudmall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 优惠券分类关联
 *
 * @author faxi
 * @date 2021-07-05 21:58:42
 */
@Data
@TableName("sms_coupon_spu_category_relation")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "优惠券分类关联")
public class CouponSpuCategoryRelation extends Model<CouponSpuCategoryRelation> {
private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty(value="id")
    private Long id;
    /**
     * 优惠券id
     */
    @ApiModelProperty(value="优惠券id")
    private Long couponId;
    /**
     * 产品分类id
     */
    @ApiModelProperty(value="产品分类id")
    private Long categoryId;
    /**
     * 产品分类名称
     */
    @ApiModelProperty(value="产品分类名称")
    private String categoryName;
    }
