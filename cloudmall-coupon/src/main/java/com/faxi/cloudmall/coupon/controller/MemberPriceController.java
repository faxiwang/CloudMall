package com.faxi.cloudmall.coupon.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.coupon.entity.MemberPrice;
import com.faxi.cloudmall.coupon.service.MemberPriceService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 商品会员价格
 *
 * @author faxi
 * @date 2021-07-06 20:36:05
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/coupon/memberprice" )
@Api(value = "memberprice", tags = "商品会员价格管理")
public class MemberPriceController {

    private final  MemberPriceService memberPriceService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param memberPrice 商品会员价格
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('coupon_memberprice_get')" )
    public R getMemberPricePage(Page page, MemberPrice memberPrice) {
        return R.ok(memberPriceService.page(page, Wrappers.query(memberPrice)));
    }


    /**
     * 通过id查询商品会员价格
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('coupon_memberprice_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(memberPriceService.getById(id));
    }

    /**
     * 新增商品会员价格
     * @param memberPrice 商品会员价格
     * @return R
     */
    @ApiOperation(value = "新增商品会员价格", notes = "新增商品会员价格")
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('coupon_memberprice_add')" )
    public R save(@RequestBody MemberPrice memberPrice) {
        return R.ok(memberPriceService.save(memberPrice));
    }

    /**
     * 修改商品会员价格
     * @param memberPrice 商品会员价格
     * @return R
     */
    @ApiOperation(value = "修改商品会员价格", notes = "修改商品会员价格")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('coupon_memberprice_edit')" )
    public R updateById(@RequestBody MemberPrice memberPrice) {
        return R.ok(memberPriceService.updateById(memberPrice));
    }

    /**
     * 通过id删除商品会员价格
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除商品会员价格", notes = "通过id删除商品会员价格")
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('coupon_memberprice_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(memberPriceService.removeById(id));
    }

}
