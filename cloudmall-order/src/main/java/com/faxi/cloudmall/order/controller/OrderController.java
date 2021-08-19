package com.faxi.cloudmall.order.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.order.entity.Order;
import com.faxi.cloudmall.order.service.OrderService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 订单
 *
 * @author faxi
 * @date 2021-07-06 20:31:28
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/order/order" )
@Api(value = "order", tags = "订单管理")
public class OrderController {

    private final  OrderService orderService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param order 订单
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('order_order_get')" )
    public R getOrderPage(Page page, Order order) {
        return R.ok(orderService.page(page, Wrappers.query(order)));
    }


    /**
     * 通过id查询订单
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('order_order_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(orderService.getById(id));
    }

    /**
     * 新增订单
     * @param order 订单
     * @return R
     */
    @ApiOperation(value = "新增订单", notes = "新增订单")
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('order_order_add')" )
    public R save(@RequestBody Order order) {
        return R.ok(orderService.save(order));
    }

    /**
     * 修改订单
     * @param order 订单
     * @return R
     */
    @ApiOperation(value = "修改订单", notes = "修改订单")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('order_order_edit')" )
    public R updateById(@RequestBody Order order) {
        return R.ok(orderService.updateById(order));
    }

    /**
     * 通过id删除订单
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除订单", notes = "通过id删除订单")
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('order_order_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(orderService.removeById(id));
    }

}
