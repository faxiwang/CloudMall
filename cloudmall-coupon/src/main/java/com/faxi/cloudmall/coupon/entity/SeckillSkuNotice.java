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
 * 秒杀商品通知订阅
 *
 * @author faxi
 * @date 2021-07-05 21:58:42
 */
@Data
@TableName("sms_seckill_sku_notice")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "秒杀商品通知订阅")
public class SeckillSkuNotice extends Model<SeckillSkuNotice> {
private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty(value="id")
    private Long id;
    /**
     * member_id
     */
    @ApiModelProperty(value="member_id")
    private Long memberId;
    /**
     * sku_id
     */
    @ApiModelProperty(value="sku_id")
    private Long skuId;
    /**
     * 活动场次id
     */
    @ApiModelProperty(value="活动场次id")
    private Long sessionId;
    /**
     * 订阅时间
     */
    @ApiModelProperty(value="订阅时间")
    private LocalDateTime subcribeTime;
    /**
     * 发送时间
     */
    @ApiModelProperty(value="发送时间")
    private LocalDateTime sendTime;
    /**
     * 通知方式[0-短信，1-邮件]
     */
    @ApiModelProperty(value="通知方式[0-短信，1-邮件]")
    private Integer noticeType;
    }
