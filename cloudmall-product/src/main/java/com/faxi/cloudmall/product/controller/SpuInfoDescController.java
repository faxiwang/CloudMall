package com.faxi.cloudmall.product.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.product.entity.SpuInfoDesc;
import com.faxi.cloudmall.product.service.SpuInfoDescService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * spu信息介绍
 *
 * @author faxi
 * @date 2021-07-06 20:29:20
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/product/spuinfodesc" )
@Api(value = "spuinfodesc", tags = "spu信息介绍管理")
public class SpuInfoDescController {

    private final  SpuInfoDescService spuInfoDescService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param spuInfoDesc spu信息介绍
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('product_spuinfodesc_get')" )
    public R getSpuInfoDescPage(Page page, SpuInfoDesc spuInfoDesc) {
        return R.ok(spuInfoDescService.page(page, Wrappers.query(spuInfoDesc)));
    }


    /**
     * 通过id查询spu信息介绍
     * @param spuId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{spuId}" )
    //@PreAuthorize("@pms.hasPermission('product_spuinfodesc_get')" )
    public R getById(@PathVariable("spuId" ) Long spuId) {
        return R.ok(spuInfoDescService.getById(spuId));
    }

    /**
     * 新增spu信息介绍
     * @param spuInfoDesc spu信息介绍
     * @return R
     */
    @ApiOperation(value = "新增spu信息介绍", notes = "新增spu信息介绍")
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('product_spuinfodesc_add')" )
    public R save(@RequestBody SpuInfoDesc spuInfoDesc) {
        return R.ok(spuInfoDescService.save(spuInfoDesc));
    }

    /**
     * 修改spu信息介绍
     * @param spuInfoDesc spu信息介绍
     * @return R
     */
    @ApiOperation(value = "修改spu信息介绍", notes = "修改spu信息介绍")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('product_spuinfodesc_edit')" )
    public R updateById(@RequestBody SpuInfoDesc spuInfoDesc) {
        return R.ok(spuInfoDescService.updateById(spuInfoDesc));
    }

    /**
     * 通过id删除spu信息介绍
     * @param spuId id
     * @return R
     */
    @ApiOperation(value = "通过id删除spu信息介绍", notes = "通过id删除spu信息介绍")
    @DeleteMapping("/{spuId}" )
    //@PreAuthorize("@pms.hasPermission('product_spuinfodesc_del')" )
    public R removeById(@PathVariable Long spuId) {
        return R.ok(spuInfoDescService.removeById(spuId));
    }

}
