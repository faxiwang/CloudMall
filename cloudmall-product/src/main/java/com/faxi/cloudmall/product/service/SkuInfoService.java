package com.faxi.cloudmall.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.faxi.cloudmall.product.entity.SkuInfo;
import com.faxi.cloudmall.product.entity.SpuInfo;
import com.faxi.cloudmall.product.vo.SkuInfoParam;
import com.faxi.cloudmall.product.vo.SkuInfoVo;
import com.faxi.cloudmall.product.vo.SkuItemVo;
import com.faxi.cloudmall.product.vo.SpuSaveVo;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * sku信息
 *
 * @author faxi
 * @date 2021-07-04 22:19:39
 */
public interface SkuInfoService extends IService<SkuInfo> {

    Page<SkuInfo>  queryPage(Page page, SkuInfoVo info);

    void saveSkuInfo(SkuInfo skuInfo);

    IPage queryPageCondition(Page page, SkuInfoParam param);

    List<SkuInfo> getSkusBySpuId(Long spuId);

    /**
     * 查询商品详情
     * @param skuId
     * @return
     */
    SkuItemVo item(Long skuId) throws ExecutionException, InterruptedException;
}
