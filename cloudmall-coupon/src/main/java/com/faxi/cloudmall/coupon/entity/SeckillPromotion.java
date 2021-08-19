package com.faxi.cloudmall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 秒杀活动
 *
 * @author faxi
 * @date 2021-07-05 21:58:42
 */
@Data
@TableName("sms_seckill_promotion")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "秒杀活动")
public class SeckillPromotion extends Model<SeckillPromotion> {
private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty(value="id")
    private Long id;
    /**
     * 活动标题
     */
    @ApiModelProperty(value="活动标题")
    private String title;
    /**
     * 开始日期
     */
    @ApiModelProperty(value="开始日期")
    private LocalDateTime startTime;
    /**
     * 结束日期
     */
    @ApiModelProperty(value="结束日期")
    private LocalDateTime endTime;
    /**
     * 上下线状态
     */
    @ApiModelProperty(value="上下线状态")
    private Integer status;
    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private LocalDateTime createTime;
    /**
     * 创建人
     */
    @ApiModelProperty(value="创建人")
    private Long userId;
    }
