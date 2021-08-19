package com.faxi.cloudmall.member.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.member.entity.IntegrationChangeHistory;
import com.faxi.cloudmall.member.service.IntegrationChangeHistoryService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 积分变化历史记录
 *
 * @author faxi
 * @date 2021-07-06 20:33:46
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/member/integrationchangehistory" )
@Api(value = "integrationchangehistory", tags = "积分变化历史记录管理")
public class IntegrationChangeHistoryController {

    private final  IntegrationChangeHistoryService integrationChangeHistoryService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param integrationChangeHistory 积分变化历史记录
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('member_integrationchangehistory_get')" )
    public R getIntegrationChangeHistoryPage(Page page, IntegrationChangeHistory integrationChangeHistory) {
        return R.ok(integrationChangeHistoryService.page(page, Wrappers.query(integrationChangeHistory)));
    }


    /**
     * 通过id查询积分变化历史记录
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('member_integrationchangehistory_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(integrationChangeHistoryService.getById(id));
    }

    /**
     * 新增积分变化历史记录
     * @param integrationChangeHistory 积分变化历史记录
     * @return R
     */
    @ApiOperation(value = "新增积分变化历史记录", notes = "新增积分变化历史记录")
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('member_integrationchangehistory_add')" )
    public R save(@RequestBody IntegrationChangeHistory integrationChangeHistory) {
        return R.ok(integrationChangeHistoryService.save(integrationChangeHistory));
    }

    /**
     * 修改积分变化历史记录
     * @param integrationChangeHistory 积分变化历史记录
     * @return R
     */
    @ApiOperation(value = "修改积分变化历史记录", notes = "修改积分变化历史记录")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('member_integrationchangehistory_edit')" )
    public R updateById(@RequestBody IntegrationChangeHistory integrationChangeHistory) {
        return R.ok(integrationChangeHistoryService.updateById(integrationChangeHistory));
    }

    /**
     * 通过id删除积分变化历史记录
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除积分变化历史记录", notes = "通过id删除积分变化历史记录")
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('member_integrationchangehistory_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(integrationChangeHistoryService.removeById(id));
    }

}
