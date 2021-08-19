package com.faxi.cloudmall.product.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.faxi.cloudmall.product.entity.AttrGroup;
import com.faxi.cloudmall.product.vo.AttrGroupRelationVo;
import com.faxi.cloudmall.product.vo.AttrGroupWithAttrsVo;
import com.faxi.cloudmall.product.vo.SpuItemAttrGroupVo;

import java.util.List;

/**
 * 属性分组
 *
 * @author faxi
 * @date 2021-07-04 22:19:40
 */
public interface AttrGroupService extends IService<AttrGroup> {
    Page<AttrGroup> queryPage(Page<AttrGroup> page,Long catelogId,String key);

    void deleteRelation(AttrGroupRelationVo[] vos);

    List<AttrGroupWithAttrsVo> getWithAttrsByCatelogId(Long catelogId);

    List<SpuItemAttrGroupVo> getAttrGroupWithAttrsBySpuId(Long spuId, Long catalogId);

}
