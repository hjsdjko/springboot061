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

import com.cl.entity.JiankangshujuEntity;
import com.cl.entity.view.JiankangshujuView;

import com.cl.service.JiankangshujuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 健康数据
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-09 21:38:54
 */
@RestController
@RequestMapping("/jiankangshuju")
public class JiankangshujuController {
    @Autowired
    private JiankangshujuService jiankangshujuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiankangshujuEntity jiankangshuju,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			jiankangshuju.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JiankangshujuEntity> ew = new EntityWrapper<JiankangshujuEntity>();

		PageUtils page = jiankangshujuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiankangshuju), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiankangshujuEntity jiankangshuju, 
		HttpServletRequest request){
        EntityWrapper<JiankangshujuEntity> ew = new EntityWrapper<JiankangshujuEntity>();

		PageUtils page = jiankangshujuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiankangshuju), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiankangshujuEntity jiankangshuju){
       	EntityWrapper<JiankangshujuEntity> ew = new EntityWrapper<JiankangshujuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiankangshuju, "jiankangshuju")); 
        return R.ok().put("data", jiankangshujuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiankangshujuEntity jiankangshuju){
        EntityWrapper< JiankangshujuEntity> ew = new EntityWrapper< JiankangshujuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiankangshuju, "jiankangshuju")); 
		JiankangshujuView jiankangshujuView =  jiankangshujuService.selectView(ew);
		return R.ok("查询健康数据成功").put("data", jiankangshujuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiankangshujuEntity jiankangshuju = jiankangshujuService.selectById(id);
		jiankangshuju = jiankangshujuService.selectView(new EntityWrapper<JiankangshujuEntity>().eq("id", id));
        return R.ok().put("data", jiankangshuju);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiankangshujuEntity jiankangshuju = jiankangshujuService.selectById(id);
		jiankangshuju = jiankangshujuService.selectView(new EntityWrapper<JiankangshujuEntity>().eq("id", id));
        return R.ok().put("data", jiankangshuju);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiankangshujuEntity jiankangshuju, HttpServletRequest request){
    	jiankangshuju.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiankangshuju);
        jiankangshujuService.insert(jiankangshuju);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiankangshujuEntity jiankangshuju, HttpServletRequest request){
    	jiankangshuju.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiankangshuju);
        jiankangshujuService.insert(jiankangshuju);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiankangshujuEntity jiankangshuju, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiankangshuju);
        jiankangshujuService.updateById(jiankangshuju);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiankangshujuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
