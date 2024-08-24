package com.cl.dao;

import com.cl.entity.JiankangyinshidapeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiankangyinshidapeiView;


/**
 * 健康饮食搭配
 * 
 * @author 
 * @email 
 * @date 2024-04-09 21:38:54
 */
public interface JiankangyinshidapeiDao extends BaseMapper<JiankangyinshidapeiEntity> {
	
	List<JiankangyinshidapeiView> selectListView(@Param("ew") Wrapper<JiankangyinshidapeiEntity> wrapper);

	List<JiankangyinshidapeiView> selectListView(Pagination page,@Param("ew") Wrapper<JiankangyinshidapeiEntity> wrapper);
	
	JiankangyinshidapeiView selectView(@Param("ew") Wrapper<JiankangyinshidapeiEntity> wrapper);
	

}
