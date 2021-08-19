package com.faxi.cloudmall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
 *
 * @author faxi
 * @date 2021-07-05 21:58:42
 */
@Data
@TableName("sms_home_subject")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】")
public class HomeSubject extends Model<HomeSubject> {
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
     * 专题标题
     */
    @ApiModelProperty(value="专题标题")
    private String title;
    /**
     * 专题副标题
     */
    @ApiModelProperty(value="专题副标题")
    private String subTitle;
    /**
     * 显示状态
     */
    @ApiModelProperty(value="显示状态")
    private Integer status;
    /**
     * 详情连接
     */
    @ApiModelProperty(value="详情连接")
    private String url;
    /**
     * 排序
     */
    @ApiModelProperty(value="排序")
    private Integer sort;
    /**
     * 专题图片地址
     */
    @ApiModelProperty(value="专题图片地址")
    private String img;
    }
