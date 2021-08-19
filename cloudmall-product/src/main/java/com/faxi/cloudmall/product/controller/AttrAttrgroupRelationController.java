package com.faxi.cloudmall.product.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.product.entity.AttrAttrgroupRelation;
import com.faxi.cloudmall.product.service.AttrAttrgroupRelationService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 属性&属性分组关联
 *
 * @author faxi
 * @date 2021-07-06 20:29:20
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/product/attrattrgrouprelation" )
@Api(value = "attrattrgrouprelation", tags = "属性&属性分组关联管理")
public class AttrAttrgroupRelationController {

    private final  AttrAttrgroupRelationService attrAttrgroupRelationService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param attrAttrgroupRelation 属性&属性分组关联
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('product_attrattrgrouprelation_get')" )
    public R getAttrAttrgroupRelationPage(Page page, AttrAttrgroupRelation attrAttrgroupRelation) {
        return R.ok(attrAttrgroupRelationService.page(page, Wrappers.query(attrAttrgroupRelation)));
    }


    /**
     * 通过id查询属性&属性分组关联
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('product_attrattrgrouprelation_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(attrAttrgroupRelationService.getById(id));
    }

    /**
     * 新增属性&属性分组关联
     * @param attrAttrgroupRelation 属性&属性分组关联
     * @return R
     */
    @ApiOperation(value = "新增属性&属性分组关联", notes = "新增属性&属性分组关联")
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('product_attrattrgrouprelation_add')" )
    public R save(@RequestBody AttrAttrgroupRelation attrAttrgroupRelation) {
        return R.ok(attrAttrgroupRelationService.save(attrAttrgroupRelation));
    }

    /**
     * 修改属性&属性分组关联
     * @param attrAttrgroupRelation 属性&属性分组关联
     * @return R
     */
    @ApiOperation(value = "修改属性&属性分组关联", notes = "修改属性&属性分组关联")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('product_attrattrgrouprelation_edit')" )
    public R updateById(@RequestBody AttrAttrgroupRelation attrAttrgroupRelation) {
        return R.ok(attrAttrgroupRelationService.updateById(attrAttrgroupRelation));
    }

    /**
     * 通过id删除属性&属性分组关联
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除属性&属性分组关联", notes = "通过id删除属性&属性分组关联")
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('product_attrattrgrouprelation_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(attrAttrgroupRelationService.removeById(id));
    }

}
