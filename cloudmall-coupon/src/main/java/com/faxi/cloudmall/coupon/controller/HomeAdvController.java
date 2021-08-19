package com.faxi.cloudmall.coupon.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.coupon.entity.HomeAdv;
import com.faxi.cloudmall.coupon.service.HomeAdvService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 首页轮播广告
 *
 * @author faxi
 * @date 2021-07-06 20:36:05
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/coupon/homeadv" )
@Api(value = "homeadv", tags = "首页轮播广告管理")
public class HomeAdvController {

    private final  HomeAdvService homeAdvService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param homeAdv 首页轮播广告
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('coupon_homeadv_get')" )
    public R getHomeAdvPage(Page page, HomeAdv homeAdv) {
        return R.ok(homeAdvService.page(page, Wrappers.query(homeAdv)));
    }


    /**
     * 通过id查询首页轮播广告
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('coupon_homeadv_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(homeAdvService.getById(id));
    }

    /**
     * 新增首页轮播广告
     * @param homeAdv 首页轮播广告
     * @return R
     */
    @ApiOperation(value = "新增首页轮播广告", notes = "新增首页轮播广告")
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('coupon_homeadv_add')" )
    public R save(@RequestBody HomeAdv homeAdv) {
        return R.ok(homeAdvService.save(homeAdv));
    }

    /**
     * 修改首页轮播广告
     * @param homeAdv 首页轮播广告
     * @return R
     */
    @ApiOperation(value = "修改首页轮播广告", notes = "修改首页轮播广告")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('coupon_homeadv_edit')" )
    public R updateById(@RequestBody HomeAdv homeAdv) {
        return R.ok(homeAdvService.updateById(homeAdv));
    }

    /**
     * 通过id删除首页轮播广告
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除首页轮播广告", notes = "通过id删除首页轮播广告")
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('coupon_homeadv_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(homeAdvService.removeById(id));
    }

}
