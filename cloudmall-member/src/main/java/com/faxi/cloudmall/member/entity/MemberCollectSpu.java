package com.faxi.cloudmall.member.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 会员收藏的商品
 *
 * @author faxi
 * @date 2021-07-05 22:06:38
 */
@Data
@TableName("ums_member_collect_spu")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "会员收藏的商品")
public class MemberCollectSpu extends Model<MemberCollectSpu> {
private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty(value="id")
    private Long id;
    /**
     * 会员id
     */
    @ApiModelProperty(value="会员id")
    private Long memberId;
    /**
     * spu_id
     */
    @ApiModelProperty(value="spu_id")
    private Long spuId;
    /**
     * spu_name
     */
    @ApiModelProperty(value="spu_name")
    private String spuName;
    /**
     * spu_img
     */
    @ApiModelProperty(value="spu_img")
    private String spuImg;
    /**
     * create_time
     */
    @ApiModelProperty(value="create_time")
    private LocalDateTime createTime;
    }
