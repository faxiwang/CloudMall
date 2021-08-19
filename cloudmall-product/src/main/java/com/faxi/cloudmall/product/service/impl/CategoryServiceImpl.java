package com.faxi.cloudmall.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.faxi.cloudmall.product.entity.Category;
import com.faxi.cloudmall.product.mapper.CategoryMapper;
import com.faxi.cloudmall.product.service.CategoryBrandRelationService;
import com.faxi.cloudmall.product.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品三级分类
 *
 * @author faxi
 * @date 2021-07-04 22:19:39
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Resource
    private CategoryBrandRelationService relationService;

    @Override
    public List<Category> getTree() {
        List<Category> list = baseMapper.selectList(null);
        // 获取一级菜单
        List<Category> collect = list.stream().filter(c ->
                c.getParentCid() == 0
        ).map(m -> {
            m.setChildren(getChilder(m, list));
            return m;
        }).sorted((p, n) -> {
            return (p.getSort() == null ? 0 : p.getSort()) - (n.getSort() == null ? 0 : n.getSort());
        }).collect(Collectors.toList());

        return list;
    }

    // 递归查出子节点
    private List<Category> getChilder(Category parent, List<Category> list) {
        List<Category> result = list.stream().filter(c -> {
            return c.getParentCid() == parent.getCatId();
        }).map(m -> {
            m.setChildren(getChilder(m, list));
            return m;
        }).sorted((p, n) -> {
            return (p.getSort() == null ? 0 : p.getSort()) - (n.getSort() == null ? 0 : n.getSort());
        }).collect(Collectors.toList());
        return result;
    }

    @Override
    public void deleteByIds(List<Long> catIds) {
        //TODO 检查是否被引用
        baseMapper.deleteBatchIds(catIds);
    }

    @Override
    public Long[] findCatelogPath(Long catelogId) {

        List<Long> paths = new ArrayList<>();

        //递归查询是否还有父节点
        List<Long> parentPath = findParentPath(catelogId, paths);

        //进行一个逆序排列
        Collections.reverse(parentPath);

        return parentPath.toArray(new Long[parentPath.size()]);
    }

    @Override
    @Transactional
    public void updateCategory(Category category) {

        this.baseMapper.updateById(category);
        relationService.updateCategory(category.getCatId(), category.getName());
    }

    private List<Long> findParentPath(Long catelogId, List<Long> paths) {

        //1、收集当前节点id
        paths.add(catelogId);
        //根据当前分类id查询信息
        Category byId = this.getById(catelogId);
        //如果当前不是父分类
        if (byId.getParentCid() != 0) {
            findParentPath(byId.getParentCid(), paths);
        }

        return paths;
    }
}
