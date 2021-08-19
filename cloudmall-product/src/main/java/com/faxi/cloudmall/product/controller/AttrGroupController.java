package com.faxi.cloudmall.product.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.product.entity.Attr;
import com.faxi.cloudmall.product.entity.AttrGroup;
import com.faxi.cloudmall.product.service.AttrAttrgroupRelationService;
import com.faxi.cloudmall.product.service.AttrGroupService;
import com.faxi.cloudmall.product.service.AttrService;
import com.faxi.cloudmall.product.service.CategoryService;
import com.faxi.cloudmall.product.vo.AttrGroupRelationVo;
import com.faxi.cloudmall.product.vo.AttrGroupWithAttrsVo;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 属性分组
 *
 * @author faxi
 * @date 2021-07-06 20:29:20
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/product/attrgroup")
@Api(value = "attrgroup", tags = "属性分组管理")
public class AttrGroupController {

    private final AttrGroupService attrGroupService;

    private final AttrAttrgroupRelationService relationService;

    private final AttrService attrService;

    private final CategoryService categoryService;


    /**
     * 分页查询
     *
     * @param page      分页对象
     * @param
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page/{catelogId}")
    //@PreAuthorize("@pms.hasPermission('product_attrgroup_get')" )
    public R getAttrGroupPage(Page page, String key, @PathVariable("catelogId") Long catelogId) {
        page = attrGroupService.queryPage(page, catelogId, key);
        return R.ok(page);
    }


    /**
     * 通过id查询属性分组
     *
     * @param attrGroupId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{attrGroupId}")
    //@PreAuthorize("@pms.hasPermission('product_attrgroup_get')" )
    public R<AttrGroup> getById(@PathVariable("attrGroupId") Long attrGroupId) {
        AttrGroup attr = attrGroupService.getById(attrGroupId);

        Long[] path = categoryService.findCatelogPath(attr.getCatelogId());

        attr.setCatelogPath(path);

        return R.ok(attr);
    }

    /**
     * 新增属性分组
     *
     * @param attrGroup 属性分组
     * @return R
     */
    @ApiOperation(value = "新增属性分组", notes = "新增属性分组")
    @PostMapping("/save")
    //@PreAuthorize("@pms.hasPermission('product_attrgroup_add')" )
    public R<Boolean> save(@RequestBody AttrGroup attrGroup) {
        return R.ok(attrGroupService.save(attrGroup));
    }

    /**
     * 修改属性分组
     *
     * @param attrGroup 属性分组
     * @return R
     */
    @ApiOperation(value = "修改属性分组", notes = "修改属性分组")
    @PostMapping("/update")
    //@PreAuthorize("@pms.hasPermission('product_attrgroup_edit')" )
    public R<Boolean> updateById(@RequestBody AttrGroup attrGroup) {
        return R.ok(attrGroupService.updateById(attrGroup));
    }

    /**
     * 通过id删除属性分组
     *
     * @param  attrGroupIds
     * @return R
     */
    @ApiOperation(value = "通过id删除属性分组", notes = "通过id删除属性分组")
    @PostMapping("/delete")
    //@PreAuthorize("@pms.hasPermission('product_attrgroup_del')" )
    public R<Boolean> removeById(@RequestBody Long[] attrGroupIds) {
        return R.ok(attrGroupService.removeByIds(Arrays.asList(attrGroupIds)));
    }

    /**
     * 获取属性分组有关联的其他属性
     * @param attrgroupId
     * @return
     */
    @GetMapping(value = "/attr/relation/{attrgroupId}")
    public R<List<Attr>> attrRelation(@PathVariable("attrgroupId") Long attrgroupId) {

        List<Attr> list = attrService.getRelationAttr(attrgroupId);

        return R.ok(list);
    }

    /**
     * 获取属性分组没有关联的其他属性
     */
    @GetMapping(value = "/noattr/relation/{attrgroupId}")
    public R<Page> attrNoattrRelation(Page page, String key, @PathVariable("attrgroupId") Long attrgroupId) {

        page = attrService.getNoRelationAttr(page,key,attrgroupId);

        return R.ok(page);
    }


    @PostMapping("/attr/relation")
    public R addRelation(@RequestBody List<AttrGroupRelationVo> data){
        relationService.saveBatch(data);

        return R.ok();
    }



    /**
     * 删除属性
     * @param vos
     * @return
     */
    @PostMapping("/attr/relation/delete")
    public R<Boolean> deleteRelation(@RequestBody AttrGroupRelationVo[] vos){
        attrGroupService.deleteRelation(vos);
        return R.ok();
    }


    /**
     * 获取属性分组有关联的其他属性
     * @param catelogId
     * @return
     */
    @GetMapping(value = "/withattr/{catelogId}")
    public R<List<AttrGroupWithAttrsVo>> getAttrGroupWithAttrs(@PathVariable("catelogId") Long catelogId) {

        List<AttrGroupWithAttrsVo> list = attrGroupService.getWithAttrsByCatelogId(catelogId);

        return R.ok(list);
    }



}
