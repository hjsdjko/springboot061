package com.cl.dao;

import com.cl.entity.YingyangxuqiuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YingyangxuqiuView;


/**
 * 营养需求
 * 
 * @author 
 * @email 
 * @date 2024-04-09 21:38:55
 */
public interface YingyangxuqiuDao extends BaseMapper<YingyangxuqiuEntity> {
	
	List<YingyangxuqiuView> selectListView(@Param("ew") Wrapper<YingyangxuqiuEntity> wrapper);

	List<YingyangxuqiuView> selectListView(Pagination page,@Param("ew") Wrapper<YingyangxuqiuEntity> wrapper);
	
	YingyangxuqiuView selectView(@Param("ew") Wrapper<YingyangxuqiuEntity> wrapper);
	

}
