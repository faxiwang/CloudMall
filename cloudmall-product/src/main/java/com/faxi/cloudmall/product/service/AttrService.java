package com.faxi.cloudmall.product.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.faxi.cloudmall.product.entity.Attr;
import com.faxi.cloudmall.product.vo.AttrRespVo;
import com.faxi.cloudmall.product.vo.AttrVo;

import java.util.List;

/**
 * 商品属性
 *
 * @author faxi
 * @date 2021-07-04 22:19:40
 */
public interface AttrService extends IService<Attr> {

    Page queryBaseAttrPage(Page page,String key,Long catelogId, String attrType);

    void saveAttr(AttrVo attr);

    void updateAttrById(AttrVo attr);

    AttrRespVo getAttrInfo(Long attrId);

    List<Attr> getRelationAttr(Long attrgroupId);

    Page<Attr> getNoRelationAttr(Page page,String key,Long attrgroupId);
}
