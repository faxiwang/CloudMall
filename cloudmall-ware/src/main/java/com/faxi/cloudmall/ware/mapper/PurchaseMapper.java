package com.faxi.cloudmall.ware.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.faxi.cloudmall.ware.entity.Purchase;
import org.apache.ibatis.annotations.Mapper;

/**
 * 采购信息
 *
 * @author faxi
 * @date 2021-07-05 22:09:27
 */
@Mapper
public interface PurchaseMapper extends BaseMapper<Purchase> {

}
