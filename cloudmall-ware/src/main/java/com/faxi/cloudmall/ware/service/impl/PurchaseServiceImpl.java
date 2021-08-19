package com.faxi.cloudmall.ware.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.faxi.cloudmall.ware.entity.Purchase;
import com.faxi.cloudmall.ware.mapper.PurchaseMapper;
import com.faxi.cloudmall.ware.service.PurchaseService;
import org.springframework.stereotype.Service;

/**
 * 采购信息
 *
 * @author faxi
 * @date 2021-07-05 22:09:27
 */
@Service
public class PurchaseServiceImpl extends ServiceImpl<PurchaseMapper, Purchase> implements PurchaseService {

}
