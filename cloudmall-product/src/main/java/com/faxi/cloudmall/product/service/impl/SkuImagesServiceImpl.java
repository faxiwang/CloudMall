package com.faxi.cloudmall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.faxi.cloudmall.product.entity.SkuImages;
import com.faxi.cloudmall.product.mapper.SkuImagesMapper;
import com.faxi.cloudmall.product.service.SkuImagesService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * sku图片
 *
 * @author faxi
 * @date 2021-07-04 22:19:39
 */
@Service
public class SkuImagesServiceImpl extends ServiceImpl<SkuImagesMapper, SkuImages> implements SkuImagesService {

    @Override
    public IPage<SkuImages> queryPage(Page page) {
        return baseMapper.selectPage(page,new LambdaQueryWrapper<>());
    }

    @Override
    public List<SkuImages> getImagesBySkuId(Long skuId) {
        return baseMapper.selectList(new LambdaQueryWrapper<SkuImages>().eq(SkuImages::getSkuId,skuId));
    }
}
