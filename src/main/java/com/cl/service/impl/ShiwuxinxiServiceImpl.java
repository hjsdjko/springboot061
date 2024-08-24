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


import com.cl.dao.ShiwuxinxiDao;
import com.cl.entity.ShiwuxinxiEntity;
import com.cl.service.ShiwuxinxiService;
import com.cl.entity.view.ShiwuxinxiView;

@Service("shiwuxinxiService")
public class ShiwuxinxiServiceImpl extends ServiceImpl<ShiwuxinxiDao, ShiwuxinxiEntity> implements ShiwuxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShiwuxinxiEntity> page = this.selectPage(
                new Query<ShiwuxinxiEntity>(params).getPage(),
                new EntityWrapper<ShiwuxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShiwuxinxiEntity> wrapper) {
		  Page<ShiwuxinxiView> page =new Query<ShiwuxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ShiwuxinxiView> selectListView(Wrapper<ShiwuxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShiwuxinxiView selectView(Wrapper<ShiwuxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
