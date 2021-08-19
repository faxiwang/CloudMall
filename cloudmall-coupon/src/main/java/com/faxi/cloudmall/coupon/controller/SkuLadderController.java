package com.faxi.cloudmall.coupon.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.coupon.entity.SkuLadder;
import com.faxi.cloudmall.coupon.service.SkuLadderService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 商品阶梯价格
 *
 * @author faxi
 * @date 2021-07-06 20:36:05
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/coupon/skuladder" )
@Api(value = "skuladder", tags = "商品阶梯价格管理")
public class SkuLadderController {

    private final  SkuLadderService skuLadderService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param skuLadder 商品阶梯价格
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('coupon_skuladder_get')" )
    public R getSkuLadderPage(Page page, SkuLadder skuLadder) {
        return R.ok(skuLadderService.page(page, Wrappers.query(skuLadder)));
    }


    /**
     * 通过id查询商品阶梯价格
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('coupon_skuladder_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(skuLadderService.getById(id));
    }

    /**
     * 新增商品阶梯价格
     * @param skuLadder 商品阶梯价格
     * @return R
     */
    @ApiOperation(value = "新增商品阶梯价格", notes = "新增商品阶梯价格")
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('coupon_skuladder_add')" )
    public R save(@RequestBody SkuLadder skuLadder) {
        return R.ok(skuLadderService.save(skuLadder));
    }

    /**
     * 修改商品阶梯价格
     * @param skuLadder 商品阶梯价格
     * @return R
     */
    @ApiOperation(value = "修改商品阶梯价格", notes = "修改商品阶梯价格")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('coupon_skuladder_edit')" )
    public R updateById(@RequestBody SkuLadder skuLadder) {
        return R.ok(skuLadderService.updateById(skuLadder));
    }

    /**
     * 通过id删除商品阶梯价格
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除商品阶梯价格", notes = "通过id删除商品阶梯价格")
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('coupon_skuladder_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(skuLadderService.removeById(id));
    }

}
