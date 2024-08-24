package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.JiankangyinshidapeiEntity;
import com.cl.entity.view.JiankangyinshidapeiView;

import com.cl.service.JiankangyinshidapeiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 健康饮食搭配
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-09 21:38:54
 */
@RestController
@RequestMapping("/jiankangyinshidapei")
public class JiankangyinshidapeiController {
    @Autowired
    private JiankangyinshidapeiService jiankangyinshidapeiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiankangyinshidapeiEntity jiankangyinshidapei,
		HttpServletRequest request){
        EntityWrapper<JiankangyinshidapeiEntity> ew = new EntityWrapper<JiankangyinshidapeiEntity>();

		PageUtils page = jiankangyinshidapeiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiankangyinshidapei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiankangyinshidapeiEntity jiankangyinshidapei, 
		HttpServletRequest request){
        EntityWrapper<JiankangyinshidapeiEntity> ew = new EntityWrapper<JiankangyinshidapeiEntity>();

		PageUtils page = jiankangyinshidapeiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiankangyinshidapei), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiankangyinshidapeiEntity jiankangyinshidapei){
       	EntityWrapper<JiankangyinshidapeiEntity> ew = new EntityWrapper<JiankangyinshidapeiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiankangyinshidapei, "jiankangyinshidapei")); 
        return R.ok().put("data", jiankangyinshidapeiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiankangyinshidapeiEntity jiankangyinshidapei){
        EntityWrapper< JiankangyinshidapeiEntity> ew = new EntityWrapper< JiankangyinshidapeiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiankangyinshidapei, "jiankangyinshidapei")); 
		JiankangyinshidapeiView jiankangyinshidapeiView =  jiankangyinshidapeiService.selectView(ew);
		return R.ok("查询健康饮食搭配成功").put("data", jiankangyinshidapeiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiankangyinshidapeiEntity jiankangyinshidapei = jiankangyinshidapeiService.selectById(id);
		jiankangyinshidapei = jiankangyinshidapeiService.selectView(new EntityWrapper<JiankangyinshidapeiEntity>().eq("id", id));
        return R.ok().put("data", jiankangyinshidapei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiankangyinshidapeiEntity jiankangyinshidapei = jiankangyinshidapeiService.selectById(id);
		jiankangyinshidapei = jiankangyinshidapeiService.selectView(new EntityWrapper<JiankangyinshidapeiEntity>().eq("id", id));
        return R.ok().put("data", jiankangyinshidapei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiankangyinshidapeiEntity jiankangyinshidapei, HttpServletRequest request){
    	jiankangyinshidapei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiankangyinshidapei);
        jiankangyinshidapeiService.insert(jiankangyinshidapei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiankangyinshidapeiEntity jiankangyinshidapei, HttpServletRequest request){
    	jiankangyinshidapei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiankangyinshidapei);
        jiankangyinshidapeiService.insert(jiankangyinshidapei);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiankangyinshidapeiEntity jiankangyinshidapei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiankangyinshidapei);
        jiankangyinshidapeiService.updateById(jiankangyinshidapei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiankangyinshidapeiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
