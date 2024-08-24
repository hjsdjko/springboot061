package com.cl.dao;

import com.cl.entity.ShiwuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShiwuxinxiView;


/**
 * 食物信息
 * 
 * @author 
 * @email 
 * @date 2024-04-09 21:38:54
 */
public interface ShiwuxinxiDao extends BaseMapper<ShiwuxinxiEntity> {
	
	List<ShiwuxinxiView> selectListView(@Param("ew") Wrapper<ShiwuxinxiEntity> wrapper);

	List<ShiwuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ShiwuxinxiEntity> wrapper);
	
	ShiwuxinxiView selectView(@Param("ew") Wrapper<ShiwuxinxiEntity> wrapper);
	

}
