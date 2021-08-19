package com.faxi.cloudmall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 商品评价
 *
 * @author faxi
 * @date 2021-07-04 22:19:39
 */
@Data
@TableName("pms_spu_comment")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "商品评价")
public class SpuComment extends Model<SpuComment> {
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
     * spu_id
     */
    @ApiModelProperty(value="spu_id")
    private Long spuId;
    /**
     * 商品名字
     */
    @ApiModelProperty(value="商品名字")
    private String spuName;
    /**
     * 会员昵称
     */
    @ApiModelProperty(value="会员昵称")
    private String memberNickName;
    /**
     * 星级
     */
    @ApiModelProperty(value="星级")
    private Integer star;
    /**
     * 会员ip
     */
    @ApiModelProperty(value="会员ip")
    private String memberIp;
    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private LocalDateTime createTime;
    /**
     * 显示状态[0-不显示，1-显示]
     */
    @ApiModelProperty(value="显示状态[0-不显示，1-显示]")
    private Integer showStatus;
    /**
     * 购买时属性组合
     */
    @ApiModelProperty(value="购买时属性组合")
    private String spuAttributes;
    /**
     * 点赞数
     */
    @ApiModelProperty(value="点赞数")
    private Integer likesCount;
    /**
     * 回复数
     */
    @ApiModelProperty(value="回复数")
    private Integer replyCount;
    /**
     * 评论图片/视频[json数据；[{type:文件类型,url:资源路径}]]
     */
    @ApiModelProperty(value="评论图片/视频[json数据；[{type:文件类型,url:资源路径}]]")
    private String resources;
    /**
     * 内容
     */
    @ApiModelProperty(value="内容")
    private String content;
    /**
     * 用户头像
     */
    @ApiModelProperty(value="用户头像")
    private String memberIcon;
    /**
     * 评论类型[0 - 对商品的直接评论，1 - 对评论的回复]
     */
    @ApiModelProperty(value="评论类型[0 - 对商品的直接评论，1 - 对评论的回复]")
    private Integer commentType;
    }
