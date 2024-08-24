package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JiankangshujuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiankangshujuView;


/**
 * 健康数据
 *
 * @author 
 * @email 
 * @date 2024-04-09 21:38:54
 */
public interface JiankangshujuService extends IService<JiankangshujuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiankangshujuView> selectListView(Wrapper<JiankangshujuEntity> wrapper);
   	
   	JiankangshujuView selectView(@Param("ew") Wrapper<JiankangshujuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiankangshujuEntity> wrapper);
   	

}

