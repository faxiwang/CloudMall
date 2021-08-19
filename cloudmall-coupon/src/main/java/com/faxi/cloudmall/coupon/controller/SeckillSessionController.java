package com.faxi.cloudmall.coupon.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.coupon.entity.SeckillSession;
import com.faxi.cloudmall.coupon.service.SeckillSessionService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 秒杀活动场次
 *
 * @author faxi
 * @date 2021-07-06 20:36:05
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/coupon/seckillsession" )
@Api(value = "seckillsession", tags = "秒杀活动场次管理")
public class SeckillSessionController {

    private final  SeckillSessionService seckillSessionService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param seckillSession 秒杀活动场次
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('coupon_seckillsession_get')" )
    public R getSeckillSessionPage(Page page, SeckillSession seckillSession) {
        return R.ok(seckillSessionService.page(page, Wrappers.query(seckillSession)));
    }


    /**
     * 通过id查询秒杀活动场次
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('coupon_seckillsession_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(seckillSessionService.getById(id));
    }

    /**
     * 新增秒杀活动场次
     * @param seckillSession 秒杀活动场次
     * @return R
     */
    @ApiOperation(value = "新增秒杀活动场次", notes = "新增秒杀活动场次")
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('coupon_seckillsession_add')" )
    public R save(@RequestBody SeckillSession seckillSession) {
        return R.ok(seckillSessionService.save(seckillSession));
    }

    /**
     * 修改秒杀活动场次
     * @param seckillSession 秒杀活动场次
     * @return R
     */
    @ApiOperation(value = "修改秒杀活动场次", notes = "修改秒杀活动场次")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('coupon_seckillsession_edit')" )
    public R updateById(@RequestBody SeckillSession seckillSession) {
        return R.ok(seckillSessionService.updateById(seckillSession));
    }

    /**
     * 通过id删除秒杀活动场次
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除秒杀活动场次", notes = "通过id删除秒杀活动场次")
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('coupon_seckillsession_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(seckillSessionService.removeById(id));
    }

}
