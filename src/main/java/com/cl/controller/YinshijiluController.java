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

import com.cl.entity.YinshijiluEntity;
import com.cl.entity.view.YinshijiluView;

import com.cl.service.YinshijiluService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 饮食记录
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-09 21:38:54
 */
@RestController
@RequestMapping("/yinshijilu")
public class YinshijiluController {
    @Autowired
    private YinshijiluService yinshijiluService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YinshijiluEntity yinshijilu,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date jiluriqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date jiluriqiend,
		HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		yinshijilu.setUserid((Long)request.getSession().getAttribute("userId"));
    	}
        EntityWrapper<YinshijiluEntity> ew = new EntityWrapper<YinshijiluEntity>();
                if(jiluriqistart!=null) ew.ge("jiluriqi", jiluriqistart);
                if(jiluriqiend!=null) ew.le("jiluriqi", jiluriqiend);

		PageUtils page = yinshijiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinshijilu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YinshijiluEntity yinshijilu, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date jiluriqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date jiluriqiend,
		HttpServletRequest request){
        EntityWrapper<YinshijiluEntity> ew = new EntityWrapper<YinshijiluEntity>();
                if(jiluriqistart!=null) ew.ge("jiluriqi", jiluriqistart);
                if(jiluriqiend!=null) ew.le("jiluriqi", jiluriqiend);

		PageUtils page = yinshijiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinshijilu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YinshijiluEntity yinshijilu){
       	EntityWrapper<YinshijiluEntity> ew = new EntityWrapper<YinshijiluEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yinshijilu, "yinshijilu")); 
        return R.ok().put("data", yinshijiluService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YinshijiluEntity yinshijilu){
        EntityWrapper< YinshijiluEntity> ew = new EntityWrapper< YinshijiluEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yinshijilu, "yinshijilu")); 
		YinshijiluView yinshijiluView =  yinshijiluService.selectView(ew);
		return R.ok("查询饮食记录成功").put("data", yinshijiluView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YinshijiluEntity yinshijilu = yinshijiluService.selectById(id);
		yinshijilu = yinshijiluService.selectView(new EntityWrapper<YinshijiluEntity>().eq("id", id));
        return R.ok().put("data", yinshijilu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YinshijiluEntity yinshijilu = yinshijiluService.selectById(id);
		yinshijilu = yinshijiluService.selectView(new EntityWrapper<YinshijiluEntity>().eq("id", id));
        return R.ok().put("data", yinshijilu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YinshijiluEntity yinshijilu, HttpServletRequest request){
    	yinshijilu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yinshijilu);
    	yinshijilu.setUserid((Long)request.getSession().getAttribute("userId"));
        yinshijiluService.insert(yinshijilu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YinshijiluEntity yinshijilu, HttpServletRequest request){
    	yinshijilu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yinshijilu);
        yinshijiluService.insert(yinshijilu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YinshijiluEntity yinshijilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yinshijilu);
        yinshijiluService.updateById(yinshijilu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yinshijiluService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
