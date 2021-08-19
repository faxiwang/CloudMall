package com.faxi.cloudmall.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.faxi.cloudmall.product.entity.SpuInfoDesc;

import java.util.Map;

/**
 * spu信息介绍
 *
 * @author faxi
 * @date 2021-07-04 22:19:40
 */
public interface SpuInfoDescService extends IService<SpuInfoDesc> {
    IPage<SpuInfoDesc> queryPage(Page page);

    void saveSpuInfoDesc(SpuInfoDesc spuInfoDesc);
}
