package com.cl.entity.view;

import com.cl.entity.JiankangyinshidapeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 健康饮食搭配
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-09 21:38:54
 */
@TableName("jiankangyinshidapei")
public class JiankangyinshidapeiView  extends JiankangyinshidapeiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JiankangyinshidapeiView(){
	}
 
 	public JiankangyinshidapeiView(JiankangyinshidapeiEntity jiankangyinshidapeiEntity){
 	try {
			BeanUtils.copyProperties(this, jiankangyinshidapeiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
