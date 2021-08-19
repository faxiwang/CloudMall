package com.faxi.cloudmall.product.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.product.entity.SpuComment;
import com.faxi.cloudmall.product.service.SpuCommentService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 商品评价
 *
 * @author faxi
 * @date 2021-07-06 20:29:20
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/product/spucomment" )
@Api(value = "spucomment", tags = "商品评价管理")
public class SpuCommentController {

    private final  SpuCommentService spuCommentService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param spuComment 商品评价
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('product_spucomment_get')" )
    public R getSpuCommentPage(Page page, SpuComment spuComment) {
        return R.ok(spuCommentService.page(page, Wrappers.query(spuComment)));
    }


    /**
     * 通过id查询商品评价
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('product_spucomment_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(spuCommentService.getById(id));
    }

    /**
     * 新增商品评价
     * @param spuComment 商品评价
     * @return R
     */
    @ApiOperation(value = "新增商品评价", notes = "新增商品评价")
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('product_spucomment_add')" )
    public R save(@RequestBody SpuComment spuComment) {
        return R.ok(spuCommentService.save(spuComment));
    }

    /**
     * 修改商品评价
     * @param spuComment 商品评价
     * @return R
     */
    @ApiOperation(value = "修改商品评价", notes = "修改商品评价")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('product_spucomment_edit')" )
    public R updateById(@RequestBody SpuComment spuComment) {
        return R.ok(spuCommentService.updateById(spuComment));
    }

    /**
     * 通过id删除商品评价
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除商品评价", notes = "通过id删除商品评价")
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('product_spucomment_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(spuCommentService.removeById(id));
    }

}
