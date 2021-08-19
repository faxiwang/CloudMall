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
 * 会员登录记录
 *
 * @author faxi
 * @date 2021-07-05 22:06:38
 */
@Data
@TableName("ums_member_login_log")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "会员登录记录")
public class MemberLoginLog extends Model<MemberLoginLog> {
private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty(value="id")
    private Long id;
    /**
     * member_id
     */
    @ApiModelProperty(value="member_id")
    private Long memberId;
    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private LocalDateTime createTime;
    /**
     * ip
     */
    @ApiModelProperty(value="ip")
    private String ip;
    /**
     * city
     */
    @ApiModelProperty(value="city")
    private String city;
    /**
     * 登录类型[1-web，2-app]
     */
    @ApiModelProperty(value="登录类型[1-web，2-app]")
    private Integer loginType;
    }
