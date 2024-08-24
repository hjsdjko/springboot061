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
 * 健康饮食搭配
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-09 21:38:54
 */
@TableName("jiankangyinshidapei")
public class JiankangyinshidapeiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JiankangyinshidapeiEntity() {
		
	}
	
	public JiankangyinshidapeiEntity(T t) {
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
	 * 食物种类
	 */
					
	private String shiwuzhonglei;
	
	/**
	 * 营养均衡
	 */
					
	private String yingyangjunheng;
	
	/**
	 * 分量控制
	 */
					
	private String fenliangkongzhi;
	
	/**
	 * 膳食模式
	 */
					
	private String shanshimoshi;
	
	/**
	 * 蛋白质来源
	 */
					
	private String danbaizhilaiyuan;
	
	/**
	 * 脂肪类型
	 */
					
	private String zhifangleixing;
	
	/**
	 * 碳水化合物选择
	 */
					
	private String tanshuihuahewuxuanze;
	
	/**
	 * 维生素和矿物质
	 */
					
	private String weishengsuhekuangwuzhi;
	
	/**
	 * 水分摄入
	 */
					
	private String shuifensheru;
	
	/**
	 * 食物多样性
	 */
					
	private String shiwuduoyangxing;
	
	/**
	 * 三餐安排
	 */
					
	private String sancananpai;
	
	/**
	 * 零食选择
	 */
					
	private String lingshixuanze;
	
	/**
	 * 饮食习惯
	 */
					
	private String yinshixiguan;
	
	/**
	 * 个体差异
	 */
					
	private String getichayi;
	
	/**
	 * 季节因素
	 */
					
	private String jijieyinsu;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	
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
	 * 设置：食物种类
	 */
	public void setShiwuzhonglei(String shiwuzhonglei) {
		this.shiwuzhonglei = shiwuzhonglei;
	}
	/**
	 * 获取：食物种类
	 */
	public String getShiwuzhonglei() {
		return shiwuzhonglei;
	}
	/**
	 * 设置：营养均衡
	 */
	public void setYingyangjunheng(String yingyangjunheng) {
		this.yingyangjunheng = yingyangjunheng;
	}
	/**
	 * 获取：营养均衡
	 */
	public String getYingyangjunheng() {
		return yingyangjunheng;
	}
	/**
	 * 设置：分量控制
	 */
	public void setFenliangkongzhi(String fenliangkongzhi) {
		this.fenliangkongzhi = fenliangkongzhi;
	}
	/**
	 * 获取：分量控制
	 */
	public String getFenliangkongzhi() {
		return fenliangkongzhi;
	}
	/**
	 * 设置：膳食模式
	 */
	public void setShanshimoshi(String shanshimoshi) {
		this.shanshimoshi = shanshimoshi;
	}
	/**
	 * 获取：膳食模式
	 */
	public String getShanshimoshi() {
		return shanshimoshi;
	}
	/**
	 * 设置：蛋白质来源
	 */
	public void setDanbaizhilaiyuan(String danbaizhilaiyuan) {
		this.danbaizhilaiyuan = danbaizhilaiyuan;
	}
	/**
	 * 获取：蛋白质来源
	 */
	public String getDanbaizhilaiyuan() {
		return danbaizhilaiyuan;
	}
	/**
	 * 设置：脂肪类型
	 */
	public void setZhifangleixing(String zhifangleixing) {
		this.zhifangleixing = zhifangleixing;
	}
	/**
	 * 获取：脂肪类型
	 */
	public String getZhifangleixing() {
		return zhifangleixing;
	}
	/**
	 * 设置：碳水化合物选择
	 */
	public void setTanshuihuahewuxuanze(String tanshuihuahewuxuanze) {
		this.tanshuihuahewuxuanze = tanshuihuahewuxuanze;
	}
	/**
	 * 获取：碳水化合物选择
	 */
	public String getTanshuihuahewuxuanze() {
		return tanshuihuahewuxuanze;
	}
	/**
	 * 设置：维生素和矿物质
	 */
	public void setWeishengsuhekuangwuzhi(String weishengsuhekuangwuzhi) {
		this.weishengsuhekuangwuzhi = weishengsuhekuangwuzhi;
	}
	/**
	 * 获取：维生素和矿物质
	 */
	public String getWeishengsuhekuangwuzhi() {
		return weishengsuhekuangwuzhi;
	}
	/**
	 * 设置：水分摄入
	 */
	public void setShuifensheru(String shuifensheru) {
		this.shuifensheru = shuifensheru;
	}
	/**
	 * 获取：水分摄入
	 */
	public String getShuifensheru() {
		return shuifensheru;
	}
	/**
	 * 设置：食物多样性
	 */
	public void setShiwuduoyangxing(String shiwuduoyangxing) {
		this.shiwuduoyangxing = shiwuduoyangxing;
	}
	/**
	 * 获取：食物多样性
	 */
	public String getShiwuduoyangxing() {
		return shiwuduoyangxing;
	}
	/**
	 * 设置：三餐安排
	 */
	public void setSancananpai(String sancananpai) {
		this.sancananpai = sancananpai;
	}
	/**
	 * 获取：三餐安排
	 */
	public String getSancananpai() {
		return sancananpai;
	}
	/**
	 * 设置：零食选择
	 */
	public void setLingshixuanze(String lingshixuanze) {
		this.lingshixuanze = lingshixuanze;
	}
	/**
	 * 获取：零食选择
	 */
	public String getLingshixuanze() {
		return lingshixuanze;
	}
	/**
	 * 设置：饮食习惯
	 */
	public void setYinshixiguan(String yinshixiguan) {
		this.yinshixiguan = yinshixiguan;
	}
	/**
	 * 获取：饮食习惯
	 */
	public String getYinshixiguan() {
		return yinshixiguan;
	}
	/**
	 * 设置：个体差异
	 */
	public void setGetichayi(String getichayi) {
		this.getichayi = getichayi;
	}
	/**
	 * 获取：个体差异
	 */
	public String getGetichayi() {
		return getichayi;
	}
	/**
	 * 设置：季节因素
	 */
	public void setJijieyinsu(String jijieyinsu) {
		this.jijieyinsu = jijieyinsu;
	}
	/**
	 * 获取：季节因素
	 */
	public String getJijieyinsu() {
		return jijieyinsu;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}

}
