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
 * 仓库信息
 *
 * @author faxi
 * @date 2021-07-05 22:09:27
 */
@Data
@TableName("wms_ware_info")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "仓库信息")
public class WareInfo extends Model<WareInfo> {
private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty(value="id")
    private Long id;
    /**
     * 仓库名
     */
    @ApiModelProperty(value="仓库名")
    private String name;
    /**
     * 仓库地址
     */
    @ApiModelProperty(value="仓库地址")
    private String address;
    /**
     * 区域编码
     */
    @ApiModelProperty(value="区域编码")
    private String areacode;
    }
