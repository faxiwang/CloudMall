package com.faxi.cloudmall.order.entity;

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
 * 支付信息表
 *
 * @author faxi
 * @date 2021-07-05 21:30:12
 */
@Data
@TableName("oms_payment_info")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "支付信息表")
public class PaymentInfo extends Model<PaymentInfo> {
private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty(value="id")
    private Long id;
    /**
     * 订单号（对外业务号）
     */
    @ApiModelProperty(value="订单号（对外业务号）")
    private String orderSn;
    /**
     * 订单id
     */
    @ApiModelProperty(value="订单id")
    private Long orderId;
    /**
     * 支付宝交易流水号
     */
    @ApiModelProperty(value="支付宝交易流水号")
    private String alipayTradeNo;
    /**
     * 支付总金额
     */
    @ApiModelProperty(value="支付总金额")
    private BigDecimal totalAmount;
    /**
     * 交易内容
     */
    @ApiModelProperty(value="交易内容")
    private String subject;
    /**
     * 支付状态
     */
    @ApiModelProperty(value="支付状态")
    private String paymentStatus;
    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private LocalDateTime createTime;
    /**
     * 确认时间
     */
    @ApiModelProperty(value="确认时间")
    private LocalDateTime confirmTime;
    /**
     * 回调内容
     */
    @ApiModelProperty(value="回调内容")
    private String callbackContent;
    /**
     * 回调时间
     */
    @ApiModelProperty(value="回调时间")
    private LocalDateTime callbackTime;
    }
