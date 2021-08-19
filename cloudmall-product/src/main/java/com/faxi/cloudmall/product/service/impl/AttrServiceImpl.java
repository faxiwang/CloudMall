package com.faxi.cloudmall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.faxi.cloudmall.product.entity.Attr;
import com.faxi.cloudmall.product.entity.AttrAttrgroupRelation;
import com.faxi.cloudmall.product.entity.AttrGroup;
import com.faxi.cloudmall.product.entity.Category;
import com.faxi.cloudmall.product.mapper.AttrAttrgroupRelationMapper;
import com.faxi.cloudmall.product.mapper.AttrGroupMapper;
import com.faxi.cloudmall.product.mapper.AttrMapper;
import com.faxi.cloudmall.product.mapper.CategoryMapper;
import com.faxi.cloudmall.product.service.AttrService;
import com.faxi.cloudmall.product.service.CategoryService;
import com.faxi.cloudmall.product.vo.AttrRespVo;
import com.faxi.cloudmall.product.vo.AttrVo;
import com.faxi.common.constant.ProductConstant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品属性
 *
 * @author faxi
 * @date 2021-07-04 22:19:40
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AttrServiceImpl extends ServiceImpl<AttrMapper, Attr> implements AttrService {

    private final AttrAttrgroupRelationMapper relationMapper;

    private final AttrGroupMapper attrGroupMapper;

    private final CategoryMapper categoryMapper;

    private final CategoryService categoryService;

    @Override
    public Page queryBaseAttrPage(Page page, String key, Long catelogId, String attrType) {
        LambdaQueryWrapper<Attr> wrapper = new LambdaQueryWrapper<>();
        int baseType = "base".equalsIgnoreCase(attrType) ? ProductConstant.AttrEnum.ATTR_TYPE_BASE.getCode() : ProductConstant.AttrEnum.ATTR_TYPE_SALE.getCode();
        wrapper.eq(Attr::getAttrType,baseType);
        if (catelogId != 0) {
            wrapper.eq(Attr::getCatelogId,catelogId);
        }
        if (StringUtils.hasText(key)){
            wrapper.and( w -> {
                wrapper.eq(Attr::getAttrId,key).or().like(Attr::getAttrName,key);
            });
        }
        page = baseMapper.selectPage(page,wrapper);
        List<Attr> records = page.getRecords();

        List<AttrRespVo> respVos = records.stream().map((attrEntity) -> {
            AttrRespVo attrRespVo = new AttrRespVo();
            BeanUtils.copyProperties(attrEntity, attrRespVo);

            //设置分类和分组的名字
            if ("base".equalsIgnoreCase(attrType)) {
                AttrAttrgroupRelation relation =
                        relationMapper.selectOne(new LambdaQueryWrapper<AttrAttrgroupRelation>().eq(AttrAttrgroupRelation::getAttrId,attrEntity.getAttrId()));
                if (relation != null && relation.getAttrGroupId() != null) {
                    AttrGroup attrGroup = attrGroupMapper.selectById(relation.getAttrGroupId());
                    attrRespVo.setGroupName(attrGroup.getAttrGroupName());
                }

            }

            Category categoryEntity = categoryMapper.selectById(attrEntity.getCatelogId());
            if (categoryEntity != null) {
                attrRespVo.setCatelogName(categoryEntity.getName());

            }
            return attrRespVo;
        }).collect(Collectors.toList());
        page.setRecords(respVos);
        return page;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveAttr(AttrVo attr) {
        Attr attrEntity = new Attr();
        BeanUtils.copyProperties(attr,attrEntity);
        //1、保存基本数据
        this.save(attrEntity);

        //2、保存关联关系
        //判断类型，如果是基本属性就设置分组id
        if (attr.getAttrType() == ProductConstant.AttrEnum.ATTR_TYPE_BASE.getCode() && attr.getAttrGroupId() != null) {
            AttrAttrgroupRelation relationEntity = new AttrAttrgroupRelation();
            relationEntity.setAttrGroupId(attr.getAttrGroupId());
            relationEntity.setAttrId(attrEntity.getAttrId());
            relationMapper.insert(relationEntity);
        }

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateAttrById(AttrVo vo) {

        Attr attr = new Attr();
        BeanUtils.copyProperties(vo,attr);

        this.updateById(attr);

        if (attr.getAttrType() == ProductConstant.AttrEnum.ATTR_TYPE_BASE.getCode()) {
            //1、修改分组关联
            AttrAttrgroupRelation relationEntity = new AttrAttrgroupRelation();
            relationEntity.setAttrGroupId(vo.getAttrGroupId());
            relationEntity.setAttrId(vo.getAttrId());

            Integer count = relationMapper.selectCount(new LambdaQueryWrapper<AttrAttrgroupRelation>()
                    .eq(AttrAttrgroupRelation::getAttrId, vo.getAttrId()));

            if (count > 0) {
                relationMapper.update(relationEntity,
                        new LambdaUpdateWrapper<AttrAttrgroupRelation>().eq(AttrAttrgroupRelation::getAttrId,vo.getAttrId()));
            } else {
                relationMapper.insert(relationEntity);
            }
        }

    }

    @Override
    public AttrRespVo getAttrInfo(Long attrId) {

        //查询详细信息
        Attr attr = this.getById(attrId);

        //查询分组信息
        AttrRespVo respVo = new AttrRespVo();
        BeanUtils.copyProperties(attr,respVo);

        //判断是否是基本类型
        if (attr.getAttrType() == ProductConstant.AttrEnum.ATTR_TYPE_BASE.getCode()) {
            //1、设置分组信息
            AttrAttrgroupRelation relationEntity = relationMapper.selectOne
                    (new QueryWrapper<AttrAttrgroupRelation>().eq("attr_id", attrId));
            if (relationEntity != null) {
                respVo.setAttrGroupId(relationEntity.getAttrGroupId());
                //获取分组名称
                AttrGroup attrGroup = attrGroupMapper.selectById(relationEntity.getAttrGroupId());
                if (attrGroup != null) {
                    respVo.setGroupName(attrGroup.getAttrGroupName());
                }
            }
        }

        //2、设置分类信息
        Long catelogId = attr.getCatelogId();
        Long[] catelogPath = categoryService.findCatelogPath(catelogId);

        respVo.setCatelogPath(catelogPath);
        Category category = categoryMapper.selectById(catelogId);
        if (category != null) {
            respVo.setCatelogName(category.getName());
        }

        return respVo;
    }

    @Override
    public List<Attr> getRelationAttr(Long attrgroupId) {

        List<AttrAttrgroupRelation> relations = relationMapper.selectList(
                new LambdaQueryWrapper<AttrAttrgroupRelation>().eq(AttrAttrgroupRelation::getAttrGroupId,attrgroupId)
        );

        List<Long> attrIds = relations.stream().map((attr) -> {
            return attr.getAttrId();
        }).collect(Collectors.toList());

        if (attrIds == null || attrIds.size() == 0) {
            return null;
        }

        List<Attr> attrs = this.baseMapper.selectBatchIds(attrIds);

        return attrs;
    }

    /**
     * 获取当前分组没有被关联的所有属性
     * @param page
     * @param
     * @return
     */
    @Override
    public Page<Attr> getNoRelationAttr(Page page,String key,Long attrgroupId) {
        AttrGroup attrGroup = attrGroupMapper.selectById(attrgroupId);

        Long catelogId = attrGroup.getCatelogId();

        List<AttrGroup> groups = attrGroupMapper.selectList(
                new LambdaQueryWrapper<AttrGroup>().eq(AttrGroup::getCatelogId,catelogId)
        );

        List<Long> collect = groups.stream().map(g -> {
            return g.getAttrGroupId();
        }).collect(Collectors.toList());

        List<AttrAttrgroupRelation> relations = relationMapper.selectList(
                new LambdaQueryWrapper<AttrAttrgroupRelation>().in(AttrAttrgroupRelation::getAttrGroupId, collect)
        );

        List<Long> attrIds = relations.stream().map(r -> {
            return r.getAttrId();
        }).collect(Collectors.toList());

        LambdaQueryWrapper<Attr> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Attr::getCatelogId,catelogId);
        wrapper.eq(Attr::getAttrType, ProductConstant.AttrEnum.ATTR_TYPE_BASE.getCode());

        if (!CollectionUtils.isEmpty(attrIds)){
            wrapper.notIn(Attr::getAttrId,attrIds);
        }

        if (StringUtils.hasText(key)){
            wrapper.and( i ->{
                i.eq(Attr::getAttrId,key).or().like(Attr::getAttrName,key);
            });
        }

        page = this.page(page, wrapper);
        return page;
    }
}
