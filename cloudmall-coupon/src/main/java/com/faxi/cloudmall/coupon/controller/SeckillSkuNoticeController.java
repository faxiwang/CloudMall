package com.faxi.cloudmall.coupon.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.coupon.entity.SeckillSkuNotice;
import com.faxi.cloudmall.coupon.service.SeckillSkuNoticeService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 秒杀商品通知订阅
 *
 * @author faxi
 * @date 2021-07-06 20:36:05
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/coupon/seckillskunotice" )
@Api(value = "seckillskunotice", tags = "秒杀商品通知订阅管理")
public class SeckillSkuNoticeController {

    private final  SeckillSkuNoticeService seckillSkuNoticeService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param seckillSkuNotice 秒杀商品通知订阅
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('coupon_seckillskunotice_get')" )
    public R getSeckillSkuNoticePage(Page page, SeckillSkuNotice seckillSkuNotice) {
        return R.ok(seckillSkuNoticeService.page(page, Wrappers.query(seckillSkuNotice)));
    }


    /**
     * 通过id查询秒杀商品通知订阅
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('coupon_seckillskunotice_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(seckillSkuNoticeService.getById(id));
    }

    /**
     * 新增秒杀商品通知订阅
     * @param seckillSkuNotice 秒杀商品通知订阅
     * @return R
     */
    @ApiOperation(value = "新增秒杀商品通知订阅", notes = "新增秒杀商品通知订阅")
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('coupon_seckillskunotice_add')" )
    public R save(@RequestBody SeckillSkuNotice seckillSkuNotice) {
        return R.ok(seckillSkuNoticeService.save(seckillSkuNotice));
    }

    /**
     * 修改秒杀商品通知订阅
     * @param seckillSkuNotice 秒杀商品通知订阅
     * @return R
     */
    @ApiOperation(value = "修改秒杀商品通知订阅", notes = "修改秒杀商品通知订阅")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('coupon_seckillskunotice_edit')" )
    public R updateById(@RequestBody SeckillSkuNotice seckillSkuNotice) {
        return R.ok(seckillSkuNoticeService.updateById(seckillSkuNotice));
    }

    /**
     * 通过id删除秒杀商品通知订阅
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除秒杀商品通知订阅", notes = "通过id删除秒杀商品通知订阅")
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('coupon_seckillskunotice_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(seckillSkuNoticeService.removeById(id));
    }

}
