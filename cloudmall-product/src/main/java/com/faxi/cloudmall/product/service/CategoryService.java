package com.faxi.cloudmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.faxi.cloudmall.product.entity.Category;

import java.util.List;

/**
 * 商品三级分类
 *
 * @author faxi
 * @date 2021-07-04 22:19:39
 */
public interface CategoryService extends IService<Category> {

    List<Category> getTree();

    void deleteByIds(List<Long> catIds);

    Long[] findCatelogPath(Long catelogId);

    void updateCategory(Category category);
}
