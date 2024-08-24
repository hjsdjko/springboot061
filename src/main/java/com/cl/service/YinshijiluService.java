package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YinshijiluEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YinshijiluView;


/**
 * 饮食记录
 *
 * @author 
 * @email 
 * @date 2024-04-09 21:38:54
 */
public interface YinshijiluService extends IService<YinshijiluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YinshijiluView> selectListView(Wrapper<YinshijiluEntity> wrapper);
   	
   	YinshijiluView selectView(@Param("ew") Wrapper<YinshijiluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YinshijiluEntity> wrapper);
   	

}

