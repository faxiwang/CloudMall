package com.faxi.cloudmall.coupon.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.coupon.entity.Coupon;
import com.faxi.cloudmall.coupon.service.CouponService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;


/**
 * 优惠券信息
 *  @RefreshScope 自动刷新配置中心修改的配置信息
 *
 * @author faxi
 * @date 2021-07-06 20:36:06
 */
@RestController
@RefreshScope
@RequiredArgsConstructor
@RequestMapping("/coupon/coupon" )
@Api(value = "coupon", tags = "优惠券信息管理")
public class CouponController {

    private final  CouponService couponService;

    @Value("${coupon.user.name}")
    private String name;

    @Value("${coupon.user.age}")
    private Integer age;

    @GetMapping("/test")
    public String test(){
        return  "name:"+name +"  age:" + age;
    }

    @GetMapping("/getcoupon")
    public R getcoupon(){
        Coupon coupon = new Coupon();
        coupon.setCouponName("买一送一");
        return R.ok().setData(coupon);
    }

    /**
     * 分页查询
     * @param page 分页对象
     * @param coupon 优惠券信息
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('coupon_coupon_get')" )
    public R getCouponPage(Page page, Coupon coupon) {
        return R.ok(couponService.page(page, Wrappers.query(coupon)));
    }


    /**
     * 通过id查询优惠券信息
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('coupon_coupon_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(couponService.getById(id));
    }

    /**
     * 新增优惠券信息
     * @param coupon 优惠券信息
     * @return R
     */
    @ApiOperation(value = "新增优惠券信息", notes = "新增优惠券信息")
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('coupon_coupon_add')" )
    public R save(@RequestBody Coupon coupon) {
        return R.ok(couponService.save(coupon));
    }

    /**
     * 修改优惠券信息
     * @param coupon 优惠券信息
     * @return R
     */
    @ApiOperation(value = "修改优惠券信息", notes = "修改优惠券信息")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('coupon_coupon_edit')" )
    public R updateById(@RequestBody Coupon coupon) {
        return R.ok(couponService.updateById(coupon));
    }

    /**
     * 通过id删除优惠券信息
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除优惠券信息", notes = "通过id删除优惠券信息")
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('coupon_coupon_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(couponService.removeById(id));
    }

}
