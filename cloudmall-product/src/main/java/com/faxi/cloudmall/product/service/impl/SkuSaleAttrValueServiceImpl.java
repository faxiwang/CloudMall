package com.faxi.cloudmall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.faxi.cloudmall.product.entity.SkuSaleAttrValue;
import com.faxi.cloudmall.product.mapper.SkuSaleAttrValueMapper;
import com.faxi.cloudmall.product.service.SkuSaleAttrValueService;
import com.faxi.cloudmall.product.vo.SkuItemSaleAttrVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * sku销售属性&值
 *
 * @author faxi
 * @date 2021-07-04 22:19:39
 */
@Service
public class SkuSaleAttrValueServiceImpl extends ServiceImpl<SkuSaleAttrValueMapper, SkuSaleAttrValue> implements SkuSaleAttrValueService {

    @Override
    public IPage<SkuSaleAttrValue> queryPage(Page page) {
        return baseMapper.selectPage(page,new LambdaQueryWrapper<>());
    }

    @Override
    public List<SkuItemSaleAttrVo> getSaleAttrBySpuId(Long spuId) {

        return null;
    }

    @Override
    public List<String> getSkuSaleAttrValuesAsStringList(Long skuId) {
        return null;
    }
}
