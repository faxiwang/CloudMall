package com.faxi.cloudmall.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.faxi.cloudmall.product.entity.AttrAttrgroupRelation;
import com.faxi.cloudmall.product.entity.AttrGroup;
import com.faxi.cloudmall.product.vo.SpuItemAttrGroupVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 属性分组
 *
 * @author faxi
 * @date 2021-07-04 22:19:40
 */
@Mapper
public interface AttrGroupMapper extends BaseMapper<AttrGroup> {
    List<SpuItemAttrGroupVo> getAttrGroupWithAttrsBySpuId(@Param("spuId") Long spuId, @Param("catalogId") Long catalogId);
}
