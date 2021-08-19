package com.faxi.cloudmall.member.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.member.entity.MemberCollectSpu;
import com.faxi.cloudmall.member.service.MemberCollectSpuService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 会员收藏的商品
 *
 * @author faxi
 * @date 2021-07-06 20:33:47
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/member/membercollectspu" )
@Api(value = "membercollectspu", tags = "会员收藏的商品管理")
public class MemberCollectSpuController {

    private final  MemberCollectSpuService memberCollectSpuService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param memberCollectSpu 会员收藏的商品
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('member_membercollectspu_get')" )
    public R getMemberCollectSpuPage(Page page, MemberCollectSpu memberCollectSpu) {
        return R.ok(memberCollectSpuService.page(page, Wrappers.query(memberCollectSpu)));
    }


    /**
     * 通过id查询会员收藏的商品
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('member_membercollectspu_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(memberCollectSpuService.getById(id));
    }

    /**
     * 新增会员收藏的商品
     * @param memberCollectSpu 会员收藏的商品
     * @return R
     */
    @ApiOperation(value = "新增会员收藏的商品", notes = "新增会员收藏的商品")
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('member_membercollectspu_add')" )
    public R save(@RequestBody MemberCollectSpu memberCollectSpu) {
        return R.ok(memberCollectSpuService.save(memberCollectSpu));
    }

    /**
     * 修改会员收藏的商品
     * @param memberCollectSpu 会员收藏的商品
     * @return R
     */
    @ApiOperation(value = "修改会员收藏的商品", notes = "修改会员收藏的商品")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('member_membercollectspu_edit')" )
    public R updateById(@RequestBody MemberCollectSpu memberCollectSpu) {
        return R.ok(memberCollectSpuService.updateById(memberCollectSpu));
    }

    /**
     * 通过id删除会员收藏的商品
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除会员收藏的商品", notes = "通过id删除会员收藏的商品")
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('member_membercollectspu_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(memberCollectSpuService.removeById(id));
    }

}
