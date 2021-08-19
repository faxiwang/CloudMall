package com.faxi.cloudmall.ware.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.ware.entity.WareInfo;
import com.faxi.cloudmall.ware.service.WareInfoService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 仓库信息
 *
 * @author faxi
 * @date 2021-07-06 20:24:00
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/ware/wareinfo" )
@Api(value = "wareinfo", tags = "仓库信息管理")
public class WareInfoController {

    private final  WareInfoService wareInfoService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param wareInfo 仓库信息
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('ware_wareinfo_get')" )
    public R getWareInfoPage(Page page, WareInfo wareInfo) {
        return R.ok(wareInfoService.page(page, Wrappers.query(wareInfo)));
    }


    /**
     * 通过id查询仓库信息
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('ware_wareinfo_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(wareInfoService.getById(id));
    }

    /**
     * 新增仓库信息
     * @param wareInfo 仓库信息
     * @return R
     */
    @ApiOperation(value = "新增仓库信息", notes = "新增仓库信息")
    @PostMapping("/save")
    //@PreAuthorize("@pms.hasPermission('ware_wareinfo_add')" )
    public R save(@RequestBody WareInfo wareInfo) {
        return R.ok(wareInfoService.save(wareInfo));
    }

    /**
     * 修改仓库信息
     * @param wareInfo 仓库信息
     * @return R
     */
    @ApiOperation(value = "修改仓库信息", notes = "修改仓库信息")
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('ware_wareinfo_edit')" )
    public R updateById(@RequestBody WareInfo wareInfo) {
        return R.ok(wareInfoService.updateById(wareInfo));
    }

    /**
     * 通过id删除仓库信息
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除仓库信息", notes = "通过id删除仓库信息")
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('ware_wareinfo_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(wareInfoService.removeById(id));
    }

}
