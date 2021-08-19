package com.faxi.cloudmall.member.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.faxi.cloudmall.member.entity.Member;
import com.faxi.cloudmall.member.mapper.MemberMapper;
import com.faxi.cloudmall.member.service.MemberService;
import org.springframework.stereotype.Service;

/**
 * 会员
 *
 * @author faxi
 * @date 2021-07-05 22:06:38
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

}
