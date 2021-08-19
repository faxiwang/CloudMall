package com.faxi.cloudmall.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.faxi.cloudmall.product.entity.SkuSaleAttrValue;
import com.faxi.cloudmall.product.vo.SkuItemSaleAttrVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * sku销售属性&值
 *
 * @author faxi
 * @date 2021-07-04 22:19:39
 */
@Mapper
public interface SkuSaleAttrValueMapper extends BaseMapper<SkuSaleAttrValue> {
    List<SkuItemSaleAttrVo> getSaleAttrBySpuId(@Param("spuId") Long spuId);

    List<String> getSkuSaleAttrValuesAsStringList(@Param("skuId") Long skuId);
}
