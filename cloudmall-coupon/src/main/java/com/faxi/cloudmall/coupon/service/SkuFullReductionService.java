package com.faxi.cloudmall.coupon.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.faxi.cloudmall.coupon.entity.SkuFullReduction;
import com.faxi.common.to.SkuReductionTo;

import java.util.Map;

/**
 * 商品满减信息
 *
 * @author faxi
 * @date 2021-07-05 21:58:42
 */
public interface SkuFullReductionService extends IService<SkuFullReduction> {

    IPage queryPage(Page page,String key);

    void saveSkuReduction(SkuReductionTo skuReductionTo);
}
