package com.faxi.cloudmall.member.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.faxi.cloudmall.member.entity.MemberLoginLog;
import com.faxi.cloudmall.member.mapper.MemberLoginLogMapper;
import com.faxi.cloudmall.member.service.MemberLoginLogService;
import org.springframework.stereotype.Service;

/**
 * 会员登录记录
 *
 * @author faxi
 * @date 2021-07-05 22:06:38
 */
@Service
public class MemberLoginLogServiceImpl extends ServiceImpl<MemberLoginLogMapper, MemberLoginLog> implements MemberLoginLogService {

}
