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
 * 会员
 *
 * @author faxi
 * @date 2021-07-05 22:06:38
 */
@Data
@TableName("ums_member")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "会员")
public class Member extends Model<Member> {
private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty(value="id")
    private Long id;
    /**
     * 会员等级id
     */
    @ApiModelProperty(value="会员等级id")
    private Long levelId;
    /**
     * 用户名
     */
    @ApiModelProperty(value="用户名")
    private String username;
    /**
     * 密码
     */
    @ApiModelProperty(value="密码")
    private String password;
    /**
     * 昵称
     */
    @ApiModelProperty(value="昵称")
    private String nickname;
    /**
     * 手机号码
     */
    @ApiModelProperty(value="手机号码")
    private String mobile;
    /**
     * 邮箱
     */
    @ApiModelProperty(value="邮箱")
    private String email;
    /**
     * 头像
     */
    @ApiModelProperty(value="头像")
    private String header;
    /**
     * 性别
     */
    @ApiModelProperty(value="性别")
    private Integer gender;
    /**
     * 生日
     */
    @ApiModelProperty(value="生日")
    private LocalDateTime birth;
    /**
     * 所在城市
     */
    @ApiModelProperty(value="所在城市")
    private String city;
    /**
     * 职业
     */
    @ApiModelProperty(value="职业")
    private String job;
    /**
     * 个性签名
     */
    @ApiModelProperty(value="个性签名")
    private String sign;
    /**
     * 用户来源
     */
    @ApiModelProperty(value="用户来源")
    private Integer sourceType;
    /**
     * 积分
     */
    @ApiModelProperty(value="积分")
    private Integer integration;
    /**
     * 成长值
     */
    @ApiModelProperty(value="成长值")
    private Integer growth;
    /**
     * 启用状态
     */
    @ApiModelProperty(value="启用状态")
    private Integer status;
    /**
     * 注册时间
     */
    @ApiModelProperty(value="注册时间")
    private LocalDateTime createTime;
    /**
     * 社交账号ID
     */
    @ApiModelProperty(value="社交账号ID")
    private String socialUid;
    /**
     * 社交账号Token
     */
    @ApiModelProperty(value="社交账号Token")
    private String accessToken;
    /**
     * 社交账号Token过期时间
     */
    @ApiModelProperty(value="社交账号Token过期时间")
    private String expiresIn;
    }
