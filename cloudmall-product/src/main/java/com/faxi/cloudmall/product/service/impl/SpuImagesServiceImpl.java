package com.faxi.cloudmall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.faxi.cloudmall.product.entity.SpuImages;
import com.faxi.cloudmall.product.mapper.SpuImagesMapper;
import com.faxi.cloudmall.product.service.SpuImagesService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * spu图片
 *
 * @author faxi
 * @date 2021-07-04 22:19:39
 */
@Service
public class SpuImagesServiceImpl extends ServiceImpl<SpuImagesMapper, SpuImages> implements SpuImagesService {

    @Override
    public IPage queryPage(Page page) {
        return baseMapper.selectPage(page, new LambdaQueryWrapper<>());
    }

    @Override
    public void saveImages(Long id, List<String> images) {
        if (!CollectionUtils.isEmpty(images)) {
            List<SpuImages> collect = images.stream().map(img -> {
                SpuImages spuImages = new SpuImages();
                spuImages.setSpuId(id);
                spuImages.setImgUrl(img);
                return spuImages;
            }).collect(Collectors.toList());

            this.saveBatch(collect);
        }
    }
}
