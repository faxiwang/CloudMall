package com.faxi.cloudmall.product.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.product.entity.Brand;
import com.faxi.cloudmall.product.service.BrandService;
import com.faxi.common.utis.R;
import com.faxi.common.vaild.AddVaild;
import com.faxi.common.vaild.UpdateVaild;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


/**
 * 品牌
 *
 * @author faxi
 * @date 2021-07-06 20:29:20
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/product/brand")
@Api(value = "brand", tags = "品牌管理")
public class BrandController {

    private final BrandService brandService;

    /**
     * 分页查询
     *
     * @param page  分页对象
     * @param brand 品牌
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page")
    //@PreAuthorize("@pms.hasPermission('product_brand_get')" )
    public R getBrandPage(Page page, String key) {
        return R.ok(brandService.queryPage(page,key));
    }


    /**
     * 通过id查询品牌
     *
     * @param brandId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{brandId}")
    //@PreAuthorize("@pms.hasPermission('product_brand_get')" )
    public R getById(@PathVariable("brandId") Long brandId) {
        return R.ok(brandService.getById(brandId));
    }

    /**
     * 新增品牌
     *
     * @param brand 品牌
     * @return R
     */
    @ApiOperation(value = "新增品牌", notes = "新增品牌")
    @PostMapping("/save")
    //@PreAuthorize("@pms.hasPermission('product_brand_add')" )
    public R save(@Validated({AddVaild.class}) @RequestBody Brand brand) {
        return R.ok(brandService.save(brand));
    }

    /**
     * 修改品牌
     *
     * @param brand 品牌
     * @return R
     */
    @ApiOperation(value = "修改品牌", notes = "修改品牌")
    @PostMapping("/update")
    //@PreAuthorize("@pms.hasPermission('product_brand_edit')" )
    public R updateById(@Validated({UpdateVaild.class}) @RequestBody Brand brand) {
        brandService.updatBrand(brand);
        return R.ok();
    }

    /**
     * 通过id删除品牌
     *
     * @param brandId id
     * @return R
     */
    @ApiOperation(value = "通过id删除品牌", notes = "通过id删除品牌")
    @PostMapping("/delete")
    //@PreAuthorize("@pms.hasPermission('product_brand_del')" )
    public R removeById(@RequestBody Long[] brandId) {
        return R.ok(brandService.removeByIds(Arrays.asList(brandId)));
    }

}
