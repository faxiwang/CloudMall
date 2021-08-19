package com.faxi.cloudmall.order.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.order.entity.RefundInfo;
import com.faxi.cloudmall.order.service.RefundInfoService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 退款信息
 *
 * @author faxi
 * @date 2021-07-06 20:31:28
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/order/refundinfo" )
@Api(value = "refundinfo", tags = "退款信息管理")
public class RefundInfoController {

    private final  RefundInfoService refundInfoService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param refundInfo 退款信息
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('order_refundinfo_get')" )
    public R getRefundInfoPage(Page page, RefundInfo refundInfo) {
        return R.ok(refundInfoService.page(page, Wrappers.query(refundInfo)));
    }


    /**
     * 通过id查询退款信息
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('order_refundinfo_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(refundInfoService.getById(id));
    }

    /**
     * 新增退款信息
     * @param refundInfo 退款信息
     * @return R
     */
    @ApiOperation(value = "新增退款信息", notes = "新增退款信息")
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('order_refundinfo_add')" )
    public R save(@RequestBody RefundInfo refundInfo) {
        return R.ok(refundInfoService.save(refundInfo));
    }

    /**
     * 修改退款信息
     * @param refundInfo 退款信息
     * @return R
     */
    @ApiOperation(value = "修改退款信息", notes = "修改退款信息")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('order_refundinfo_edit')" )
    public R updateById(@RequestBody RefundInfo refundInfo) {
        return R.ok(refundInfoService.updateById(refundInfo));
    }

    /**
     * 通过id删除退款信息
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除退款信息", notes = "通过id删除退款信息")
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('order_refundinfo_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(refundInfoService.removeById(id));
    }

}
