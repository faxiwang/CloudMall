package com.faxi.cloudmall.coupon.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.coupon.entity.CouponSpuCategoryRelation;
import com.faxi.cloudmall.coupon.service.CouponSpuCategoryRelationService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 优惠券分类关联
 *
 * @author faxi
 * @date 2021-07-06 20:36:06
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/coupon/couponspucategoryrelation" )
@Api(value = "couponspucategoryrelation", tags = "优惠券分类关联管理")
public class CouponSpuCategoryRelationController {

    private final  CouponSpuCategoryRelationService couponSpuCategoryRelationService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param couponSpuCategoryRelation 优惠券分类关联
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('coupon_couponspucategoryrelation_get')" )
    public R getCouponSpuCategoryRelationPage(Page page, CouponSpuCategoryRelation couponSpuCategoryRelation) {
        return R.ok(couponSpuCategoryRelationService.page(page, Wrappers.query(couponSpuCategoryRelation)));
    }


    /**
     * 通过id查询优惠券分类关联
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('coupon_couponspucategoryrelation_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(couponSpuCategoryRelationService.getById(id));
    }

    /**
     * 新增优惠券分类关联
     * @param couponSpuCategoryRelation 优惠券分类关联
     * @return R
     */
    @ApiOperation(value = "新增优惠券分类关联", notes = "新增优惠券分类关联")
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('coupon_couponspucategoryrelation_add')" )
    public R save(@RequestBody CouponSpuCategoryRelation couponSpuCategoryRelation) {
        return R.ok(couponSpuCategoryRelationService.save(couponSpuCategoryRelation));
    }

    /**
     * 修改优惠券分类关联
     * @param couponSpuCategoryRelation 优惠券分类关联
     * @return R
     */
    @ApiOperation(value = "修改优惠券分类关联", notes = "修改优惠券分类关联")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('coupon_couponspucategoryrelation_edit')" )
    public R updateById(@RequestBody CouponSpuCategoryRelation couponSpuCategoryRelation) {
        return R.ok(couponSpuCategoryRelationService.updateById(couponSpuCategoryRelation));
    }

    /**
     * 通过id删除优惠券分类关联
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除优惠券分类关联", notes = "通过id删除优惠券分类关联")
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('coupon_couponspucategoryrelation_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(couponSpuCategoryRelationService.removeById(id));
    }

}
