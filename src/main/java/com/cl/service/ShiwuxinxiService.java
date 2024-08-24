package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShiwuxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShiwuxinxiView;


/**
 * 食物信息
 *
 * @author 
 * @email 
 * @date 2024-04-09 21:38:54
 */
public interface ShiwuxinxiService extends IService<ShiwuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShiwuxinxiView> selectListView(Wrapper<ShiwuxinxiEntity> wrapper);
   	
   	ShiwuxinxiView selectView(@Param("ew") Wrapper<ShiwuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShiwuxinxiEntity> wrapper);
   	

}

