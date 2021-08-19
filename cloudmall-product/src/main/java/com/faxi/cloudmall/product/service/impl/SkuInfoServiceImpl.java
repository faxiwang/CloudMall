package com.faxi.cloudmall.product.service.impl;

import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.faxi.cloudmall.product.entity.SkuImages;
import com.faxi.cloudmall.product.entity.SkuInfo;
import com.faxi.cloudmall.product.entity.SpuInfoDesc;
import com.faxi.cloudmall.product.feign.SeckillFeignService;
import com.faxi.cloudmall.product.mapper.SkuInfoMapper;
import com.faxi.cloudmall.product.service.*;
import com.faxi.cloudmall.product.vo.*;
import com.faxi.common.utis.R;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * sku信息
 *
 * @author faxi
 * @date 2021-07-04 22:19:39
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoMapper, SkuInfo> implements SkuInfoService {

    private final SkuImagesService skuImagesService;

    private final SpuInfoDescService spuInfoDescService;

    private final AttrGroupService attrGroupService;

    private final SkuSaleAttrValueService skuSaleAttrValueService;

    private final SeckillFeignService seckillFeignService;

    private final ThreadPoolExecutor executor;

    @Override
    public Page<SkuInfo> queryPage(Page page,SkuInfoVo info) {
        LambdaQueryWrapper<SkuInfo> wrapper = new LambdaQueryWrapper<>();
        if (StringUtils.hasText(info.getKey()) && !"0".equalsIgnoreCase(info.getKey())){
            wrapper.and(w->{
                w.eq(SkuInfo::getSkuId,info.getKey()).or().like(SkuInfo::getSkuName,info.getKey());
            });
        }
        if (StringUtils.hasText(info.getCatelogId()) && !"0".equalsIgnoreCase(info.getCatelogId())){
            wrapper.eq(SkuInfo::getCatalogId,info.getCatelogId());
        }

        if (StringUtils.hasText(info.getBrandId()) && !"0".equalsIgnoreCase(info.getBrandId())){
            wrapper.eq(SkuInfo::getBrandId,info.getBrandId());
        }

        if (StringUtils.hasText(info.getMin())){
            wrapper.ge(SkuInfo::getPrice,info.getMin());
        }
        if (StringUtils.hasText(info.getMax())){
            try {
                BigDecimal bigDecimal = new BigDecimal(info.getMax());
                if (bigDecimal.compareTo(BigDecimal.ZERO) == 1){
                    wrapper.le(SkuInfo::getPrice,info.getMax());
                }
            }catch (Exception e){
                log.error(e.getMessage(),e);
            }
        }

        return baseMapper.selectPage(page, wrapper);
    }

    @Override
    public void saveSkuInfo(SkuInfo skuInfo) {
        baseMapper.insert(skuInfo);
    }

    @Override
    public IPage queryPageCondition(Page page, SkuInfoParam param) {
        LambdaQueryWrapper<SkuInfo> wrapper = new LambdaQueryWrapper<>();


        if (StringUtils.hasText(param.getKey()) && !"0".equalsIgnoreCase(param.getKey())) {
            wrapper.and((w) -> {
                wrapper.eq(SkuInfo::getSkuId, param.getKey()).or().like(SkuInfo::getSkuName, param.getKey());
            });
        }


        if (StringUtils.hasText(param.getCatelogId()) && !"0".equalsIgnoreCase(param.getCatelogId())) {
            wrapper.eq(SkuInfo::getCatalogId, param.getCatelogId());
        }

        if (StringUtils.hasText(param.getBrandId()) && !"0".equalsIgnoreCase(param.getBrandId())) {
            wrapper.eq(SkuInfo::getBrandId, param.getBrandId());
        }

        if (StringUtils.hasText(param.getMin())) {
            wrapper.ge(SkuInfo::getPrice, param.getMin());
        }


        if (StringUtils.hasText(param.getMax())) {
            try {
                BigDecimal bigDecimal = new BigDecimal(param.getMax());
                if (bigDecimal.compareTo(BigDecimal.ZERO) == 1) {
                    wrapper.le(SkuInfo::getPrice, param.getMax());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        return baseMapper.selectPage(page, wrapper);
    }

    @Override
    public List<SkuInfo> getSkusBySpuId(Long spuId) {
        return list(new LambdaQueryWrapper<SkuInfo>().eq(SkuInfo::getSpuId, spuId));
    }

    @Override
    public SkuItemVo item(Long skuId) throws ExecutionException, InterruptedException {
        SkuItemVo skuItemVo = new SkuItemVo();

        CompletableFuture<SkuInfo> infoFuture = CompletableFuture.supplyAsync(() -> {
            //1、sku基本信息的获取  pms_sku_info
            SkuInfo info = this.getById(skuId);
            skuItemVo.setInfo(info);
            return info;
        }, executor);


        CompletableFuture<Void> saleAttrFuture = infoFuture.thenAcceptAsync((res) -> {
            //3、获取spu的销售属性组合
            List<SkuItemSaleAttrVo> saleAttrVos = skuSaleAttrValueService.getSaleAttrBySpuId(res.getSpuId());
            skuItemVo.setSaleAttr(saleAttrVos);
        }, executor);


        CompletableFuture<Void> descFuture = infoFuture.thenAcceptAsync((res) -> {
            //4、获取spu的介绍    pms_spu_info_desc
            SpuInfoDesc spuInfoDesc = spuInfoDescService.getById(res.getSpuId());
            skuItemVo.setDesc(spuInfoDesc);
        }, executor);


        CompletableFuture<Void> baseAttrFuture = infoFuture.thenAcceptAsync((res) -> {
            //5、获取spu的规格参数信息
            List<SpuItemAttrGroupVo> attrGroupVos = attrGroupService.getAttrGroupWithAttrsBySpuId(res.getSpuId(), res.getCatalogId());
            skuItemVo.setGroupAttrs(attrGroupVos);
        }, executor);


        // Long spuId = info.getSpuId();
        // Long catalogId = info.getCatalogId();

        //2、sku的图片信息    pms_sku_images
        CompletableFuture<Void> imageFuture = CompletableFuture.runAsync(() -> {
            List<SkuImages> imagesEntities = skuImagesService.getImagesBySkuId(skuId);
            skuItemVo.setImages(imagesEntities);
        }, executor);

        CompletableFuture<Void> seckillFuture = CompletableFuture.runAsync(() -> {
            //3、远程调用查询当前sku是否参与秒杀优惠活动
            R skuSeckilInfo = seckillFeignService.getSkuSeckilInfo(skuId);
            if (skuSeckilInfo.getCode() == 0) {
                //查询成功
                SeckillSkuVo seckilInfoData = (SeckillSkuVo) skuSeckilInfo.getData(new TypeReference<SeckillSkuVo>() {
                });
                skuItemVo.setSeckillSkuVo(seckilInfoData);

                if (seckilInfoData != null) {
                    long currentTime = System.currentTimeMillis();
                    if (currentTime > seckilInfoData.getEndTime()) {
                        skuItemVo.setSeckillSkuVo(null);
                    }
                }
            }
        }, executor);
        return null;
    }
}
