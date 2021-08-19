package com.faxi.cloudmall.coupon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.faxi.cloudmall.coupon.entity.HomeSubject;
import org.apache.ibatis.annotations.Mapper;

/**
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
 *
 * @author faxi
 * @date 2021-07-05 21:58:42
 */
@Mapper
public interface HomeSubjectMapper extends BaseMapper<HomeSubject> {

}
