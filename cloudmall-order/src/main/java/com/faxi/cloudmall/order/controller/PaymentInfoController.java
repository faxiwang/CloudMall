package com.faxi.cloudmall.order.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.order.entity.PaymentInfo;
import com.faxi.cloudmall.order.service.PaymentInfoService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 支付信息表
 *
 * @author faxi
 * @date 2021-07-06 20:31:28
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/order/paymentinfo" )
@Api(value = "paymentinfo", tags = "支付信息表管理")
public class PaymentInfoController {

    private final  PaymentInfoService paymentInfoService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param paymentInfo 支付信息表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('order_paymentinfo_get')" )
    public R getPaymentInfoPage(Page page, PaymentInfo paymentInfo) {
        return R.ok(paymentInfoService.page(page, Wrappers.query(paymentInfo)));
    }


    /**
     * 通过id查询支付信息表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('order_paymentinfo_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(paymentInfoService.getById(id));
    }

    /**
     * 新增支付信息表
     * @param paymentInfo 支付信息表
     * @return R
     */
    @ApiOperation(value = "新增支付信息表", notes = "新增支付信息表")
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('order_paymentinfo_add')" )
    public R save(@RequestBody PaymentInfo paymentInfo) {
        return R.ok(paymentInfoService.save(paymentInfo));
    }

    /**
     * 修改支付信息表
     * @param paymentInfo 支付信息表
     * @return R
     */
    @ApiOperation(value = "修改支付信息表", notes = "修改支付信息表")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('order_paymentinfo_edit')" )
    public R updateById(@RequestBody PaymentInfo paymentInfo) {
        return R.ok(paymentInfoService.updateById(paymentInfo));
    }

    /**
     * 通过id删除支付信息表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除支付信息表", notes = "通过id删除支付信息表")
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('order_paymentinfo_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(paymentInfoService.removeById(id));
    }

}
