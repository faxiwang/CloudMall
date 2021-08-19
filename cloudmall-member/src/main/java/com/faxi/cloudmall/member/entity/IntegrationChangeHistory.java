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
 * 积分变化历史记录
 *
 * @author faxi
 * @date 2021-07-05 22:06:38
 */
@Data
@TableName("ums_integration_change_history")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "积分变化历史记录")
public class IntegrationChangeHistory extends Model<IntegrationChangeHistory> {
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
     * 变化的值
     */
    @ApiModelProperty(value="变化的值")
    private Integer changeCount;
    /**
     * 备注
     */
    @ApiModelProperty(value="备注")
    private String note;
    /**
     * 来源[0->购物；1->管理员修改;2->活动]
     */
    @ApiModelProperty(value="来源[0->购物；1->管理员修改;2->活动]")
    private Integer sourceTyoe;
    }
