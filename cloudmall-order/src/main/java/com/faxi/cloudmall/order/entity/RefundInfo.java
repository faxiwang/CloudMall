package com.faxi.cloudmall.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.math.BigDecimal;

/**
 * 退款信息
 *
 * @author faxi
 * @date 2021-07-05 21:30:11
 */
@Data
@TableName("oms_refund_info")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "退款信息")
public class RefundInfo extends Model<RefundInfo> {
private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty(value="id")
    private Long id;
    /**
     * 退款的订单
     */
    @ApiModelProperty(value="退款的订单")
    private Long orderReturnId;
    /**
     * 退款金额
     */
    @ApiModelProperty(value="退款金额")
    private BigDecimal refund;
    /**
     * 退款交易流水号
     */
    @ApiModelProperty(value="退款交易流水号")
    private String refundSn;
    /**
     * 退款状态
     */
    @ApiModelProperty(value="退款状态")
    private Integer refundStatus;
    /**
     * 退款渠道[1-支付宝，2-微信，3-银联，4-汇款]
     */
    @ApiModelProperty(value="退款渠道[1-支付宝，2-微信，3-银联，4-汇款]")
    private Integer refundChannel;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String refundContent;
    }
