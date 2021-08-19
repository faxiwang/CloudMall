package com.faxi.cloudmall.coupon.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.coupon.entity.SpuBounds;
import com.faxi.cloudmall.coupon.service.SpuBoundsService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 商品spu积分设置
 *
 * @author faxi
 * @date 2021-07-06 20:36:05
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/coupon/spubounds" )
@Api(value = "spubounds", tags = "商品spu积分设置管理")
public class SpuBoundsController {

    private final  SpuBoundsService spuBoundsService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param spuBounds 商品spu积分设置
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('coupon_spubounds_get')" )
    public R getSpuBoundsPage(Page page, SpuBounds spuBounds) {
        return R.ok(spuBoundsService.page(page, Wrappers.query(spuBounds)));
    }


    /**
     * 通过id查询商品spu积分设置
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('coupon_spubounds_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(spuBoundsService.getById(id));
    }

    /**
     * 新增商品spu积分设置
     * @param spuBounds 商品spu积分设置
     * @return R
     */
    @ApiOperation(value = "新增商品spu积分设置", notes = "新增商品spu积分设置")
    @PostMapping("/save")
    //@PreAuthorize("@pms.hasPermission('coupon_spubounds_add')" )
    public R save(@RequestBody SpuBounds spuBounds) {
        return R.ok(spuBoundsService.save(spuBounds));
    }

    /**
     * 修改商品spu积分设置
     * @param spuBounds 商品spu积分设置
     * @return R
     */
    @ApiOperation(value = "修改商品spu积分设置", notes = "修改商品spu积分设置")
    @PostMapping("/update")
    //@PreAuthorize("@pms.hasPermission('coupon_spubounds_edit')" )
    public R updateById(@RequestBody SpuBounds spuBounds) {
        return R.ok(spuBoundsService.updateById(spuBounds));
    }

    /**
     * 通过id删除商品spu积分设置
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除商品spu积分设置", notes = "通过id删除商品spu积分设置")
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('coupon_spubounds_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(spuBoundsService.removeById(id));
    }

}
