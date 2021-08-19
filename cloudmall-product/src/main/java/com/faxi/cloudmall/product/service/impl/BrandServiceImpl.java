package com.faxi.cloudmall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.faxi.cloudmall.product.entity.Brand;
import com.faxi.cloudmall.product.mapper.BrandMapper;
import com.faxi.cloudmall.product.service.BrandService;
import com.faxi.cloudmall.product.service.CategoryBrandRelationService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * 品牌
 *
 * @author faxi
 * @date 2021-07-04 22:19:40
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {

    @Resource
    private CategoryBrandRelationService relationService;

    @Override
    public IPage<Brand> queryPage(Page page, String key) {
        LambdaQueryWrapper<Brand> wrapper = new LambdaQueryWrapper();
        if (StringUtils.hasText(key)){
            wrapper.eq(Brand::getBrandId,key).or().like(Brand::getName,key);
        }
        wrapper.orderByDesc(Brand::getBrandId);
        return baseMapper.selectPage(page,wrapper);
    }

    @Override
    public void updatBrand(Brand brand) {
        baseMapper.updateById(brand);
        if (StringUtils.hasText(brand.getName())){
            relationService.updateBrand(brand.getBrandId(),brand.getName());
        }
    }
}
