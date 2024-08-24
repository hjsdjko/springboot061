package com.cl.dao;

import com.cl.entity.YinshijiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YinshijiluView;


/**
 * 饮食记录
 * 
 * @author 
 * @email 
 * @date 2024-04-09 21:38:54
 */
public interface YinshijiluDao extends BaseMapper<YinshijiluEntity> {
	
	List<YinshijiluView> selectListView(@Param("ew") Wrapper<YinshijiluEntity> wrapper);

	List<YinshijiluView> selectListView(Pagination page,@Param("ew") Wrapper<YinshijiluEntity> wrapper);
	
	YinshijiluView selectView(@Param("ew") Wrapper<YinshijiluEntity> wrapper);
	

}
