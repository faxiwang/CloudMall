package com.faxi.cloudmall.ware.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.ware.entity.Purchase;
import com.faxi.cloudmall.ware.service.PurchaseService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 采购信息
 *
 * @author faxi
 * @date 2021-07-06 20:24:00
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/ware/purchase" )
@Api(value = "purchase", tags = "采购信息管理")
public class PurchaseController {

    private final  PurchaseService purchaseService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param purchase 采购信息
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('ware_purchase_get')" )
    public R getPurchasePage(Page page, Purchase purchase) {
        return R.ok(purchaseService.page(page, Wrappers.query(purchase)));
    }


    /**
     * 通过id查询采购信息
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('ware_purchase_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(purchaseService.getById(id));
    }

    /**
     * 新增采购信息
     * @param purchase 采购信息
     * @return R
     */
    @ApiOperation(value = "新增采购信息", notes = "新增采购信息")
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('ware_purchase_add')" )
    public R save(@RequestBody Purchase purchase) {
        return R.ok(purchaseService.save(purchase));
    }

    /**
     * 修改采购信息
     * @param purchase 采购信息
     * @return R
     */
    @ApiOperation(value = "修改采购信息", notes = "修改采购信息")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('ware_purchase_edit')" )
    public R updateById(@RequestBody Purchase purchase) {
        return R.ok(purchaseService.updateById(purchase));
    }

    /**
     * 通过id删除采购信息
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除采购信息", notes = "通过id删除采购信息")
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('ware_purchase_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(purchaseService.removeById(id));
    }

}
