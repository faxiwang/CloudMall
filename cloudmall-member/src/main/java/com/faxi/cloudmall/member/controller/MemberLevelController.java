package com.faxi.cloudmall.member.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.member.entity.MemberLevel;
import com.faxi.cloudmall.member.service.MemberLevelService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


/**
 * 会员等级
 *
 * @author faxi
 * @date 2021-07-06 20:33:46
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/member/memberlevel" )
@Api(value = "memberlevel", tags = "会员等级管理")
public class MemberLevelController {

    private final  MemberLevelService memberLevelService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param memberLevel 会员等级
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('member_memberlevel_get')" )
    public R getMemberLevelPage(Page page, MemberLevel memberLevel) {
        return R.ok(memberLevelService.page(page, Wrappers.query(memberLevel)));
    }


    /**
     * 通过id查询会员等级
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('member_memberlevel_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(memberLevelService.getById(id));
    }

    /**
     * 新增会员等级
     * @param memberLevel 会员等级
     * @return R
     */
    @ApiOperation(value = "新增会员等级", notes = "新增会员等级")
    @PostMapping("/save")
    //@PreAuthorize("@pms.hasPermission('member_memberlevel_add')" )
    public R save(@RequestBody MemberLevel memberLevel) {
        return R.ok(memberLevelService.save(memberLevel));
    }

    /**
     * 修改会员等级
     * @param memberLevel 会员等级
     * @return R
     */
    @ApiOperation(value = "修改会员等级", notes = "修改会员等级")
    @PostMapping("/update")
    //@PreAuthorize("@pms.hasPermission('member_memberlevel_edit')" )
    public R updateById(@RequestBody MemberLevel memberLevel) {
        return R.ok(memberLevelService.updateById(memberLevel));
    }

    /**
     * 通过id删除会员等级
     * @param ids ids
     * @return R
     */
    @ApiOperation(value = "通过id删除会员等级", notes = "通过id删除会员等级")
    @PostMapping("/delete")
    //@PreAuthorize("@pms.hasPermission('member_memberlevel_del')" )
    public R removeById(@RequestBody Long[] ids) {
        return R.ok(memberLevelService.removeByIds(Arrays.asList(ids)));
    }

}
