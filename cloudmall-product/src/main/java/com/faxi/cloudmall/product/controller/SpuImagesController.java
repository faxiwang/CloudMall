package com.faxi.cloudmall.product.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.product.entity.SpuImages;
import com.faxi.cloudmall.product.service.SpuImagesService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * spu图片
 *
 * @author faxi
 * @date 2021-07-06 20:29:19
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/product/spuimages" )
@Api(value = "spuimages", tags = "spu图片管理")
public class SpuImagesController {

    private final  SpuImagesService spuImagesService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param spuImages spu图片
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('product_spuimages_get')" )
    public R getSpuImagesPage(Page page, SpuImages spuImages) {
        return R.ok(spuImagesService.page(page, Wrappers.query(spuImages)));
    }


    /**
     * 通过id查询spu图片
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('product_spuimages_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(spuImagesService.getById(id));
    }

    /**
     * 新增spu图片
     * @param spuImages spu图片
     * @return R
     */
    @ApiOperation(value = "新增spu图片", notes = "新增spu图片")
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('product_spuimages_add')" )
    public R save(@RequestBody SpuImages spuImages) {
        return R.ok(spuImagesService.save(spuImages));
    }

    /**
     * 修改spu图片
     * @param spuImages spu图片
     * @return R
     */
    @ApiOperation(value = "修改spu图片", notes = "修改spu图片")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('product_spuimages_edit')" )
    public R updateById(@RequestBody SpuImages spuImages) {
        return R.ok(spuImagesService.updateById(spuImages));
    }

    /**
     * 通过id删除spu图片
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除spu图片", notes = "通过id删除spu图片")
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('product_spuimages_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(spuImagesService.removeById(id));
    }

}
