package com.faxi.cloudmall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.faxi.cloudmall.product.entity.ProductAttrValue;
import com.faxi.cloudmall.product.mapper.ProductAttrValueMapper;
import com.faxi.cloudmall.product.service.ProductAttrValueService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * spu属性值
 *
 * @author faxi
 * @date 2021-07-04 22:19:39
 */
@Service
public class ProductAttrValueServiceImpl extends ServiceImpl<ProductAttrValueMapper, ProductAttrValue> implements ProductAttrValueService {

    @Override
    public IPage queryPage(Page page) {
        baseMapper.selectPage(page,new LambdaQueryWrapper<ProductAttrValue>());
        return null;
    }

    @Override
    public void saveProductAttr(List<ProductAttrValue> list) {
        this.saveBatch(list);
    }

    @Override
    public List<ProductAttrValue> baseAttrListforspu(Long spuId) {
        return baseMapper.selectList(new LambdaQueryWrapper<ProductAttrValue>().eq(ProductAttrValue::getSpuId,spuId));
    }

    @Override
    public void updateSpuAttr(Long spuId, List<ProductAttrValue> list) {
        //1、删除spuId之前对应的所有属性
        this.baseMapper.delete(new LambdaUpdateWrapper<ProductAttrValue>().eq(ProductAttrValue::getSpuId,spuId));

        //2、添加商品规格信息
        List<ProductAttrValue> collect = list.stream().map(item -> {
            item.setSpuId(spuId);
            return item;
        }).collect(Collectors.toList());

        //批量新增
        this.saveBatch(collect);
    }
}
