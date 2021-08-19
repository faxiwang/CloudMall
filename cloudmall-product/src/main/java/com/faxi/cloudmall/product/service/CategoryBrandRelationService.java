package com.faxi.cloudmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.faxi.cloudmall.product.entity.Brand;
import com.faxi.cloudmall.product.entity.CategoryBrandRelation;

import java.util.List;

/**
 * 品牌分类关联
 *
 * @author faxi
 * @date 2021-07-04 22:19:39
 */
public interface CategoryBrandRelationService extends IService<CategoryBrandRelation> {

    void saveBrandRelation(CategoryBrandRelation brandRelation);

    void updateBrand(Long brandId, String name);

    void updateCategory(Long catId, String name);

    List<Brand> getBrandsByCatId(Long catId);
}
