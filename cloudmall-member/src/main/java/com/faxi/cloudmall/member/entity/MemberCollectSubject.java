package com.faxi.cloudmall.member.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 会员收藏的专题活动
 *
 * @author faxi
 * @date 2021-07-05 22:06:38
 */
@Data
@TableName("ums_member_collect_subject")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "会员收藏的专题活动")
public class MemberCollectSubject extends Model<MemberCollectSubject> {
private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty(value="id")
    private Long id;
    /**
     * subject_id
     */
    @ApiModelProperty(value="subject_id")
    private Long subjectId;
    /**
     * subject_name
     */
    @ApiModelProperty(value="subject_name")
    private String subjectName;
    /**
     * subject_img
     */
    @ApiModelProperty(value="subject_img")
    private String subjectImg;
    /**
     * 活动url
     */
    @ApiModelProperty(value="活动url")
    private String subjectUrll;
    }
