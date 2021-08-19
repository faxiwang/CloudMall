package com.faxi.cloudmall.product.controller;

import com.faxi.cloudmall.product.entity.Category;
import com.faxi.cloudmall.product.service.CategoryService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


/**
 * 商品三级分类
 *
 * @author faxi
 * @date 2021-07-06 20:29:20
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/product/category" )
@Api(value = "category", tags = "商品三级分类管理")
public class CategoryController {

    private final  CategoryService categoryService;

    /**
     * 获取分类树
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/getTree" )
    //@PreAuthorize("@pms.hasPermission('product_category_get')" )
    public R getTree() {
        List<Category> list =  categoryService.getTree();
        return R.ok(list);
    }


    /**
     * 通过id查询商品三级分类
     * @param catId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{catId}" )
    //@PreAuthorize("@pms.hasPermission('product_category_get')" )
    public R getById(@PathVariable("catId" ) Long catId) {
        return R.ok(categoryService.getById(catId));
    }

    /**
     * 新增商品三级分类
     * @param category 商品三级分类
     * @return R
     */
    @ApiOperation(value = "新增商品三级分类", notes = "新增商品三级分类")
    @PostMapping("/save")
    //@PreAuthorize("@pms.hasPermission('product_category_add')" )
    public R save(@RequestBody Category category) {
        return R.ok(categoryService.save(category));
    }

    /**
     * 修改商品三级分类
     * @param category 商品三级分类
     * @return R
     */
    @ApiOperation(value = "修改商品三级分类", notes = "修改商品三级分类")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('product_category_edit')" )
    public R updateById(@RequestBody Category category) {
        return R.ok(categoryService.updateById(category));
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:category:update")
    public R update(@RequestBody Category category){
        categoryService.updateCategory(category);
        return R.ok();
    }

    /**
     *
     * @param category 修改排序
     * @return
     */
    @RequestMapping("/updateSort")
    //@RequiresPermissions("product:category:update")
    public R updateSort(@RequestBody Category[] category){
        categoryService.updateBatchById(Arrays.asList(category));
        return R.ok();
    }

    /**
     * 通过id删除商品三级分类
     * @param catId id
     * @return R
     */
    @ApiOperation(value = "通过id删除商品三级分类", notes = "通过id删除商品三级分类")
    @DeleteMapping("/{catId}" )
    //@PreAuthorize("@pms.hasPermission('product_category_del')" )
    public R removeById(@PathVariable Long catId) {
        return R.ok(categoryService.removeById(catId));
    }

    /**
     * 通过id删除商品三级分类
     * @param catIds id
     * @return R
     */
    @ApiOperation(value = "通过id删除商品三级分类", notes = "通过id删除商品三级分类")
    @PostMapping("/delete" )
    //@PreAuthorize("@pms.hasPermission('product_category_del')" )
    public R removeByIds(@RequestBody Long[] catIds) {
        categoryService.deleteByIds(Arrays.asList(catIds));
        return R.ok();
    }


}
