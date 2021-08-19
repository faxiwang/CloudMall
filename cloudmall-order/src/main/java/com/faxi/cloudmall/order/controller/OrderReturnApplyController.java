package com.faxi.cloudmall.order.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.order.entity.OrderReturnApply;
import com.faxi.cloudmall.order.service.OrderReturnApplyService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 订单退货申请
 *
 * @author faxi
 * @date 2021-07-06 20:31:28
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/order/orderreturnapply" )
@Api(value = "orderreturnapply", tags = "订单退货申请管理")
public class OrderReturnApplyController {

    private final  OrderReturnApplyService orderReturnApplyService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param orderReturnApply 订单退货申请
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('order_orderreturnapply_get')" )
    public R getOrderReturnApplyPage(Page page, OrderReturnApply orderReturnApply) {
        return R.ok(orderReturnApplyService.page(page, Wrappers.query(orderReturnApply)));
    }


    /**
     * 通过id查询订单退货申请
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('order_orderreturnapply_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(orderReturnApplyService.getById(id));
    }

    /**
     * 新增订单退货申请
     * @param orderReturnApply 订单退货申请
     * @return R
     */
    @ApiOperation(value = "新增订单退货申请", notes = "新增订单退货申请")
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('order_orderreturnapply_add')" )
    public R save(@RequestBody OrderReturnApply orderReturnApply) {
        return R.ok(orderReturnApplyService.save(orderReturnApply));
    }

    /**
     * 修改订单退货申请
     * @param orderReturnApply 订单退货申请
     * @return R
     */
    @ApiOperation(value = "修改订单退货申请", notes = "修改订单退货申请")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('order_orderreturnapply_edit')" )
    public R updateById(@RequestBody OrderReturnApply orderReturnApply) {
        return R.ok(orderReturnApplyService.updateById(orderReturnApply));
    }

    /**
     * 通过id删除订单退货申请
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除订单退货申请", notes = "通过id删除订单退货申请")
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('order_orderreturnapply_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(orderReturnApplyService.removeById(id));
    }

}
