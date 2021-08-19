package com.faxi.cloudmall.coupon.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.coupon.entity.HomeSubject;
import com.faxi.cloudmall.coupon.service.HomeSubjectService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
 *
 * @author faxi
 * @date 2021-07-06 20:36:05
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/coupon/homesubject" )
@Api(value = "homesubject", tags = "首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】管理")
public class HomeSubjectController {

    private final  HomeSubjectService homeSubjectService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param homeSubject 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('coupon_homesubject_get')" )
    public R getHomeSubjectPage(Page page, HomeSubject homeSubject) {
        return R.ok(homeSubjectService.page(page, Wrappers.query(homeSubject)));
    }


    /**
     * 通过id查询首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('coupon_homesubject_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(homeSubjectService.getById(id));
    }

    /**
     * 新增首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
     * @param homeSubject 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
     * @return R
     */
    @ApiOperation(value = "新增首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】", notes = "新增首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】")
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('coupon_homesubject_add')" )
    public R save(@RequestBody HomeSubject homeSubject) {
        return R.ok(homeSubjectService.save(homeSubject));
    }

    /**
     * 修改首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
     * @param homeSubject 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
     * @return R
     */
    @ApiOperation(value = "修改首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】", notes = "修改首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('coupon_homesubject_edit')" )
    public R updateById(@RequestBody HomeSubject homeSubject) {
        return R.ok(homeSubjectService.updateById(homeSubject));
    }

    /**
     * 通过id删除首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】", notes = "通过id删除首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】")
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('coupon_homesubject_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(homeSubjectService.removeById(id));
    }

}
