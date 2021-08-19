package com.faxi.cloudmall.coupon.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.coupon.entity.CouponHistory;
import com.faxi.cloudmall.coupon.service.CouponHistoryService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 优惠券领取历史记录
 *
 * @author faxi
 * @date 2021-07-06 20:36:06
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/coupon/couponhistory" )
@Api(value = "couponhistory", tags = "优惠券领取历史记录管理")
public class CouponHistoryController {

    private final  CouponHistoryService couponHistoryService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param couponHistory 优惠券领取历史记录
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('coupon_couponhistory_get')" )
    public R getCouponHistoryPage(Page page, CouponHistory couponHistory) {
        return R.ok(couponHistoryService.page(page, Wrappers.query(couponHistory)));
    }


    /**
     * 通过id查询优惠券领取历史记录
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('coupon_couponhistory_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(couponHistoryService.getById(id));
    }

    /**
     * 新增优惠券领取历史记录
     * @param couponHistory 优惠券领取历史记录
     * @return R
     */
    @ApiOperation(value = "新增优惠券领取历史记录", notes = "新增优惠券领取历史记录")
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('coupon_couponhistory_add')" )
    public R save(@RequestBody CouponHistory couponHistory) {
        return R.ok(couponHistoryService.save(couponHistory));
    }

    /**
     * 修改优惠券领取历史记录
     * @param couponHistory 优惠券领取历史记录
     * @return R
     */
    @ApiOperation(value = "修改优惠券领取历史记录", notes = "修改优惠券领取历史记录")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('coupon_couponhistory_edit')" )
    public R updateById(@RequestBody CouponHistory couponHistory) {
        return R.ok(couponHistoryService.updateById(couponHistory));
    }

    /**
     * 通过id删除优惠券领取历史记录
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除优惠券领取历史记录", notes = "通过id删除优惠券领取历史记录")
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('coupon_couponhistory_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(couponHistoryService.removeById(id));
    }

}
