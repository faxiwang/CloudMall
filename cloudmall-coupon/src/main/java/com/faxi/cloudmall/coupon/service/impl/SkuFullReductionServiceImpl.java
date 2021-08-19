package com.faxi.cloudmall.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.faxi.cloudmall.coupon.entity.MemberPrice;
import com.faxi.cloudmall.coupon.entity.SkuFullReduction;
import com.faxi.cloudmall.coupon.entity.SkuLadder;
import com.faxi.cloudmall.coupon.mapper.SkuFullReductionMapper;
import com.faxi.cloudmall.coupon.service.MemberPriceService;
import com.faxi.cloudmall.coupon.service.SkuFullReductionService;
import com.faxi.cloudmall.coupon.service.SkuLadderService;
import com.faxi.common.to.MemberPriceTo;
import com.faxi.common.to.SkuReductionTo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品满减信息
 *
 * @author faxi
 * @date 2021-07-05 21:58:42
 */
@Service
public class SkuFullReductionServiceImpl extends ServiceImpl<SkuFullReductionMapper, SkuFullReduction> implements SkuFullReductionService {

    @Autowired
    private SkuLadderService skuLadderService;

    @Autowired
    private MemberPriceService memberPriceService;

    @Override
    public IPage queryPage(Page page,String key) {
        LambdaQueryWrapper<SkuFullReduction> wrapper = new LambdaQueryWrapper<>();
        if (StringUtils.hasText(key)){
            wrapper.eq(SkuFullReduction::getSkuId,key);
        }
        return baseMapper.selectPage(page,wrapper);
    }

    @Override
    public void saveSkuReduction(SkuReductionTo skuReductionTo) {
        //1、保存满减打折、会员价
        //1、1）、sku的优惠、满减等信息：gulimall_sms--->sms_sku_ladder、sms_sku_full_reduction、sms_member_price
        SkuLadder skuLadderEntity = new SkuLadder();
        BeanUtils.copyProperties(skuReductionTo,skuLadderEntity);
        skuLadderEntity.setAddOther(skuReductionTo.getCountStatus());

        if (skuReductionTo.getFullCount() > 0) {
            skuLadderService.save(skuLadderEntity);
        }

        //2、sms_sku_full_reduction
        SkuFullReduction skuFullReductionEntity = new SkuFullReduction();
        BeanUtils.copyProperties(skuReductionTo,skuFullReductionEntity);
        if (skuFullReductionEntity.getFullPrice().compareTo(BigDecimal.ZERO) == 1) {
            this.save(skuFullReductionEntity);
        }


        //3、sms_member_price
        List<MemberPriceTo> memberPrice = skuReductionTo.getMemberPrice();

        List<MemberPrice> collect = memberPrice.stream().map(mem -> {
            MemberPrice price = new MemberPrice();
            price.setSkuId(skuReductionTo.getSkuId());
            price.setMemberLevelId(mem.getId());
            price.setMemberLevelName(mem.getName());
            price.setMemberPrice(mem.getPrice());
            price.setAddOther(1);
            return price;
        }).filter(item -> {
            return item.getMemberPrice().compareTo(BigDecimal.ZERO) == 1;
        }).collect(Collectors.toList());

        memberPriceService.saveBatch(collect);
    }
}
