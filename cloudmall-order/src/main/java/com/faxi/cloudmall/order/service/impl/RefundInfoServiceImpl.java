package com.faxi.cloudmall.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.faxi.cloudmall.order.entity.RefundInfo;
import com.faxi.cloudmall.order.mapper.RefundInfoMapper;
import com.faxi.cloudmall.order.service.RefundInfoService;
import org.springframework.stereotype.Service;

/**
 * 退款信息
 *
 * @author faxi
 * @date 2021-07-05 21:30:11
 */
@Service
public class RefundInfoServiceImpl extends ServiceImpl<RefundInfoMapper, RefundInfo> implements RefundInfoService {

}
