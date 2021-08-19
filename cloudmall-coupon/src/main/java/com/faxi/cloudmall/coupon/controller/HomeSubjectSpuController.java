package com.faxi.cloudmall.coupon.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.coupon.entity.HomeSubjectSpu;
import com.faxi.cloudmall.coupon.service.HomeSubjectSpuService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 专题商品
 *
 * @author faxi
 * @date 2021-07-06 20:36:05
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/coupon/homesubjectspu" )
@Api(value = "homesubjectspu", tags = "专题商品管理")
public class HomeSubjectSpuController {

    private final  HomeSubjectSpuService homeSubjectSpuService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param homeSubjectSpu 专题商品
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('coupon_homesubjectspu_get')" )
    public R getHomeSubjectSpuPage(Page page, HomeSubjectSpu homeSubjectSpu) {
        return R.ok(homeSubjectSpuService.page(page, Wrappers.query(homeSubjectSpu)));
    }


    /**
     * 通过id查询专题商品
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('coupon_homesubjectspu_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(homeSubjectSpuService.getById(id));
    }

    /**
     * 新增专题商品
     * @param homeSubjectSpu 专题商品
     * @return R
     */
    @ApiOperation(value = "新增专题商品", notes = "新增专题商品")
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('coupon_homesubjectspu_add')" )
    public R save(@RequestBody HomeSubjectSpu homeSubjectSpu) {
        return R.ok(homeSubjectSpuService.save(homeSubjectSpu));
    }

    /**
     * 修改专题商品
     * @param homeSubjectSpu 专题商品
     * @return R
     */
    @ApiOperation(value = "修改专题商品", notes = "修改专题商品")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('coupon_homesubjectspu_edit')" )
    public R updateById(@RequestBody HomeSubjectSpu homeSubjectSpu) {
        return R.ok(homeSubjectSpuService.updateById(homeSubjectSpu));
    }

    /**
     * 通过id删除专题商品
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除专题商品", notes = "通过id删除专题商品")
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('coupon_homesubjectspu_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(homeSubjectSpuService.removeById(id));
    }

}
