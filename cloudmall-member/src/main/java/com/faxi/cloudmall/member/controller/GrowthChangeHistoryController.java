package com.faxi.cloudmall.member.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.member.entity.GrowthChangeHistory;
import com.faxi.cloudmall.member.service.GrowthChangeHistoryService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 成长值变化历史记录
 *
 * @author faxi
 * @date 2021-07-06 20:33:46
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/member/growthchangehistory" )
@Api(value = "growthchangehistory", tags = "成长值变化历史记录管理")
public class GrowthChangeHistoryController {

    private final  GrowthChangeHistoryService growthChangeHistoryService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param growthChangeHistory 成长值变化历史记录
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('member_growthchangehistory_get')" )
    public R getGrowthChangeHistoryPage(Page page, GrowthChangeHistory growthChangeHistory) {
        return R.ok(growthChangeHistoryService.page(page, Wrappers.query(growthChangeHistory)));
    }


    /**
     * 通过id查询成长值变化历史记录
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('member_growthchangehistory_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(growthChangeHistoryService.getById(id));
    }

    /**
     * 新增成长值变化历史记录
     * @param growthChangeHistory 成长值变化历史记录
     * @return R
     */
    @ApiOperation(value = "新增成长值变化历史记录", notes = "新增成长值变化历史记录")
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('member_growthchangehistory_add')" )
    public R save(@RequestBody GrowthChangeHistory growthChangeHistory) {
        return R.ok(growthChangeHistoryService.save(growthChangeHistory));
    }

    /**
     * 修改成长值变化历史记录
     * @param growthChangeHistory 成长值变化历史记录
     * @return R
     */
    @ApiOperation(value = "修改成长值变化历史记录", notes = "修改成长值变化历史记录")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('member_growthchangehistory_edit')" )
    public R updateById(@RequestBody GrowthChangeHistory growthChangeHistory) {
        return R.ok(growthChangeHistoryService.updateById(growthChangeHistory));
    }

    /**
     * 通过id删除成长值变化历史记录
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除成长值变化历史记录", notes = "通过id删除成长值变化历史记录")
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('member_growthchangehistory_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(growthChangeHistoryService.removeById(id));
    }

}
