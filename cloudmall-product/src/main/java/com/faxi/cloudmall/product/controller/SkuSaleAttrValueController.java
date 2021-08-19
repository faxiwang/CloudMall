package com.faxi.cloudmall.product.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.product.entity.SkuSaleAttrValue;
import com.faxi.cloudmall.product.service.SkuSaleAttrValueService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * sku销售属性&值
 *
 * @author faxi
 * @date 2021-07-06 20:29:20
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/product/skusaleattrvalue" )
@Api(value = "skusaleattrvalue", tags = "sku销售属性&值管理")
public class SkuSaleAttrValueController {

    private final  SkuSaleAttrValueService skuSaleAttrValueService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param skuSaleAttrValue sku销售属性&值
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('product_skusaleattrvalue_get')" )
    public R getSkuSaleAttrValuePage(Page page, SkuSaleAttrValue skuSaleAttrValue) {
        return R.ok(skuSaleAttrValueService.page(page, Wrappers.query(skuSaleAttrValue)));
    }


    /**
     * 通过id查询sku销售属性&值
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('product_skusaleattrvalue_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(skuSaleAttrValueService.getById(id));
    }

    /**
     * 新增sku销售属性&值
     * @param skuSaleAttrValue sku销售属性&值
     * @return R
     */
    @ApiOperation(value = "新增sku销售属性&值", notes = "新增sku销售属性&值")
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('product_skusaleattrvalue_add')" )
    public R save(@RequestBody SkuSaleAttrValue skuSaleAttrValue) {
        return R.ok(skuSaleAttrValueService.save(skuSaleAttrValue));
    }

    /**
     * 修改sku销售属性&值
     * @param skuSaleAttrValue sku销售属性&值
     * @return R
     */
    @ApiOperation(value = "修改sku销售属性&值", notes = "修改sku销售属性&值")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('product_skusaleattrvalue_edit')" )
    public R updateById(@RequestBody SkuSaleAttrValue skuSaleAttrValue) {
        return R.ok(skuSaleAttrValueService.updateById(skuSaleAttrValue));
    }

    /**
     * 通过id删除sku销售属性&值
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除sku销售属性&值", notes = "通过id删除sku销售属性&值")
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('product_skusaleattrvalue_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(skuSaleAttrValueService.removeById(id));
    }

}
