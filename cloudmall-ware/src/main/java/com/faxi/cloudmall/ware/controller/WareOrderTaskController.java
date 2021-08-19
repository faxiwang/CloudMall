package com.faxi.cloudmall.ware.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.ware.entity.WareOrderTask;
import com.faxi.cloudmall.ware.service.WareOrderTaskService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 库存工作单
 *
 * @author faxi
 * @date 2021-07-06 20:24:00
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/ware/wareordertask" )
@Api(value = "wareordertask", tags = "库存工作单管理")
public class WareOrderTaskController {

    private final  WareOrderTaskService wareOrderTaskService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param wareOrderTask 库存工作单
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('ware_wareordertask_get')" )
    public R getWareOrderTaskPage(Page page, WareOrderTask wareOrderTask) {
        return R.ok(wareOrderTaskService.page(page, Wrappers.query(wareOrderTask)));
    }


    /**
     * 通过id查询库存工作单
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('ware_wareordertask_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(wareOrderTaskService.getById(id));
    }

    /**
     * 新增库存工作单
     * @param wareOrderTask 库存工作单
     * @return R
     */
    @ApiOperation(value = "新增库存工作单", notes = "新增库存工作单")
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('ware_wareordertask_add')" )
    public R save(@RequestBody WareOrderTask wareOrderTask) {
        return R.ok(wareOrderTaskService.save(wareOrderTask));
    }

    /**
     * 修改库存工作单
     * @param wareOrderTask 库存工作单
     * @return R
     */
    @ApiOperation(value = "修改库存工作单", notes = "修改库存工作单")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('ware_wareordertask_edit')" )
    public R updateById(@RequestBody WareOrderTask wareOrderTask) {
        return R.ok(wareOrderTaskService.updateById(wareOrderTask));
    }

    /**
     * 通过id删除库存工作单
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除库存工作单", notes = "通过id删除库存工作单")
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('ware_wareordertask_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(wareOrderTaskService.removeById(id));
    }

}
