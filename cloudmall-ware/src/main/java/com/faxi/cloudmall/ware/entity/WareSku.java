package com.faxi.cloudmall.ware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 商品库存
 *
 * @author faxi
 * @date 2021-07-05 22:09:27
 */
@Data
@TableName("wms_ware_sku")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "商品库存")
public class WareSku extends Model<WareSku> {
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
     * 仓库id
     */
    @ApiModelProperty(value="仓库id")
    private Long wareId;
    /**
     * 库存数
     */
    @ApiModelProperty(value="库存数")
    private Integer stock;
    /**
     * sku_name
     */
    @ApiModelProperty(value="sku_name")
    private String skuName;
    /**
     * 锁定库存
     */
    @ApiModelProperty(value="锁定库存")
    private Integer stockLocked;
    }
