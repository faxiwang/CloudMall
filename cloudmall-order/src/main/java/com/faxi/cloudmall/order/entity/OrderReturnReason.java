package com.faxi.cloudmall.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 退货原因
 *
 * @author faxi
 * @date 2021-07-05 21:30:12
 */
@Data
@TableName("oms_order_return_reason")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "退货原因")
public class OrderReturnReason extends Model<OrderReturnReason> {
private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty(value="id")
    private Long id;
    /**
     * 退货原因名
     */
    @ApiModelProperty(value="退货原因名")
    private String name;
    /**
     * 排序
     */
    @ApiModelProperty(value="排序")
    private Integer sort;
    /**
     * 启用状态
     */
    @ApiModelProperty(value="启用状态")
    private Integer status;
    /**
     * create_time
     */
    @ApiModelProperty(value="create_time")
    private LocalDateTime createTime;
    }
