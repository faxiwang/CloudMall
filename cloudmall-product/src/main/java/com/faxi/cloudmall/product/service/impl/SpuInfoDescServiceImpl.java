package com.faxi.cloudmall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.faxi.cloudmall.product.entity.SpuInfoDesc;
import com.faxi.cloudmall.product.mapper.SpuInfoDescMapper;
import com.faxi.cloudmall.product.service.SpuInfoDescService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * spu信息介绍
 *
 * @author faxi
 * @date 2021-07-04 22:19:40
 */
@Service
public class SpuInfoDescServiceImpl extends ServiceImpl<SpuInfoDescMapper, SpuInfoDesc> implements SpuInfoDescService {

    @Override
    public IPage<SpuInfoDesc> queryPage(Page page) {
        return baseMapper.selectPage(page,new LambdaQueryWrapper<SpuInfoDesc>());
    }

    @Override
    public void saveSpuInfoDesc(SpuInfoDesc spuInfoDesc) {
        baseMapper.insert(spuInfoDesc);
    }
}
