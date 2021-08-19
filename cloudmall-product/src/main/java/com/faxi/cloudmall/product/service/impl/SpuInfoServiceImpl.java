package com.faxi.cloudmall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.faxi.cloudmall.product.entity.*;
import com.faxi.cloudmall.product.feign.CouponFeignService;
import com.faxi.cloudmall.product.feign.SearchFeignService;
import com.faxi.cloudmall.product.feign.WareFeignService;
import com.faxi.cloudmall.product.mapper.SpuInfoMapper;
import com.faxi.cloudmall.product.service.*;
import com.faxi.cloudmall.product.vo.*;
import com.faxi.common.to.SkuReductionTo;
import com.faxi.common.to.SpuBoundTo;
import com.faxi.common.utis.R;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * spu信息
 *
 * @author faxi
 * @date 2021-07-04 22:19:39
 */
@Service
@RequiredArgsConstructor
public class SpuInfoServiceImpl extends ServiceImpl<SpuInfoMapper, SpuInfo> implements SpuInfoService {
    private final SpuInfoDescService spuInfoDescService;

    private final SpuImagesService spuImagesService;

    private final AttrService attrService;

    private final ProductAttrValueService productAttrValueService;

    private final SkuInfoService skuInfoService;

    private final SkuImagesService skuImagesService;

    private final SkuSaleAttrValueService skuSaleAttrValueService;

    private final CouponFeignService couponFeignService;

    private final BrandService brandService;

    private final CategoryService categoryService;

    private final WareFeignService wareFeignService;

    private final SearchFeignService searchFeignService;

    @Override
    public Page queryPage(Page page,SpuinfoVo info) {
        LambdaQueryWrapper<SpuInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(SpuInfo::getCreateTime);
        if (StringUtils.hasText(info.getKey())){
            wrapper.and(w->{
                w.eq(SpuInfo::getId,info.getKey()).or().like(SpuInfo::getSpuName,info.getKey());
            });
        }
        if (StringUtils.hasText(info.getStatus())){
            wrapper.eq(SpuInfo::getPublishStatus,info.getStatus());
        }
        if (StringUtils.hasText(info.getBrandId()) && !"0".equals(info.getBrandId())){
            wrapper.eq(SpuInfo::getBrandId,info.getBrandId());
        }
        if (StringUtils.hasText(info.getCatelogId()) && !"0".equals(info.getCatelogId())){
            wrapper.eq(SpuInfo::getCatalogId,info.getCatelogId());
        }

        return baseMapper.selectPage(page,wrapper);
    }

    @Override
    public void saveBaseSpuInfo(SpuInfo info) {
        this.baseMapper.insert(info);
    }

    @Override
    public IPage queryPageByCondtion(Page page) {
        return null;
    }


    @Override
    public void up(Long spuId) {

    }

    @Override
    public SpuInfo getSpuInfoBySkuId(Long skuId) {
        return null;
    }

