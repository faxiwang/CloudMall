package com.faxi.cloudmall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.faxi.cloudmall.product.entity.Attr;
import com.faxi.cloudmall.product.entity.AttrAttrgroupRelation;
import com.faxi.cloudmall.product.entity.AttrGroup;
import com.faxi.cloudmall.product.mapper.AttrAttrgroupRelationMapper;
import com.faxi.cloudmall.product.mapper.AttrGroupMapper;
import com.faxi.cloudmall.product.service.AttrGroupService;
import com.faxi.cloudmall.product.service.AttrService;
import com.faxi.cloudmall.product.vo.AttrGroupRelationVo;
import com.faxi.cloudmall.product.vo.AttrGroupWithAttrsVo;
import com.faxi.cloudmall.product.vo.SpuItemAttrGroupVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 属性分组
 *
 * @author faxi
 * @date 2021-07-04 22:19:40
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupMapper, AttrGroup> implements AttrGroupService {

    private final AttrAttrgroupRelationMapper relationMapper;

    private final AttrService attrService;

    @Override
    public Page<AttrGroup> queryPage(Page<AttrGroup> page, Long catelogId, String key) {
        LambdaQueryWrapper<AttrGroup> wrapper = new LambdaQueryWrapper<>();
        if (StringUtils.hasText(key)) {
            wrapper.and(obj -> {
               obj.eq(AttrGroup::getAttrGroupId,key).or().like(AttrGroup::getAttrGroupName,key);
            });
        }

        if (catelogId != 0 ){
            wrapper.eq(AttrGroup::getCatelogId,catelogId);
        }
        return baseMapper.selectPage(page,wrapper);
    }

    @Override
    public void deleteRelation(AttrGroupRelationVo[] vos) {
        List<AttrAttrgroupRelation> list = Arrays.asList(vos).stream().map((item) -> {
            AttrAttrgroupRelation relationEntity = new AttrAttrgroupRelation();
            BeanUtils.copyProperties(item, relationEntity);
            return relationEntity;
        }).collect(Collectors.toList());

        int delCount = relationMapper.deleteBatchRelation(list);
        log.info("成功删除{}条记录！",delCount);
    }

    @Override
    public List<AttrGroupWithAttrsVo> getWithAttrsByCatelogId(Long catelogId) {

        List<AttrGroup> attrGroups = this.list(new LambdaQueryWrapper<AttrGroup>().eq(AttrGroup::getCatelogId,catelogId));

        List<AttrGroupWithAttrsVo> list = attrGroups.stream().map(group -> {
            AttrGroupWithAttrsVo attrGroupWithAttrsVo = new AttrGroupWithAttrsVo();
            BeanUtils.copyProperties(group,attrGroupWithAttrsVo);

            List<Attr> attrs = attrService.getRelationAttr(attrGroupWithAttrsVo.getAttrGroupId());
            attrGroupWithAttrsVo.setAttrs(attrs);

            return attrGroupWithAttrsVo;
        }).collect(Collectors.toList());
        return list;
    }

    @Override
    public List<SpuItemAttrGroupVo> getAttrGroupWithAttrsBySpuId(Long spuId, Long catalogId) {
        return baseMapper.getAttrGroupWithAttrsBySpuId(spuId, catalogId);
    }
}
