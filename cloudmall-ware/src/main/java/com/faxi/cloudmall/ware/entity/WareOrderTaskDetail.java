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
 * 库存工作单
 *
 * @author faxi
 * @date 2021-07-05 22:09:27
 */
@Data
@TableName("wms_ware_order_task_detail")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "库存工作单")
public class WareOrderTaskDetail extends Model<WareOrderTaskDetail> {
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
     * sku_name
     */
    @ApiModelProperty(value="sku_name")
    private String skuName;
    /**
     * 购买个数
     */
    @ApiModelProperty(value="购买个数")
    private Integer skuNum;
    /**
     * 工作单id
     */
    @ApiModelProperty(value="工作单id")
    private Long taskId;
    /**
     * 仓库id
     */
    @ApiModelProperty(value="仓库id")
    private Long wareId;
    /**
     * 1-已锁定  2-已解锁  3-扣减
     */
    @ApiModelProperty(value="1-已锁定  2-已解锁  3-扣减")
    private Integer lockStatus;
    }
