package com.faxi.cloudmall.coupon.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.coupon.entity.SkuFullReduction;
import com.faxi.cloudmall.coupon.service.SkuFullReductionService;
import com.faxi.common.to.SkuReductionTo;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 商品满减信息
 *
 * @author faxi
 * @date 2021-07-06 20:36:05
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/coupon/skufullreduction" )
@Api(value = "skufullreduction", tags = "商品满减信息管理")
public class SkuFullReductionController {

    private final  SkuFullReductionService skuFullReductionService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param skuFullReduction 商品满减信息
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('coupon_skufullreduction_get')" )
    public R getSkuFullReductionPage(Page page, SkuFullReduction skuFullReduction) {
        return R.ok(skuFullReductionService.page(page, Wrappers.query(skuFullReduction)));
    }


    /**
     * 通过id查询商品满减信息
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('coupon_skufullreduction_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(skuFullReductionService.getById(id));
    }

    @PostMapping("/saveinfo")
    public R saveInfo(@RequestBody SkuReductionTo skuReductionTo){

        skuFullReductionService.saveSkuReduction(skuReductionTo);

        return R.ok();
    }

    /**
     * 新增商品满减信息
     * @param skuFullReduction 商品满减信息
     * @return R
     */
    @ApiOperation(value = "新增商品满减信息", notes = "新增商品满减信息")
    @PostMapping("/save")
    //@PreAuthorize("@pms.hasPermission('coupon_skufullreduction_add')" )
    public R save(@RequestBody SkuFullReduction skuFullReduction) {
        return R.ok(skuFullReductionService.save(skuFullReduction));
    }

    /**
     * 修改商品满减信息
     * @param skuFullReduction 商品满减信息
     * @return R
     */
    @ApiOperation(value = "修改商品满减信息", notes = "修改商品满减信息")
    @PostMapping("/update")
    //@PreAuthorize("@pms.hasPermission('coupon_skufullreduction_edit')" )
    public R updateById(@RequestBody SkuFullReduction skuFullReduction) {
        return R.ok(skuFullReductionService.updateById(skuFullReduction));
    }

    /**
     * 通过id删除商品满减信息
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除商品满减信息", notes = "通过id删除商品满减信息")
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('coupon_skufullreduction_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(skuFullReductionService.removeById(id));
    }

}
