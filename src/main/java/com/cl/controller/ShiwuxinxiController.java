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

import com.cl.entity.ShiwuxinxiEntity;
import com.cl.entity.view.ShiwuxinxiView;

import com.cl.service.ShiwuxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 食物信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-09 21:38:54
 */
@RestController
@RequestMapping("/shiwuxinxi")
public class ShiwuxinxiController {
    @Autowired
    private ShiwuxinxiService shiwuxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShiwuxinxiEntity shiwuxinxi,
		HttpServletRequest request){
        EntityWrapper<ShiwuxinxiEntity> ew = new EntityWrapper<ShiwuxinxiEntity>();

		PageUtils page = shiwuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shiwuxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShiwuxinxiEntity shiwuxinxi, 
		HttpServletRequest request){
        EntityWrapper<ShiwuxinxiEntity> ew = new EntityWrapper<ShiwuxinxiEntity>();

		PageUtils page = shiwuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shiwuxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShiwuxinxiEntity shiwuxinxi){
       	EntityWrapper<ShiwuxinxiEntity> ew = new EntityWrapper<ShiwuxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shiwuxinxi, "shiwuxinxi")); 
        return R.ok().put("data", shiwuxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShiwuxinxiEntity shiwuxinxi){
        EntityWrapper< ShiwuxinxiEntity> ew = new EntityWrapper< ShiwuxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shiwuxinxi, "shiwuxinxi")); 
		ShiwuxinxiView shiwuxinxiView =  shiwuxinxiService.selectView(ew);
		return R.ok("查询食物信息成功").put("data", shiwuxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShiwuxinxiEntity shiwuxinxi = shiwuxinxiService.selectById(id);
		shiwuxinxi = shiwuxinxiService.selectView(new EntityWrapper<ShiwuxinxiEntity>().eq("id", id));
        return R.ok().put("data", shiwuxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShiwuxinxiEntity shiwuxinxi = shiwuxinxiService.selectById(id);
		shiwuxinxi = shiwuxinxiService.selectView(new EntityWrapper<ShiwuxinxiEntity>().eq("id", id));
        return R.ok().put("data", shiwuxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShiwuxinxiEntity shiwuxinxi, HttpServletRequest request){
    	shiwuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shiwuxinxi);
        shiwuxinxiService.insert(shiwuxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShiwuxinxiEntity shiwuxinxi, HttpServletRequest request){
    	shiwuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shiwuxinxi);
        shiwuxinxiService.insert(shiwuxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShiwuxinxiEntity shiwuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shiwuxinxi);
        shiwuxinxiService.updateById(shiwuxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shiwuxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
