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
 * 成长值变化历史记录
 *
 * @author faxi
 * @date 2021-07-05 22:06:38
 */
@Data
@TableName("ums_growth_change_history")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "成长值变化历史记录")
public class GrowthChangeHistory extends Model<GrowthChangeHistory> {
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
     * create_time
     */
    @ApiModelProperty(value="create_time")
    private LocalDateTime createTime;
    /**
     * 改变的值（正负计数）
     */
    @ApiModelProperty(value="改变的值（正负计数）")
    private Integer changeCount;
    /**
     * 备注
     */
    @ApiModelProperty(value="备注")
    private String note;
    /**
     * 积分来源[0-购物，1-管理员修改]
     */
    @ApiModelProperty(value="积分来源[0-购物，1-管理员修改]")
    private Integer sourceType;
    }
