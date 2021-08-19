package com.faxi.cloudmall.order.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.order.entity.OrderReturnReason;
import com.faxi.cloudmall.order.service.OrderReturnReasonService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 退货原因
 *
 * @author faxi
 * @date 2021-07-06 20:31:28
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/order/orderreturnreason" )
@Api(value = "orderreturnreason", tags = "退货原因管理")
public class OrderReturnReasonController {

    private final  OrderReturnReasonService orderReturnReasonService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param orderReturnReason 退货原因
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('order_orderreturnreason_get')" )
    public R getOrderReturnReasonPage(Page page, OrderReturnReason orderReturnReason) {
        return R.ok(orderReturnReasonService.page(page, Wrappers.query(orderReturnReason)));
    }


    /**
     * 通过id查询退货原因
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('order_orderreturnreason_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(orderReturnReasonService.getById(id));
    }

    /**
     * 新增退货原因
     * @param orderReturnReason 退货原因
     * @return R
     */
    @ApiOperation(value = "新增退货原因", notes = "新增退货原因")
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('order_orderreturnreason_add')" )
    public R save(@RequestBody OrderReturnReason orderReturnReason) {
        return R.ok(orderReturnReasonService.save(orderReturnReason));
    }

    /**
     * 修改退货原因
     * @param orderReturnReason 退货原因
     * @return R
     */
    @ApiOperation(value = "修改退货原因", notes = "修改退货原因")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('order_orderreturnreason_edit')" )
    public R updateById(@RequestBody OrderReturnReason orderReturnReason) {
        return R.ok(orderReturnReasonService.updateById(orderReturnReason));
    }

    /**
     * 通过id删除退货原因
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除退货原因", notes = "通过id删除退货原因")
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('order_orderreturnreason_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(orderReturnReasonService.removeById(id));
    }

}
