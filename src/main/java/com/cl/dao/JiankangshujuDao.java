package com.cl.dao;

import com.cl.entity.JiankangshujuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiankangshujuView;


/**
 * 健康数据
 * 
 * @author 
 * @email 
 * @date 2024-04-09 21:38:54
 */
public interface JiankangshujuDao extends BaseMapper<JiankangshujuEntity> {
	
	List<JiankangshujuView> selectListView(@Param("ew") Wrapper<JiankangshujuEntity> wrapper);

	List<JiankangshujuView> selectListView(Pagination page,@Param("ew") Wrapper<JiankangshujuEntity> wrapper);
	
	JiankangshujuView selectView(@Param("ew") Wrapper<JiankangshujuEntity> wrapper);
	

}
