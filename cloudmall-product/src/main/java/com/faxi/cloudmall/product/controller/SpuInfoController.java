package com.faxi.cloudmall.product.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faxi.cloudmall.product.entity.SpuInfo;
import com.faxi.cloudmall.product.service.SpuInfoService;
import com.faxi.cloudmall.product.vo.SpuSaveVo;
import com.faxi.cloudmall.product.vo.SpuinfoVo;
import com.faxi.common.utis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * spu信息
 *
 * @author faxi
 * @date 2021-07-06 20:29:19
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/product/spuinfo" )
@Api(value = "spuinfo", tags = "spu信息管理")
public class SpuInfoController {

    private final  SpuInfoService spuInfoService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param spuInfo spu信息
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('product_spuinfo_get')" )
    public R getSpuInfoPage(Page page, SpuinfoVo spuInfo) {
        page = spuInfoService.queryPage(page,spuInfo);
        return R.ok(page);
    }


    /**
     * 通过id查询spu信息
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('product_spuinfo_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(spuInfoService.getById(id));
    }

    /**
     * 新增spu信息
     * @param saveVo spu信息
     * @return R
     */
    @ApiOperation(value = "新增spu信息", notes = "新增spu信息")
    @PostMapping("/save")
    //@PreAuthorize("@pms.hasPermission('product_spuinfo_add')" )
    public R save(@RequestBody SpuSaveVo saveVo) {
        return R.ok(spuInfoService.saveInfo(saveVo));
    }

    /**
     * 修改spu信息
     * @param spuInfo spu信息
     * @return R
     */
    @ApiOperation(value = "修改spu信息", notes = "修改spu信息")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('product_spuinfo_edit')" )
    public R updateById(@RequestBody SpuInfo spuInfo) {
        return R.ok(spuInfoService.updateById(spuInfo));
    }

    /**
     * 通过id删除spu信息
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除spu信息", notes = "通过id删除spu信息")
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('product_spuinfo_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(spuInfoService.removeById(id));
    }

}
