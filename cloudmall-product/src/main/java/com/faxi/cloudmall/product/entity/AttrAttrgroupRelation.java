package com.faxi.cloudmall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 属性&属性分组关联
 *
 * @author faxi
 * @date 2021-07-04 22:19:40
 */
@Data
@TableName("pms_attr_attrgroup_relation")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "属性&属性分组关联")
public class AttrAttrgroupRelation extends Model<AttrAttrgroupRelation> {
private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty(value="id")
    private Long id;
    /**
     * 属性id
     */
    @ApiModelProperty(value="属性id")
    private Long attrId;
    /**
     * 属性分组id
     */
    @ApiModelProperty(value="属性分组id")
    private Long attrGroupId;
    /**
     * 属性组内排序
     */
    @ApiModelProperty(value="属性组内排序")
    private Integer attrSort;
    }
