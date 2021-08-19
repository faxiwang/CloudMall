package com.faxi.cloudmall.product.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.product.entity.Brand;
import com.faxi.cloudmall.product.entity.CategoryBrandRelation;
import com.faxi.cloudmall.product.service.CategoryBrandRelationService;
import com.faxi.cloudmall.product.vo.BrandVo;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * 品牌分类关联
 *
 * @author faxi
 * @date 2021-07-06 20:29:20
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/product/categorybrandrelation" )
@Api(value = "categorybrandrelation", tags = "品牌分类关联管理")
public class CategoryBrandRelationController {

    private final  CategoryBrandRelationService categoryBrandRelationService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param categoryBrandRelation 品牌分类关联
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('product_categorybrandrelation_get')" )
    public R getCategoryBrandRelationPage(Page page, CategoryBrandRelation categoryBrandRelation) {
        return R.ok(categoryBrandRelationService.page(page, Wrappers.query(categoryBrandRelation)));
    }

    /**
     * 获取当前品牌关联的所有分类列表列表
     * @param brandId
     * @param brandId
     * @return
     */
    @GetMapping(value = "/catelog/list")
    public R catelogList(@RequestParam("brandId") Long brandId){

        List<CategoryBrandRelation> data = categoryBrandRelationService.
                list(new LambdaQueryWrapper<CategoryBrandRelation>().eq(CategoryBrandRelation::getBrandId,brandId));

        return R.ok(data);
    }

    /**
     *
     * @param catId
     * @return
     */
    @GetMapping(value = "/brands/list")
    public R relationBransList(@RequestParam(value = "catId",required = true) Long catId) {

        List<Brand> vos = categoryBrandRelationService.getBrandsByCatId(catId);

        List<BrandVo> list = vos.stream().map(item -> {
            BrandVo brandVo = new BrandVo();
            brandVo.setBrandId(item.getBrandId());
            brandVo.setBrandName(item.getName());
            return brandVo;
        }).collect(Collectors.toList());

        return R.ok(list);
    }



    /**
     * 通过id查询品牌分类关联
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('product_categorybrandrelation_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(categoryBrandRelationService.getById(id));
    }

    /**
     * 新增品牌分类关联
     * @param categoryBrandRelation 品牌分类关联
     * @return R
     */
    @ApiOperation(value = "新增品牌分类关联", notes = "新增品牌分类关联")
    @PostMapping("/save")
    //@PreAuthorize("@pms.hasPermission('product_categorybrandrelation_add')" )
    public R save(@RequestBody CategoryBrandRelation categoryBrandRelation) {
        categoryBrandRelationService.saveBrandRelation(categoryBrandRelation);
        return R.ok();
    }

    /**
     * 修改品牌分类关联
     * @param categoryBrandRelation 品牌分类关联
     * @return R
     */
    @ApiOperation(value = "修改品牌分类关联", notes = "修改品牌分类关联")
    @PutMapping("/update")
    //@PreAuthorize("@pms.hasPermission('product_categorybrandrelation_edit')" )
    public R updateById(@RequestBody CategoryBrandRelation categoryBrandRelation) {
        return R.ok(categoryBrandRelationService.updateById(categoryBrandRelation));
    }

    /**
     * 通过id删除品牌分类关联
     * @param ids ids
     * @return R
     */
    @ApiOperation(value = "通过id删除品牌分类关联", notes = "通过id删除品牌分类关联")
    @PostMapping("/delete" )
    //@PreAuthorize("@pms.hasPermission('product_categorybrandrelation_del')" )
    public R removeById(@RequestBody Long[] ids) {
        return R.ok(categoryBrandRelationService.removeByIds(Arrays.asList(ids)));
    }

}
