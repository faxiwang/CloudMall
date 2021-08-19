package com.faxi.cloudmall.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.faxi.cloudmall.product.entity.SkuImages;

import java.util.List;

/**
 * sku图片
 *
 * @author faxi
 * @date 2021-07-04 22:19:39
 */
public interface SkuImagesService extends IService<SkuImages> {

    IPage<SkuImages> queryPage(Page page);

    List<SkuImages> getImagesBySkuId(Long skuId);
}
