package com.faxi.cloudmall.product.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.product.entity.SkuImages;
import com.faxi.cloudmall.product.service.SkuImagesService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * sku图片
 *
 * @author faxi
 * @date 2021-07-06 20:29:20
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/product/skuimages" )
@Api(value = "skuimages", tags = "sku图片管理")
public class SkuImagesController {

    private final  SkuImagesService skuImagesService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param skuImages sku图片
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('product_skuimages_get')" )
    public R getSkuImagesPage(Page page, SkuImages skuImages) {
        return R.ok(skuImagesService.page(page, Wrappers.query(skuImages)));
    }


    /**
     * 通过id查询sku图片
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('product_skuimages_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(skuImagesService.getById(id));
    }

    /**
     * 新增sku图片
     * @param skuImages sku图片
     * @return R
     */
    @ApiOperation(value = "新增sku图片", notes = "新增sku图片")
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('product_skuimages_add')" )
    public R save(@RequestBody SkuImages skuImages) {
        return R.ok(skuImagesService.save(skuImages));
    }

    /**
     * 修改sku图片
     * @param skuImages sku图片
     * @return R
     */
    @ApiOperation(value = "修改sku图片", notes = "修改sku图片")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('product_skuimages_edit')" )
    public R updateById(@RequestBody SkuImages skuImages) {
        return R.ok(skuImagesService.updateById(skuImages));
    }

    /**
     * 通过id删除sku图片
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除sku图片", notes = "通过id删除sku图片")
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('product_skuimages_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(skuImagesService.removeById(id));
    }

}
