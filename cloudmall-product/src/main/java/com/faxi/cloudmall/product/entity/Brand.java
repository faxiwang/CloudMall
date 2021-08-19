package com.faxi.cloudmall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.faxi.common.vaild.AddVaild;
import com.faxi.common.vaild.UpdateVaild;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;

/**
 * 品牌
 *
 * @author faxi
 * @date 2021-07-04 22:19:40
 */
@Data
@TableName("pms_brand")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "品牌")
public class Brand extends Model<Brand> {
private static final long serialVersionUID = 1L;

    /**
     * 品牌id
     */
    @TableId
    @NotNull(message = "修改必须指定ID",groups = {UpdateVaild.class})
    @Null(message = "新增不能指定ID",groups = {AddVaild.class})
    @ApiModelProperty(value="品牌id")
    private Long brandId;
    /**
     * 品牌名
     */
    @ApiModelProperty(value="品牌名")
    @NotBlank(message = "品牌名称不能为空!",groups = {UpdateVaild.class,AddVaild.class})
    private String name;
    /**
     * 品牌logo地址
     */
    @ApiModelProperty(value="品牌logo地址")
    @URL(message = "logo必须是合法的url")
    private String logo;
    /**
     * 介绍
     */
    @ApiModelProperty(value="介绍")
    private String descript;
    /**
     * 显示状态[0-不显示；1-显示]
     */
    @ApiModelProperty(value="显示状态[0-不显示；1-显示]")
    private Integer showStatus;
    /**
     * 检索首字母
     */
    @ApiModelProperty(value="检索首字母")
    @NotBlank
    @Pattern(regexp = "!/^[a-zA-Z]$/",message = "首字母必须a-z或者A-Z之间")
    private String firstLetter;
    /**
     * 排序
     */
    @ApiModelProperty(value="排序")
    @NotNull
    @Min(value = 0,message = "排序必须值必须大于0")
    private Integer sort;
    }
