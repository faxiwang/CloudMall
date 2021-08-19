package com.faxi.cloudmall.coupon.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.coupon.entity.SeckillPromotion;
import com.faxi.cloudmall.coupon.service.SeckillPromotionService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 秒杀活动
 *
 * @author faxi
 * @date 2021-07-06 20:36:05
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/coupon/seckillpromotion" )
@Api(value = "seckillpromotion", tags = "秒杀活动管理")
public class SeckillPromotionController {

    private final  SeckillPromotionService seckillPromotionService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param seckillPromotion 秒杀活动
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('coupon_seckillpromotion_get')" )
    public R getSeckillPromotionPage(Page page, SeckillPromotion seckillPromotion) {
        return R.ok(seckillPromotionService.page(page, Wrappers.query(seckillPromotion)));
    }


    /**
     * 通过id查询秒杀活动
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('coupon_seckillpromotion_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(seckillPromotionService.getById(id));
    }

    /**
     * 新增秒杀活动
     * @param seckillPromotion 秒杀活动
     * @return R
     */
    @ApiOperation(value = "新增秒杀活动", notes = "新增秒杀活动")
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('coupon_seckillpromotion_add')" )
    public R save(@RequestBody SeckillPromotion seckillPromotion) {
        return R.ok(seckillPromotionService.save(seckillPromotion));
    }

    /**
     * 修改秒杀活动
     * @param seckillPromotion 秒杀活动
     * @return R
     */
    @ApiOperation(value = "修改秒杀活动", notes = "修改秒杀活动")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('coupon_seckillpromotion_edit')" )
    public R updateById(@RequestBody SeckillPromotion seckillPromotion) {
        return R.ok(seckillPromotionService.updateById(seckillPromotion));
    }

    /**
     * 通过id删除秒杀活动
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除秒杀活动", notes = "通过id删除秒杀活动")
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('coupon_seckillpromotion_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(seckillPromotionService.removeById(id));
    }

}
