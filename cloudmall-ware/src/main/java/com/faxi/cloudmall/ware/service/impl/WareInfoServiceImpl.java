package com.faxi.cloudmall.ware.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.faxi.cloudmall.ware.entity.WareInfo;
import com.faxi.cloudmall.ware.mapper.WareInfoMapper;
import com.faxi.cloudmall.ware.service.WareInfoService;
import org.springframework.stereotype.Service;

/**
 * 仓库信息
 *
 * @author faxi
 * @date 2021-07-05 22:09:27
 */
@Service
public class WareInfoServiceImpl extends ServiceImpl<WareInfoMapper, WareInfo> implements WareInfoService {

}
