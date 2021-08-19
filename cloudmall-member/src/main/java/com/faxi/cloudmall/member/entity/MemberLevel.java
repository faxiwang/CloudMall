package com.faxi.cloudmall.member.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.math.BigDecimal;

/**
 * 会员等级
 *
 * @author faxi
 * @date 2021-07-05 22:06:38
 */
@Data
@TableName("ums_member_level")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "会员等级")
public class MemberLevel extends Model<MemberLevel> {
private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty(value="id")
    private Long id;
    /**
     * 等级名称
     */
    @ApiModelProperty(value="等级名称")
    private String name;
    /**
     * 等级需要的成长值
     */
    @ApiModelProperty(value="等级需要的成长值")
    private Integer growthPoint;
    /**
     * 是否为默认等级[0->不是；1->是]
     */
    @ApiModelProperty(value="是否为默认等级[0->不是；1->是]")
    private Integer defaultStatus;
    /**
     * 免运费标准
     */
    @ApiModelProperty(value="免运费标准")
    private BigDecimal freeFreightPoint;
    /**
     * 每次评价获取的成长值
     */
    @ApiModelProperty(value="每次评价获取的成长值")
    private Integer commentGrowthPoint;
    /**
     * 是否有免邮特权
     */
    @ApiModelProperty(value="是否有免邮特权")
    private Integer priviledgeFreeFreight;
    /**
     * 是否有会员价格特权
     */
    @ApiModelProperty(value="是否有会员价格特权")
    private Integer priviledgeMemberPrice;
    /**
     * 是否有生日特权
     */
    @ApiModelProperty(value="是否有生日特权")
    private Integer priviledgeBirthday;
    /**
     * 备注
     */
    @ApiModelProperty(value="备注")
    private String note;
    }
