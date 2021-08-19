package com.faxi.cloudmall.order.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.order.entity.OrderSetting;
import com.faxi.cloudmall.order.service.OrderSettingService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 订单配置信息
 *
 * @author faxi
 * @date 2021-07-06 20:31:28
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/order/ordersetting" )
@Api(value = "ordersetting", tags = "订单配置信息管理")
public class OrderSettingController {

    private final  OrderSettingService orderSettingService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param orderSetting 订单配置信息
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('order_ordersetting_get')" )
    public R getOrderSettingPage(Page page, OrderSetting orderSetting) {
        return R.ok(orderSettingService.page(page, Wrappers.query(orderSetting)));
    }


    /**
     * 通过id查询订单配置信息
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('order_ordersetting_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(orderSettingService.getById(id));
    }

    /**
     * 新增订单配置信息
     * @param orderSetting 订单配置信息
     * @return R
     */
    @ApiOperation(value = "新增订单配置信息", notes = "新增订单配置信息")
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('order_ordersetting_add')" )
    public R save(@RequestBody OrderSetting orderSetting) {
        return R.ok(orderSettingService.save(orderSetting));
    }

    /**
     * 修改订单配置信息
     * @param orderSetting 订单配置信息
     * @return R
     */
    @ApiOperation(value = "修改订单配置信息", notes = "修改订单配置信息")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('order_ordersetting_edit')" )
    public R updateById(@RequestBody OrderSetting orderSetting) {
        return R.ok(orderSettingService.updateById(orderSetting));
    }

    /**
     * 通过id删除订单配置信息
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除订单配置信息", notes = "通过id删除订单配置信息")
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('order_ordersetting_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(orderSettingService.removeById(id));
    }

}
