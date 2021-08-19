package com.faxi.cloudmall.ware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.math.BigDecimal;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 采购信息
 *
 * @author faxi
 * @date 2021-07-05 22:09:27
 */
@Data
@TableName("wms_purchase")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "采购信息")
public class Purchase extends Model<Purchase> {
private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @TableId
    @ApiModelProperty(value="")
    private Long id;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Long assigneeId;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String assigneeName;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String phone;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Integer priority;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Integer status;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Long wareId;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private BigDecimal amount;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private LocalDateTime createTime;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private LocalDateTime updateTime;
    }
