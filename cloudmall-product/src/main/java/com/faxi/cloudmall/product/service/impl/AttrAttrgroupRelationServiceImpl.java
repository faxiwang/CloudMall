package com.faxi.cloudmall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.faxi.cloudmall.product.entity.AttrAttrgroupRelation;
import com.faxi.cloudmall.product.mapper.AttrAttrgroupRelationMapper;
import com.faxi.cloudmall.product.service.AttrAttrgroupRelationService;
import com.faxi.cloudmall.product.vo.AttrGroupRelationVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 属性&属性分组关联
 *
 * @author faxi
 * @date 2021-07-04 22:19:40
 */
@Service
public class AttrAttrgroupRelationServiceImpl extends ServiceImpl<AttrAttrgroupRelationMapper, AttrAttrgroupRelation> implements AttrAttrgroupRelationService {

    @Override
    public Page<AttrAttrgroupRelation> queyPage(Page page) {
        LambdaQueryWrapper<AttrAttrgroupRelation> wrapper = new LambdaQueryWrapper<>();

        page = baseMapper.selectPage(page, wrapper);
        return page;
    }

    @Override
    public void saveBatch(List<AttrGroupRelationVo> data) {

        List<AttrAttrgroupRelation> list = data.stream().map((item) -> {
            AttrAttrgroupRelation relationEntity = new AttrAttrgroupRelation();
            BeanUtils.copyProperties(item, relationEntity);
            return relationEntity;
        }).collect(Collectors.toList());

        this.saveBatch(list);

    }
}
