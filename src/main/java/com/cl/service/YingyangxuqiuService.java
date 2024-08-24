package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YingyangxuqiuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YingyangxuqiuView;


/**
 * 营养需求
 *
 * @author 
 * @email 
 * @date 2024-04-09 21:38:55
 */
public interface YingyangxuqiuService extends IService<YingyangxuqiuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YingyangxuqiuView> selectListView(Wrapper<YingyangxuqiuEntity> wrapper);
   	
   	YingyangxuqiuView selectView(@Param("ew") Wrapper<YingyangxuqiuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YingyangxuqiuEntity> wrapper);
   	

}