    //@GlobalTransactional(rollbackFor = Exception.class)
    @Override
    public boolean saveInfo(SpuSaveVo vo) {
        //1、保存spu基本信息：pms_spu_info
        SpuInfo spuInfo = new SpuInfo();
        BeanUtils.copyProperties(vo, spuInfo);
        spuInfo.setCreateTime(LocalDateTime.now());
        spuInfo.setUpdateTime(LocalDateTime.now());
        this.saveBaseSpuInfo(spuInfo);

        //2、保存spu的描述图片：pms_spu_info_desc
        List<String> decript = vo.getDecript();
        SpuInfoDesc spuInfoDesc = new SpuInfoDesc();
        spuInfoDesc.setSpuId(spuInfo.getId());
        spuInfoDesc.setDecript(String.join(",", decript));
        spuInfoDescService.saveSpuInfoDesc(spuInfoDesc);

        //3、保存spu的图片集：pms_spu_images
        List<String> images = vo.getImages();
        spuImagesService.saveImages(spuInfo.getId(), images);

        //4、保存spu的规格参数：pms_product_attr_value
        List<BaseAttrs> baseAttrs = vo.getBaseAttrs();
        List<ProductAttrValue> collect = baseAttrs.stream().map(attr -> {
            ProductAttrValue value = new ProductAttrValue();
            value.setAttrId(attr.getAttrId());

            //查询attr属性名
            Attr byId = attrService.getById(attr.getAttrId());

            value.setAttrName(byId.getAttrName());
            value.setAttrValue(attr.getAttrValues());
            value.setQuickShow(attr.getShowDesc());
            value.setSpuId(spuInfo.getId());
            return value;
        }).collect(Collectors.toList());
        productAttrValueService.saveProductAttr(collect);


        //5、保存spu的积分信息：gulimall_sms--->sms_spu_bounds
        Bounds bounds = vo.getBounds();
        SpuBoundTo spuBoundTo = new SpuBoundTo();
        BeanUtils.copyProperties(bounds, spuBoundTo);
        spuBoundTo.setSpuId(spuInfo.getId());
        R r = couponFeignService.saveSpuBounds(spuBoundTo);

        if (r.getCode() != 200) {
            log.error("远程保存spu积分信息失败");
        }

        //5、保存当前spu对应的所有sku信息：pms_sku_info
        //5、1）、sku的基本信息:pms_sku_info
        List<Skus> skus = vo.getSkus();
        if (skus != null && skus.size() > 0) {
            skus.forEach(item -> {
                String defaultImg = "";
                for (Images image : item.getImages()) {
                    if (image.getDefaultImg() == 1) {
                        defaultImg = image.getImgUrl();
                    }
                }

                SkuInfo skuInfo = new SkuInfo();
                BeanUtils.copyProperties(item, skuInfo);
                skuInfo.setBrandId(spuInfo.getBrandId());
                skuInfo.setCatalogId(spuInfo.getCatalogId());
                skuInfo.setSaleCount(0L);
                skuInfo.setSpuId(spuInfo.getId());
                skuInfo.setSkuDefaultImg(defaultImg);
                skuInfoService.saveSkuInfo(skuInfo);

                Long skuId = skuInfo.getSkuId();

                List<SkuImages> skuImagesList = item.getImages().stream().map(img -> {
                    SkuImages skuImages = new SkuImages();
                    skuImages.setSkuId(skuId);
                    skuImages.setImgUrl(img.getImgUrl());
                    skuImages.setDefaultImg(img.getDefaultImg());
                    return skuImages;
                }).filter(entity -> {
                    //返回true就是需要，false就是剔除
                    return StringUtils.hasText(entity.getImgUrl());
                }).collect(Collectors.toList());

                //5、2）、sku的图片信息：pms_sku_images
                skuImagesService.saveBatch(skuImagesList);

                //5、3）、sku的销售属性：pms_sku_sale_attr_value
                List<AttrVo2> attr = item.getAttr();
                List<SkuSaleAttrValue> skuSaleAttrValueEntities = attr.stream().map(a -> {
                    SkuSaleAttrValue skuSaleAttrvalue = new SkuSaleAttrValue();
                    BeanUtils.copyProperties(a, skuSaleAttrvalue);
                    skuSaleAttrvalue.setSkuId(skuId);
                    return skuSaleAttrvalue;
                }).collect(Collectors.toList());

                skuSaleAttrValueService.saveBatch(skuSaleAttrValueEntities);

                //5、4）、sku的优惠、满减等信息：gulimall_sms--->sms_sku_ladder、sms_sku_full_reduction、sms_member_price
                SkuReductionTo skuReductionTo = new SkuReductionTo();
                BeanUtils.copyProperties(item, skuReductionTo);
                skuReductionTo.setSkuId(skuId);
                if (skuReductionTo.getFullCount() > 0 || skuReductionTo.getFullPrice().compareTo(BigDecimal.ZERO) == 1) {
                    R r1 = couponFeignService.saveSkuReduction(skuReductionTo);
                    if (r1.getCode() != 200) {
                        log.error("远程保存sku积分信息失败");
                    }
                }
            });
        }
        return true;
    }
}
