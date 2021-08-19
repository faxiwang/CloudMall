package com.faxi.cloudmall.member.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.member.feign.AdminFeignServce;
import com.faxi.cloudmall.member.feign.CouponFeignServce;
import com.faxi.cloudmall.member.entity.Member;
import com.faxi.cloudmall.member.service.MemberService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * 会员
 *
 * @author faxi
 * @date 2021-07-06 20:33:46
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/member/member")
@Api(value = "member", tags = "会员管理")
public class MemberController {

    private final MemberService memberService;

    private final CouponFeignServce couponFeignServce;

    private final AdminFeignServce adminFeignServce;


    /**
     * 分页查询
     *
     * @param page   分页对象
     * @param member 会员
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page")
    //@PreAuthorize("@pms.hasPermission('member_member_get')" )
    public R getMemberPage(Page page, Member member) {
        return R.ok(memberService.page(page, Wrappers.query(member)));
    }


    /**
     * 通过id查询会员
     *
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}")
    //@PreAuthorize("@pms.hasPermission('member_member_get')" )
    public R getById(@PathVariable("id") Long id) {
        return R.ok(memberService.getById(id));
    }

    /**
     * 新增会员
     *
     * @param member 会员
     * @return R
     */
    @ApiOperation(value = "新增会员", notes = "新增会员")
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('member_member_add')" )
    public R save(@RequestBody Member member) {
        return R.ok(memberService.save(member));
    }

    /**
     * 修改会员
     *
     * @param member 会员
     * @return R
     */
    @ApiOperation(value = "修改会员", notes = "修改会员")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('member_member_edit')" )
    public R updateById(@RequestBody Member member) {
        return R.ok(memberService.updateById(member));
    }

    /**
     * 通过id删除会员
     *
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除会员", notes = "通过id删除会员")
    @DeleteMapping("/{id}")
    //@PreAuthorize("@pms.hasPermission('member_member_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(memberService.removeById(id));
    }

}
