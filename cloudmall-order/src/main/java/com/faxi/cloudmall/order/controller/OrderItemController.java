package com.faxi.cloudmall.order.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.order.entity.OrderItem;
import com.faxi.cloudmall.order.service.OrderItemService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 订单项信息
 *
 * @author faxi
 * @date 2021-07-06 20:31:28
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/order/orderitem" )
@Api(value = "orderitem", tags = "订单项信息管理")
public class OrderItemController {

    private final  OrderItemService orderItemService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param orderItem 订单项信息
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('order_orderitem_get')" )
    public R getOrderItemPage(Page page, OrderItem orderItem) {
        return R.ok(orderItemService.page(page, Wrappers.query(orderItem)));
    }


    /**
     * 通过id查询订单项信息
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('order_orderitem_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(orderItemService.getById(id));
    }

    /**
     * 新增订单项信息
     * @param orderItem 订单项信息
     * @return R
     */
    @ApiOperation(value = "新增订单项信息", notes = "新增订单项信息")
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('order_orderitem_add')" )
    public R save(@RequestBody OrderItem orderItem) {
        return R.ok(orderItemService.save(orderItem));
    }

    /**
     * 修改订单项信息
     * @param orderItem 订单项信息
     * @return R
     */
    @ApiOperation(value = "修改订单项信息", notes = "修改订单项信息")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('order_orderitem_edit')" )
    public R updateById(@RequestBody OrderItem orderItem) {
        return R.ok(orderItemService.updateById(orderItem));
    }

    /**
     * 通过id删除订单项信息
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除订单项信息", notes = "通过id删除订单项信息")
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('order_orderitem_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(orderItemService.removeById(id));
    }

}
