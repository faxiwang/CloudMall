package com.faxi.cloudmall.product.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 属性分组
 *
 * @author faxi
 * @date 2021-07-04 22:19:40
 */
@Data
@TableName("pms_attr_group")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "属性分组")
public class AttrGroup extends Model<AttrGroup> {
private static final long serialVersionUID = 1L;

    /**
     * 分组id
     */
    @TableId
    @ApiModelProperty(value="分组id")
    private Long attrGroupId;
    /**
     * 组名
     */
    @ApiModelProperty(value="组名")
    private String attrGroupName;
    /**
     * 排序
     */
    @ApiModelProperty(value="排序")
    private Integer sort;
    /**
     * 描述
     */
    @ApiModelProperty(value="描述")
    private String descript;
    /**
     * 组图标
     */
    @ApiModelProperty(value="组图标")
    private String icon;
    /**
     * 所属分类id
     */
    @ApiModelProperty(value="所属分类id")
    private Long catelogId;

    @TableField(exist = false)
    private Long[] catelogPath;
    }
