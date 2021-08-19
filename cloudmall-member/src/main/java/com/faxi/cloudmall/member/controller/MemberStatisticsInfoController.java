package com.faxi.cloudmall.member.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.member.entity.MemberStatisticsInfo;
import com.faxi.cloudmall.member.service.MemberStatisticsInfoService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 会员统计信息
 *
 * @author faxi
 * @date 2021-07-06 20:33:46
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/member/memberstatisticsinfo" )
@Api(value = "memberstatisticsinfo", tags = "会员统计信息管理")
public class MemberStatisticsInfoController {

    private final  MemberStatisticsInfoService memberStatisticsInfoService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param memberStatisticsInfo 会员统计信息
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('member_memberstatisticsinfo_get')" )
    public R getMemberStatisticsInfoPage(Page page, MemberStatisticsInfo memberStatisticsInfo) {
        return R.ok(memberStatisticsInfoService.page(page, Wrappers.query(memberStatisticsInfo)));
    }


    /**
     * 通过id查询会员统计信息
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('member_memberstatisticsinfo_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(memberStatisticsInfoService.getById(id));
    }

    /**
     * 新增会员统计信息
     * @param memberStatisticsInfo 会员统计信息
     * @return R
     */
    @ApiOperation(value = "新增会员统计信息", notes = "新增会员统计信息")
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('member_memberstatisticsinfo_add')" )
    public R save(@RequestBody MemberStatisticsInfo memberStatisticsInfo) {
        return R.ok(memberStatisticsInfoService.save(memberStatisticsInfo));
    }

    /**
     * 修改会员统计信息
     * @param memberStatisticsInfo 会员统计信息
     * @return R
     */
    @ApiOperation(value = "修改会员统计信息", notes = "修改会员统计信息")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('member_memberstatisticsinfo_edit')" )
    public R updateById(@RequestBody MemberStatisticsInfo memberStatisticsInfo) {
        return R.ok(memberStatisticsInfoService.updateById(memberStatisticsInfo));
    }

    /**
     * 通过id删除会员统计信息
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除会员统计信息", notes = "通过id删除会员统计信息")
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('member_memberstatisticsinfo_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(memberStatisticsInfoService.removeById(id));
    }

}
