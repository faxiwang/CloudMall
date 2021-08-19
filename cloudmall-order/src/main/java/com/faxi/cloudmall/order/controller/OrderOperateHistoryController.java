package com.faxi.cloudmall.order.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.order.entity.OrderOperateHistory;
import com.faxi.cloudmall.order.service.OrderOperateHistoryService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 订单操作历史记录
 *
 * @author faxi
 * @date 2021-07-06 20:31:28
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/order/orderoperatehistory" )
@Api(value = "orderoperatehistory", tags = "订单操作历史记录管理")
public class OrderOperateHistoryController {

    private final  OrderOperateHistoryService orderOperateHistoryService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param orderOperateHistory 订单操作历史记录
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('order_orderoperatehistory_get')" )
    public R getOrderOperateHistoryPage(Page page, OrderOperateHistory orderOperateHistory) {
        return R.ok(orderOperateHistoryService.page(page, Wrappers.query(orderOperateHistory)));
    }


    /**
     * 通过id查询订单操作历史记录
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('order_orderoperatehistory_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(orderOperateHistoryService.getById(id));
    }

    /**
     * 新增订单操作历史记录
     * @param orderOperateHistory 订单操作历史记录
     * @return R
     */
    @ApiOperation(value = "新增订单操作历史记录", notes = "新增订单操作历史记录")
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('order_orderoperatehistory_add')" )
    public R save(@RequestBody OrderOperateHistory orderOperateHistory) {
        return R.ok(orderOperateHistoryService.save(orderOperateHistory));
    }

    /**
     * 修改订单操作历史记录
     * @param orderOperateHistory 订单操作历史记录
     * @return R
     */
    @ApiOperation(value = "修改订单操作历史记录", notes = "修改订单操作历史记录")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('order_orderoperatehistory_edit')" )
    public R updateById(@RequestBody OrderOperateHistory orderOperateHistory) {
        return R.ok(orderOperateHistoryService.updateById(orderOperateHistory));
    }

    /**
     * 通过id删除订单操作历史记录
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除订单操作历史记录", notes = "通过id删除订单操作历史记录")
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('order_orderoperatehistory_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(orderOperateHistoryService.removeById(id));
    }

}
