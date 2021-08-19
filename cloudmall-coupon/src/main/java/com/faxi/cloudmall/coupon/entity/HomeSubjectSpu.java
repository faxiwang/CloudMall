package com.faxi.cloudmall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 专题商品
 *
 * @author faxi
 * @date 2021-07-05 21:58:42
 */
@Data
@TableName("sms_home_subject_spu")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "专题商品")
public class HomeSubjectSpu extends Model<HomeSubjectSpu> {
private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty(value="id")
    private Long id;
    /**
     * 专题名字
     */
    @ApiModelProperty(value="专题名字")
    private String name;
    /**
     * 专题id
     */
    @ApiModelProperty(value="专题id")
    private Long subjectId;
    /**
     * spu_id
     */
    @ApiModelProperty(value="spu_id")
    private Long spuId;
    /**
     * 排序
     */
    @ApiModelProperty(value="排序")
    private Integer sort;
    }
