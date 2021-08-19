package com.faxi.cloudmall.product.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.product.entity.CommentReplay;
import com.faxi.cloudmall.product.service.CommentReplayService;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 商品评价回复关系
 *
 * @author faxi
 * @date 2021-07-06 20:29:20
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/product/commentreplay" )
@Api(value = "commentreplay", tags = "商品评价回复关系管理")
public class CommentReplayController {

    private final  CommentReplayService commentReplayService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param commentReplay 商品评价回复关系
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('product_commentreplay_get')" )
    public R getCommentReplayPage(Page page, CommentReplay commentReplay) {
        return R.ok(commentReplayService.page(page, Wrappers.query(commentReplay)));
    }


    /**
     * 通过id查询商品评价回复关系
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('product_commentreplay_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(commentReplayService.getById(id));
    }

    /**
     * 新增商品评价回复关系
     * @param commentReplay 商品评价回复关系
     * @return R
     */
    @ApiOperation(value = "新增商品评价回复关系", notes = "新增商品评价回复关系")
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('product_commentreplay_add')" )
    public R save(@RequestBody CommentReplay commentReplay) {
        return R.ok(commentReplayService.save(commentReplay));
    }

    /**
     * 修改商品评价回复关系
     * @param commentReplay 商品评价回复关系
     * @return R
     */
    @ApiOperation(value = "修改商品评价回复关系", notes = "修改商品评价回复关系")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('product_commentreplay_edit')" )
    public R updateById(@RequestBody CommentReplay commentReplay) {
        return R.ok(commentReplayService.updateById(commentReplay));
    }

    /**
     * 通过id删除商品评价回复关系
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除商品评价回复关系", notes = "通过id删除商品评价回复关系")
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('product_commentreplay_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(commentReplayService.removeById(id));
    }

}
