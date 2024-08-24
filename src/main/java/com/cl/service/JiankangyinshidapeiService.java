package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JiankangyinshidapeiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiankangyinshidapeiView;


/**
 * 健康饮食搭配
 *
 * @author 
 * @email 
 * @date 2024-04-09 21:38:54
 */
public interface JiankangyinshidapeiService extends IService<JiankangyinshidapeiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiankangyinshidapeiView> selectListView(Wrapper<JiankangyinshidapeiEntity> wrapper);
   	
   	JiankangyinshidapeiView selectView(@Param("ew") Wrapper<JiankangyinshidapeiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiankangyinshidapeiEntity> wrapper);
   	

}

