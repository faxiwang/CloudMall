package com.faxi.cloudmall.ware.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.ware.entity.WareSku;
import com.faxi.cloudmall.ware.service.WareSkuService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 商品库存
 *
 * @author faxi
 * @date 2021-07-06 20:24:00
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/ware/waresku" )
@Api(value = "waresku", tags = "商品库存管理")
public class WareSkuController {

    private final  WareSkuService wareSkuService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param wareSku 商品库存
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('ware_waresku_get')" )
    public R getWareSkuPage(Page page, WareSku wareSku) {
        return R.ok(wareSkuService.page(page, Wrappers.query(wareSku)));
    }


    /**
     * 通过id查询商品库存
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('ware_waresku_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(wareSkuService.getById(id));
    }

    /**
     * 新增商品库存
     * @param wareSku 商品库存
     * @return R
     */
    @ApiOperation(value = "新增商品库存", notes = "新增商品库存")
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('ware_waresku_add')" )
    public R save(@RequestBody WareSku wareSku) {
        return R.ok(wareSkuService.save(wareSku));
    }

    /**
     * 修改商品库存
     * @param wareSku 商品库存
     * @return R
     */
    @ApiOperation(value = "修改商品库存", notes = "修改商品库存")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('ware_waresku_edit')" )
    public R updateById(@RequestBody WareSku wareSku) {
        return R.ok(wareSkuService.updateById(wareSku));
    }

    /**
     * 通过id删除商品库存
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除商品库存", notes = "通过id删除商品库存")
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('ware_waresku_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(wareSkuService.removeById(id));
    }

}
