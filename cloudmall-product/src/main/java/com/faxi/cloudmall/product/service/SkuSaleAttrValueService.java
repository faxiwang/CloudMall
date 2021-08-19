package com.faxi.cloudmall.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.faxi.cloudmall.product.entity.SkuSaleAttrValue;
import com.faxi.cloudmall.product.vo.SkuItemSaleAttrVo;

import java.util.List;

/**
 * sku销售属性&值
 *
 * @author faxi
 * @date 2021-07-04 22:19:39
 */
public interface SkuSaleAttrValueService extends IService<SkuSaleAttrValue> {

    IPage<SkuSaleAttrValue> queryPage(Page page);

    List<SkuItemSaleAttrVo> getSaleAttrBySpuId(Long spuId);

    List<String> getSkuSaleAttrValuesAsStringList(Long skuId);
}
