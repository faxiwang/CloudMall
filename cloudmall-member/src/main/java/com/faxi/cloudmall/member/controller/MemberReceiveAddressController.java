package com.faxi.cloudmall.member.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.member.entity.MemberReceiveAddress;
import com.faxi.cloudmall.member.service.MemberReceiveAddressService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 会员收货地址
 *
 * @author faxi
 * @date 2021-07-06 20:33:46
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/member/memberreceiveaddress" )
@Api(value = "memberreceiveaddress", tags = "会员收货地址管理")
public class MemberReceiveAddressController {

    private final  MemberReceiveAddressService memberReceiveAddressService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param memberReceiveAddress 会员收货地址
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('member_memberreceiveaddress_get')" )
    public R getMemberReceiveAddressPage(Page page, MemberReceiveAddress memberReceiveAddress) {
        return R.ok(memberReceiveAddressService.page(page, Wrappers.query(memberReceiveAddress)));
    }


    /**
     * 通过id查询会员收货地址
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('member_memberreceiveaddress_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(memberReceiveAddressService.getById(id));
    }

    /**
     * 新增会员收货地址
     * @param memberReceiveAddress 会员收货地址
     * @return R
     */
    @ApiOperation(value = "新增会员收货地址", notes = "新增会员收货地址")
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('member_memberreceiveaddress_add')" )
    public R save(@RequestBody MemberReceiveAddress memberReceiveAddress) {
        return R.ok(memberReceiveAddressService.save(memberReceiveAddress));
    }

    /**
     * 修改会员收货地址
     * @param memberReceiveAddress 会员收货地址
     * @return R
     */
    @ApiOperation(value = "修改会员收货地址", notes = "修改会员收货地址")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('member_memberreceiveaddress_edit')" )
    public R updateById(@RequestBody MemberReceiveAddress memberReceiveAddress) {
        return R.ok(memberReceiveAddressService.updateById(memberReceiveAddress));
    }

    /**
     * 通过id删除会员收货地址
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除会员收货地址", notes = "通过id删除会员收货地址")
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('member_memberreceiveaddress_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(memberReceiveAddressService.removeById(id));
    }

}
