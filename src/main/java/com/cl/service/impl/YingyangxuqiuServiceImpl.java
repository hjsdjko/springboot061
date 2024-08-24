package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.YingyangxuqiuDao;
import com.cl.entity.YingyangxuqiuEntity;
import com.cl.service.YingyangxuqiuService;
import com.cl.entity.view.YingyangxuqiuView;

@Service("yingyangxuqiuService")
public class YingyangxuqiuServiceImpl extends ServiceImpl<YingyangxuqiuDao, YingyangxuqiuEntity> implements YingyangxuqiuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YingyangxuqiuEntity> page = this.selectPage(
                new Query<YingyangxuqiuEntity>(params).getPage(),
                new EntityWrapper<YingyangxuqiuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YingyangxuqiuEntity> wrapper) {
		  Page<YingyangxuqiuView> page =new Query<YingyangxuqiuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YingyangxuqiuView> selectListView(Wrapper<YingyangxuqiuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YingyangxuqiuView selectView(Wrapper<YingyangxuqiuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
