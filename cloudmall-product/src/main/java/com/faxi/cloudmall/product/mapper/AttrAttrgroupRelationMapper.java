package com.faxi.cloudmall.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.faxi.cloudmall.product.entity.AttrAttrgroupRelation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 属性&属性分组关联
 *
 * @author faxi
 * @date 2021-07-04 22:19:40
 */
@Mapper
public interface AttrAttrgroupRelationMapper extends BaseMapper<AttrAttrgroupRelation> {
    int deleteBatchRelation(@Param("entities") List<AttrAttrgroupRelation> entities);
}
