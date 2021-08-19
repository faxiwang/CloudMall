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
 * 
 *
 * @author faxi
 * @date 2021-07-05 22:09:27
 */
@Data
@TableName("wms_purchase_detail")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "")
public class PurchaseDetail extends Model<PurchaseDetail> {
private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @TableId
    @ApiModelProperty(value="")
    private Long id;
    /**
     * 采购单id
     */
    @ApiModelProperty(value="采购单id")
    private Long purchaseId;
    /**
     * 采购商品id
     */
    @ApiModelProperty(value="采购商品id")
    private Long skuId;
    /**
     * 采购数量
     */
    @ApiModelProperty(value="采购数量")
    private Integer skuNum;
    /**
     * 采购金额
     */
    @ApiModelProperty(value="采购金额")
    private BigDecimal skuPrice;
    /**
     * 仓库id
     */
    @ApiModelProperty(value="仓库id")
    private Long wareId;
    /**
     * 状态[0新建，1已分配，2正在采购，3已完成，4采购失败]
     */
    @ApiModelProperty(value="状态[0新建，1已分配，2正在采购，3已完成，4采购失败]")
    private Integer status;
    }
