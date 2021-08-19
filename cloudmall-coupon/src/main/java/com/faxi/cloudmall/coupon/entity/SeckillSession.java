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
 * 秒杀活动场次
 *
 * @author faxi
 * @date 2021-07-05 21:58:42
 */
@Data
@TableName("sms_seckill_session")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "秒杀活动场次")
public class SeckillSession extends Model<SeckillSession> {
private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty(value="id")
    private Long id;
    /**
     * 场次名称
     */
    @ApiModelProperty(value="场次名称")
    private String name;
    /**
     * 每日开始时间
     */
    @ApiModelProperty(value="每日开始时间")
    private LocalDateTime startTime;
    /**
     * 每日结束时间
     */
    @ApiModelProperty(value="每日结束时间")
    private LocalDateTime endTime;
    /**
     * 启用状态
     */
    @ApiModelProperty(value="启用状态")
    private Integer status;
    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private LocalDateTime createTime;
    }
