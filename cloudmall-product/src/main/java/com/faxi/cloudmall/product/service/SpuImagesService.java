package com.faxi.cloudmall.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.faxi.cloudmall.product.entity.SpuImages;

import java.util.List;

/**
 * spu图片
 *
 * @author faxi
 * @date 2021-07-04 22:19:39
 */
public interface SpuImagesService extends IService<SpuImages> {

    IPage queryPage(Page page);

    void saveImages(Long id, List<String> images);
}
