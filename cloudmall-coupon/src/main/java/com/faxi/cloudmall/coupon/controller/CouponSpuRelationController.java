package com.faxi.cloudmall.coupon.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.coupon.entity.CouponSpuRelation;
import com.faxi.cloudmall.coupon.service.CouponSpuRelationService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 优惠券与产品关联
 *
 * @author faxi
 * @date 2021-07-06 20:36:05
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/coupon/couponspurelation" )
@Api(value = "couponspurelation", tags = "优惠券与产品关联管理")
public class CouponSpuRelationController {

    private final  CouponSpuRelationService couponSpuRelationService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param couponSpuRelation 优惠券与产品关联
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('coupon_couponspurelation_get')" )
    public R getCouponSpuRelationPage(Page page, CouponSpuRelation couponSpuRelation) {
        return R.ok(couponSpuRelationService.page(page, Wrappers.query(couponSpuRelation)));
    }


    /**
     * 通过id查询优惠券与产品关联
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('coupon_couponspurelation_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(couponSpuRelationService.getById(id));
    }

    /**
     * 新增优惠券与产品关联
     * @param couponSpuRelation 优惠券与产品关联
     * @return R
     */
    @ApiOperation(value = "新增优惠券与产品关联", notes = "新增优惠券与产品关联")
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('coupon_couponspurelation_add')" )
    public R save(@RequestBody CouponSpuRelation couponSpuRelation) {
        return R.ok(couponSpuRelationService.save(couponSpuRelation));
    }

    /**
     * 修改优惠券与产品关联
     * @param couponSpuRelation 优惠券与产品关联
     * @return R
     */
    @ApiOperation(value = "修改优惠券与产品关联", notes = "修改优惠券与产品关联")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('coupon_couponspurelation_edit')" )
    public R updateById(@RequestBody CouponSpuRelation couponSpuRelation) {
        return R.ok(couponSpuRelationService.updateById(couponSpuRelation));
    }

    /**
     * 通过id删除优惠券与产品关联
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除优惠券与产品关联", notes = "通过id删除优惠券与产品关联")
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('coupon_couponspurelation_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(couponSpuRelationService.removeById(id));
    }

}
