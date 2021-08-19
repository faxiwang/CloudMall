package com.faxi.cloudmall.member.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.faxi.cloudmall.member.entity.IntegrationChangeHistory;
import com.faxi.cloudmall.member.mapper.IntegrationChangeHistoryMapper;
import com.faxi.cloudmall.member.service.IntegrationChangeHistoryService;
import org.springframework.stereotype.Service;

/**
 * 积分变化历史记录
 *
 * @author faxi
 * @date 2021-07-05 22:06:38
 */
@Service
public class IntegrationChangeHistoryServiceImpl extends ServiceImpl<IntegrationChangeHistoryMapper, IntegrationChangeHistory> implements IntegrationChangeHistoryService {

}
