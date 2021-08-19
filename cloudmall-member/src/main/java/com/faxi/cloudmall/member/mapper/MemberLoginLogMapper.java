package com.faxi.cloudmall.member.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.faxi.cloudmall.member.entity.MemberLoginLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员登录记录
 *
 * @author faxi
 * @date 2021-07-05 22:06:38
 */
@Mapper
public interface MemberLoginLogMapper extends BaseMapper<MemberLoginLog> {

}
