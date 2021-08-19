package com.faxi.cloudmall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 商品评价回复关系
 *
 * @author faxi
 * @date 2021-07-04 22:19:39
 */
@Data
@TableName("pms_comment_replay")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "商品评价回复关系")
public class CommentReplay extends Model<CommentReplay> {
private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty(value="id")
    private Long id;
    /**
     * 评论id
     */
    @ApiModelProperty(value="评论id")
    private Long commentId;
    /**
     * 回复id
     */
    @ApiModelProperty(value="回复id")
    private Long replyId;
    }
