package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 饮食记录
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-09 21:38:54
 */
@TableName("yinshijilu")
public class YinshijiluEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public YinshijiluEntity() {
		
	}
	
	public YinshijiluEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 记录日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date jiluriqi;
	
	/**
	 * 热量
	 */
					
	private String reliang;
	
	/**
	 * 蛋白质
	 */
					
	private String danbaizhi;
	
	/**
	 * 脂肪
	 */
					
	private String zhifang;
	
	/**
	 * 饮食详情
	 */
					
	private String yinshixiangqing;
	
	/**
	 * 记录人
	 */
					
	private String jiluren;
	
	/**
	 * 用户id
	 */
					
	private Long userid;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：记录日期
	 */
	public void setJiluriqi(Date jiluriqi) {
		this.jiluriqi = jiluriqi;
	}
	/**
	 * 获取：记录日期
	 */
	public Date getJiluriqi() {
		return jiluriqi;
	}
	/**
	 * 设置：热量
	 */
	public void setReliang(String reliang) {
		this.reliang = reliang;
	}
	/**
	 * 获取：热量
	 */
	public String getReliang() {
		return reliang;
	}
	/**
	 * 设置：蛋白质
	 */
	public void setDanbaizhi(String danbaizhi) {
		this.danbaizhi = danbaizhi;
	}
	/**
	 * 获取：蛋白质
	 */
	public String getDanbaizhi() {
		return danbaizhi;
	}
	/**
	 * 设置：脂肪
	 */
	public void setZhifang(String zhifang) {
		this.zhifang = zhifang;
	}
	/**
	 * 获取：脂肪
	 */
	public String getZhifang() {
		return zhifang;
	}
	/**
	 * 设置：饮食详情
	 */
	public void setYinshixiangqing(String yinshixiangqing) {
		this.yinshixiangqing = yinshixiangqing;
	}
	/**
	 * 获取：饮食详情
	 */
	public String getYinshixiangqing() {
		return yinshixiangqing;
	}
	/**
	 * 设置：记录人
	 */
	public void setJiluren(String jiluren) {
		this.jiluren = jiluren;
	}
	/**
	 * 获取：记录人
	 */
	public String getJiluren() {
		return jiluren;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	/**
	 * 获取：用户id
	 */
	public Long getUserid() {
		return userid;
	}

}
