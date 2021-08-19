package com.faxi.cloudmall.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.faxi.cloudmall.product.entity.Category;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 *
 * @author faxi
 * @date 2021-07-04 22:19:39
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}
