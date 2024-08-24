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

import com.cl.entity.YingyangxuqiuEntity;
import com.cl.entity.view.YingyangxuqiuView;

import com.cl.service.YingyangxuqiuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 营养需求
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-09 21:38:55
 */
@RestController
@RequestMapping("/yingyangxuqiu")
public class YingyangxuqiuController {
    @Autowired
    private YingyangxuqiuService yingyangxuqiuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YingyangxuqiuEntity yingyangxuqiu,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date jiluriqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date jiluriqiend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			yingyangxuqiu.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YingyangxuqiuEntity> ew = new EntityWrapper<YingyangxuqiuEntity>();
                if(jiluriqistart!=null) ew.ge("jiluriqi", jiluriqistart);
                if(jiluriqiend!=null) ew.le("jiluriqi", jiluriqiend);

		PageUtils page = yingyangxuqiuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yingyangxuqiu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YingyangxuqiuEntity yingyangxuqiu, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date jiluriqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date jiluriqiend,
		HttpServletRequest request){
        EntityWrapper<YingyangxuqiuEntity> ew = new EntityWrapper<YingyangxuqiuEntity>();
                if(jiluriqistart!=null) ew.ge("jiluriqi", jiluriqistart);
                if(jiluriqiend!=null) ew.le("jiluriqi", jiluriqiend);

		PageUtils page = yingyangxuqiuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yingyangxuqiu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YingyangxuqiuEntity yingyangxuqiu){
       	EntityWrapper<YingyangxuqiuEntity> ew = new EntityWrapper<YingyangxuqiuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yingyangxuqiu, "yingyangxuqiu")); 
        return R.ok().put("data", yingyangxuqiuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YingyangxuqiuEntity yingyangxuqiu){
        EntityWrapper< YingyangxuqiuEntity> ew = new EntityWrapper< YingyangxuqiuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yingyangxuqiu, "yingyangxuqiu")); 
		YingyangxuqiuView yingyangxuqiuView =  yingyangxuqiuService.selectView(ew);
		return R.ok("查询营养需求成功").put("data", yingyangxuqiuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YingyangxuqiuEntity yingyangxuqiu = yingyangxuqiuService.selectById(id);
		yingyangxuqiu = yingyangxuqiuService.selectView(new EntityWrapper<YingyangxuqiuEntity>().eq("id", id));
        return R.ok().put("data", yingyangxuqiu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YingyangxuqiuEntity yingyangxuqiu = yingyangxuqiuService.selectById(id);
		yingyangxuqiu = yingyangxuqiuService.selectView(new EntityWrapper<YingyangxuqiuEntity>().eq("id", id));
        return R.ok().put("data", yingyangxuqiu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YingyangxuqiuEntity yingyangxuqiu, HttpServletRequest request){
    	yingyangxuqiu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yingyangxuqiu);
        yingyangxuqiuService.insert(yingyangxuqiu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YingyangxuqiuEntity yingyangxuqiu, HttpServletRequest request){
    	yingyangxuqiu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yingyangxuqiu);
        yingyangxuqiuService.insert(yingyangxuqiu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YingyangxuqiuEntity yingyangxuqiu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yingyangxuqiu);
        yingyangxuqiuService.updateById(yingyangxuqiu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yingyangxuqiuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
