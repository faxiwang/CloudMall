package com.faxi.cloudmall.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.faxi.cloudmall.product.entity.ProductAttrValue;

import java.util.List;

/**
 * spu属性值
 *
 * @author faxi
 * @date 2021-07-04 22:19:39
 */
public interface ProductAttrValueService extends IService<ProductAttrValue> {

    IPage queryPage(Page page);

    void saveProductAttr(List<ProductAttrValue> list);

    List<ProductAttrValue> baseAttrListforspu(Long spuId);

    /**
     * 修改商品规格
     *
     * @param spuId
     * @param entities
     */
    void updateSpuAttr(Long spuId, List<ProductAttrValue> entities);
}
