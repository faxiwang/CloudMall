package com.faxi.cloudmall.product.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.faxi.cloudmall.product.entity.AttrAttrgroupRelation;
import com.faxi.cloudmall.product.vo.AttrGroupRelationVo;

import java.util.List;

/**
 * 属性&属性分组关联
 *
 * @author faxi
 * @date 2021-07-04 22:19:40
 */
public interface AttrAttrgroupRelationService extends IService<AttrAttrgroupRelation> {

    Page<AttrAttrgroupRelation> queyPage(Page page);

    void saveBatch(List<AttrGroupRelationVo> data);

}
