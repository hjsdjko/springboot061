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


import com.cl.dao.JiankangyinshidapeiDao;
import com.cl.entity.JiankangyinshidapeiEntity;
import com.cl.service.JiankangyinshidapeiService;
import com.cl.entity.view.JiankangyinshidapeiView;

@Service("jiankangyinshidapeiService")
public class JiankangyinshidapeiServiceImpl extends ServiceImpl<JiankangyinshidapeiDao, JiankangyinshidapeiEntity> implements JiankangyinshidapeiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiankangyinshidapeiEntity> page = this.selectPage(
                new Query<JiankangyinshidapeiEntity>(params).getPage(),
                new EntityWrapper<JiankangyinshidapeiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiankangyinshidapeiEntity> wrapper) {
		  Page<JiankangyinshidapeiView> page =new Query<JiankangyinshidapeiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JiankangyinshidapeiView> selectListView(Wrapper<JiankangyinshidapeiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiankangyinshidapeiView selectView(Wrapper<JiankangyinshidapeiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
