package com.faxi.cloudmall.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.faxi.cloudmall.product.entity.SpuInfo;
import com.faxi.cloudmall.product.vo.SpuSaveVo;
import com.faxi.cloudmall.product.vo.SpuinfoVo;

/**
 * spu信息
 *
 * @author faxi
 * @date 2021-07-04 22:19:39
 */
public interface SpuInfoService extends IService<SpuInfo> {
    Page queryPage(Page page, SpuinfoVo info);

    void saveBaseSpuInfo(SpuInfo info);

    IPage queryPageByCondtion(Page page);

    /**
     * 商品上架
     *
     * @param spuId
     */
    void up(Long spuId);

    /**
     * 根据skuId查询spu的信息
     *
     * @param skuId
     * @return
     */
    SpuInfo getSpuInfoBySkuId(Long skuId);

    /**
     * 新增商品保存
     *
     * @param vo
     * @return
     */
    boolean saveInfo(SpuSaveVo vo);
}
