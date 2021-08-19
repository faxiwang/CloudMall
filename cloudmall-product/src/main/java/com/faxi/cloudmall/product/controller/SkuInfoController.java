package com.faxi.cloudmall.product.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.product.entity.SkuInfo;
import com.faxi.cloudmall.product.service.SkuInfoService;
import com.faxi.cloudmall.product.vo.SkuInfoVo;
import com.faxi.cloudmall.product.vo.SpuSaveVo;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * sku信息
 *
 * @author faxi
 * @date 2021-07-06 20:29:20
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/product/skuinfo" )
@Api(value = "skuinfo", tags = "sku信息管理")
public class SkuInfoController {

    private final  SkuInfoService skuInfoService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param skuInfo sku信息
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('product_skuinfo_get')" )
    public R getSkuInfoPage(Page page, SkuInfoVo skuInfo) {
        page = skuInfoService.queryPage(page,skuInfo);
        return R.ok(page);
    }


    /**
     * 通过id查询sku信息
     * @param skuId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{skuId}" )
    //@PreAuthorize("@pms.hasPermission('product_skuinfo_get')" )
    public R getById(@PathVariable("skuId" ) Long skuId) {
        return R.ok(skuInfoService.getById(skuId));
    }

    /**
     * 新增sku信息
     * @param data sku信息
     * @return R
     */
    @ApiOperation(value = "新增sku信息", notes = "新增sku信息")
    @PostMapping("/save")
    //@PreAuthorize("@pms.hasPermission('product_skuinfo_add')" )
    public R save(@RequestBody SkuInfo data) {
        return R.ok(skuInfoService.save(data));
    }

    /**
     * 修改sku信息
     * @param skuInfo sku信息
     * @return R
     */
    @ApiOperation(value = "修改sku信息", notes = "修改sku信息")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('product_skuinfo_edit')" )
    public R updateById(@RequestBody SkuInfo skuInfo) {
        return R.ok(skuInfoService.updateById(skuInfo));
    }

    /**
     * 通过id删除sku信息
     * @param skuId id
     * @return R
     */
    @ApiOperation(value = "通过id删除sku信息", notes = "通过id删除sku信息")
    @DeleteMapping("/{skuId}" )
    //@PreAuthorize("@pms.hasPermission('product_skuinfo_del')" )
    public R removeById(@PathVariable Long skuId) {
        return R.ok(skuInfoService.removeById(skuId));
    }

}
