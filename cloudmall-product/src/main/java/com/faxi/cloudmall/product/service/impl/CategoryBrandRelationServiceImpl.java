package com.faxi.cloudmall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.faxi.cloudmall.product.entity.Brand;
import com.faxi.cloudmall.product.entity.Category;
import com.faxi.cloudmall.product.entity.CategoryBrandRelation;
import com.faxi.cloudmall.product.mapper.BrandMapper;
import com.faxi.cloudmall.product.mapper.CategoryBrandRelationMapper;
import com.faxi.cloudmall.product.mapper.CategoryMapper;
import com.faxi.cloudmall.product.service.CategoryBrandRelationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 品牌分类关联
 *
 * @author faxi
 * @date 2021-07-04 22:19:39
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryBrandRelationServiceImpl extends ServiceImpl<CategoryBrandRelationMapper, CategoryBrandRelation> implements CategoryBrandRelationService {

    private final BrandMapper brandMapper;

    private final CategoryMapper categoryMapper;

    private final CategoryBrandRelationMapper relationMapper;

    @Override
    public void saveBrandRelation(CategoryBrandRelation brandRelation) {
        Brand brand = brandMapper.selectById(brandRelation.getBrandId());
        Category category = categoryMapper.selectById(brandRelation.getCatelogId());

        brandRelation.setBrandName(brand.getName());
        brandRelation.setCatelogName(category.getName());
        baseMapper.insert(brandRelation);
    }

    @Override
    public void updateBrand(Long brandId, String name) {
        CategoryBrandRelation relation = new CategoryBrandRelation();
        relation.setBrandId(brandId);
        relation.setBrandName(name);
        baseMapper.update(relation,new LambdaUpdateWrapper<CategoryBrandRelation>().eq(CategoryBrandRelation::getBrandId,brandId));
    }

    @Override
    public void updateCategory(Long catId, String name) {
        CategoryBrandRelation relation = new CategoryBrandRelation();
        relation.setCatelogId(catId);
        relation.setCatelogName(name);
        this.baseMapper.update(relation,new LambdaUpdateWrapper<CategoryBrandRelation>().eq(CategoryBrandRelation::getCatelogId,catId));
    }

    @Override
    public List<Brand> getBrandsByCatId(Long catId) {
        List<CategoryBrandRelation> list = relationMapper.selectList(new LambdaQueryWrapper<CategoryBrandRelation>().eq(CategoryBrandRelation::getCatelogId,catId));
        List<Brand> collect = list.stream().map(item -> {
            Long brandId = item.getBrandId();
            Brand byId = brandMapper.selectById(brandId);
            return byId;
        }).collect(Collectors.toList());
        return collect;
    }
}
