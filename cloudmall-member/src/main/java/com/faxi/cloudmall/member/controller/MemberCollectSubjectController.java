package com.faxi.cloudmall.member.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.member.entity.MemberCollectSubject;
import com.faxi.cloudmall.member.service.MemberCollectSubjectService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 会员收藏的专题活动
 *
 * @author faxi
 * @date 2021-07-06 20:33:46
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/member/membercollectsubject" )
@Api(value = "membercollectsubject", tags = "会员收藏的专题活动管理")
public class MemberCollectSubjectController {

    private final  MemberCollectSubjectService memberCollectSubjectService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param memberCollectSubject 会员收藏的专题活动
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('member_membercollectsubject_get')" )
    public R getMemberCollectSubjectPage(Page page, MemberCollectSubject memberCollectSubject) {
        return R.ok(memberCollectSubjectService.page(page, Wrappers.query(memberCollectSubject)));
    }


    /**
     * 通过id查询会员收藏的专题活动
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('member_membercollectsubject_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(memberCollectSubjectService.getById(id));
    }

    /**
     * 新增会员收藏的专题活动
     * @param memberCollectSubject 会员收藏的专题活动
     * @return R
     */
    @ApiOperation(value = "新增会员收藏的专题活动", notes = "新增会员收藏的专题活动")
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('member_membercollectsubject_add')" )
    public R save(@RequestBody MemberCollectSubject memberCollectSubject) {
        return R.ok(memberCollectSubjectService.save(memberCollectSubject));
    }

    /**
     * 修改会员收藏的专题活动
     * @param memberCollectSubject 会员收藏的专题活动
     * @return R
     */
    @ApiOperation(value = "修改会员收藏的专题活动", notes = "修改会员收藏的专题活动")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('member_membercollectsubject_edit')" )
    public R updateById(@RequestBody MemberCollectSubject memberCollectSubject) {
        return R.ok(memberCollectSubjectService.updateById(memberCollectSubject));
    }

    /**
     * 通过id删除会员收藏的专题活动
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除会员收藏的专题活动", notes = "通过id删除会员收藏的专题活动")
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('member_membercollectsubject_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(memberCollectSubjectService.removeById(id));
    }

}
