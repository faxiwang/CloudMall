package com.faxi.cloudmall.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.faxi.cloudmall.product.entity.Brand;

/**
 * 品牌
 *
 * @author faxi
 * @date 2021-07-04 22:19:40
 */
public interface BrandService extends IService<Brand> {
    IPage<Brand> queryPage(Page page,String key);

    void updatBrand(Brand brand);
}
