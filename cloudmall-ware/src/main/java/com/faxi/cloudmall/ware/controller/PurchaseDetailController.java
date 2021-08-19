package com.faxi.cloudmall.ware.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.ware.entity.PurchaseDetail;
import com.faxi.cloudmall.ware.service.PurchaseDetailService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 
 *
 * @author faxi
 * @date 2021-07-06 20:24:00
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/ware/purchasedetail" )
@Api(value = "purchasedetail", tags = "管理")
public class PurchaseDetailController {

    private final  PurchaseDetailService purchaseDetailService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param purchaseDetail 
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('ware_purchasedetail_get')" )
    public R getPurchaseDetailPage(Page page, PurchaseDetail purchaseDetail) {
        return R.ok(purchaseDetailService.page(page, Wrappers.query(purchaseDetail)));
    }


    /**
     * 通过id查询
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('ware_purchasedetail_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(purchaseDetailService.getById(id));
    }

    /**
     * 新增
     * @param purchaseDetail 
     * @return R
     */
    @ApiOperation(value = "新增", notes = "新增")
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('ware_purchasedetail_add')" )
    public R save(@RequestBody PurchaseDetail purchaseDetail) {
        return R.ok(purchaseDetailService.save(purchaseDetail));
    }

    /**
     * 修改
     * @param purchaseDetail 
     * @return R
     */
    @ApiOperation(value = "修改", notes = "修改")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('ware_purchasedetail_edit')" )
    public R updateById(@RequestBody PurchaseDetail purchaseDetail) {
        return R.ok(purchaseDetailService.updateById(purchaseDetail));
    }

    /**
     * 通过id删除
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除", notes = "通过id删除")
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('ware_purchasedetail_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(purchaseDetailService.removeById(id));
    }

}
