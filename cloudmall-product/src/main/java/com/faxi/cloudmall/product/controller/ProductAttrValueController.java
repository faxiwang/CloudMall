package com.faxi.cloudmall.product.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.product.entity.ProductAttrValue;
import com.faxi.cloudmall.product.service.ProductAttrValueService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * spu属性值
 *
 * @author faxi
 * @date 2021-07-06 20:29:20
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/product/productattrvalue" )
@Api(value = "productattrvalue", tags = "spu属性值管理")
public class ProductAttrValueController {

    private final  ProductAttrValueService productAttrValueService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param productAttrValue spu属性值
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('product_productattrvalue_get')" )
    public R getProductAttrValuePage(Page page, ProductAttrValue productAttrValue) {
        return R.ok(productAttrValueService.page(page, Wrappers.query(productAttrValue)));
    }


    /**
     * 通过id查询spu属性值
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('product_productattrvalue_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(productAttrValueService.getById(id));
    }

    /**
     * 新增spu属性值
     * @param productAttrValue spu属性值
     * @return R
     */
    @ApiOperation(value = "新增spu属性值", notes = "新增spu属性值")
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('product_productattrvalue_add')" )
    public R save(@RequestBody ProductAttrValue productAttrValue) {
        return R.ok(productAttrValueService.save(productAttrValue));
    }

    /**
     * 修改spu属性值
     * @param productAttrValue spu属性值
     * @return R
     */
    @ApiOperation(value = "修改spu属性值", notes = "修改spu属性值")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('product_productattrvalue_edit')" )
    public R updateById(@RequestBody ProductAttrValue productAttrValue) {
        return R.ok(productAttrValueService.updateById(productAttrValue));
    }

    /**
     * 通过id删除spu属性值
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除spu属性值", notes = "通过id删除spu属性值")
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('product_productattrvalue_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(productAttrValueService.removeById(id));
    }

}
