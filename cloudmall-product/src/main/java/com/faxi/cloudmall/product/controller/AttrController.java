package com.faxi.cloudmall.product.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.product.entity.Attr;
import com.faxi.cloudmall.product.service.AttrService;
import com.faxi.cloudmall.product.vo.AttrVo;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 商品属性
 *
 * @author faxi
 * @date 2021-07-06 20:29:20
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/product/attr")
@Api(value = "attr", tags = "商品属性管理")
public class AttrController {

    private final AttrService attrService;


    @GetMapping("/{attrType}/page/{catelogId}")
    public R baseAttrList(Page page, String key, @PathVariable("catelogId") Long catelogId, @PathVariable("attrType") String type) {

        page = attrService.queryBaseAttrPage(page, key, catelogId, type);
        return R.ok(page);
    }

    /**
     * 分页查询
     *
     * @param page 分页对象
     * @param attr 商品属性
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page")
    //@PreAuthorize("@pms.hasPermission('product_attr_get')" )
    public R getAttrPage(Page page, Attr attr) {
        return R.ok(attrService.page(page, Wrappers.query(attr)));
    }


    /**
     * 通过id查询商品属性
     *
     * @param attrId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{attrId}")
    //@PreAuthorize("@pms.hasPermission('product_attr_get')" )
    public R getById(@PathVariable("attrId") Long attrId) {
        return R.ok(attrService.getAttrInfo(attrId));
    }

    /**
     * 新增商品属性
     *
     * @param attr 商品属性
     * @return R
     */
    @ApiOperation(value = "新增商品属性", notes = "新增商品属性")
    @PostMapping("/save")
    //@PreAuthorize("@pms.hasPermission('product_attr_add')" )
    public R save(@RequestBody AttrVo attr) {
        attrService.saveAttr(attr);
        return R.ok(true);
    }

    /**
     * 修改商品属性
     *
     * @param attr 商品属性
     * @return R
     */
    @ApiOperation(value = "修改商品属性", notes = "修改商品属性")
    @PostMapping("update")
    //@PreAuthorize("@pms.hasPermission('product_attr_edit')" )
    public R updateById(@RequestBody AttrVo attr) {
        attrService.updateAttrById(attr);
        return R.ok();
    }

    /**
     * 通过id删除商品属性
     *
     * @param attrId id
     * @return R
     */
    @ApiOperation(value = "通过id删除商品属性", notes = "通过id删除商品属性")
    @PostMapping("/delete")
    //@PreAuthorize("@pms.hasPermission('product_attr_del')" )
    public R removeById(@RequestBody Long[] attrId) {
        return R.ok(attrService.removeByIds(Arrays.asList(attrId)));
    }

}
