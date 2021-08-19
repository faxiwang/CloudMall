package com.faxi.cloudmall.coupon.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.coupon.entity.SeckillSkuRelation;
import com.faxi.cloudmall.coupon.service.SeckillSkuRelationService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 秒杀活动商品关联
 *
 * @author faxi
 * @date 2021-07-06 20:36:05
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/coupon/seckillskurelation" )
@Api(value = "seckillskurelation", tags = "秒杀活动商品关联管理")
public class SeckillSkuRelationController {

    private final  SeckillSkuRelationService seckillSkuRelationService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param seckillSkuRelation 秒杀活动商品关联
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('coupon_seckillskurelation_get')" )
    public R getSeckillSkuRelationPage(Page page, SeckillSkuRelation seckillSkuRelation) {
        return R.ok(seckillSkuRelationService.page(page, Wrappers.query(seckillSkuRelation)));
    }


    /**
     * 通过id查询秒杀活动商品关联
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('coupon_seckillskurelation_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(seckillSkuRelationService.getById(id));
    }

    /**
     * 新增秒杀活动商品关联
     * @param seckillSkuRelation 秒杀活动商品关联
     * @return R
     */
    @ApiOperation(value = "新增秒杀活动商品关联", notes = "新增秒杀活动商品关联")
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('coupon_seckillskurelation_add')" )
    public R save(@RequestBody SeckillSkuRelation seckillSkuRelation) {
        return R.ok(seckillSkuRelationService.save(seckillSkuRelation));
    }

    /**
     * 修改秒杀活动商品关联
     * @param seckillSkuRelation 秒杀活动商品关联
     * @return R
     */
    @ApiOperation(value = "修改秒杀活动商品关联", notes = "修改秒杀活动商品关联")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('coupon_seckillskurelation_edit')" )
    public R updateById(@RequestBody SeckillSkuRelation seckillSkuRelation) {
        return R.ok(seckillSkuRelationService.updateById(seckillSkuRelation));
    }

    /**
     * 通过id删除秒杀活动商品关联
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除秒杀活动商品关联", notes = "通过id删除秒杀活动商品关联")
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('coupon_seckillskurelation_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(seckillSkuRelationService.removeById(id));
    }

}
