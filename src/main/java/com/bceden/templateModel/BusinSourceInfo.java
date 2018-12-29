/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: hc-psit
 * Author: Gao xingkun
 * Createdate: 上午11:04:14
 * Version: 1.0
 *
 */

package com.bceden.templateModel;

import java.util.Date;

/**
 * 实时计算加分项原始数据
 * @project hc-psit
 * @author Gao xingkun
 * @version 1.0
 * @date 2014-4-9 上午11:04:14
 */

public class BusinSourceInfo {

	private String bcid;  //供应信息id,多个用'-'分隔
	private long userid; //商家id
	private int oper; //操作类型，0新发待审，1新发免审，2修改待审，3修改免审，4未过期重发，5过期重发，6转过期，7删除，8审核通过，9拒审
	private Date createTime; //发布时间
	private String validate; //有效时间
	private String validates;//多个有效期";"分隔
	private String title;//产品标题
	private String keyword;//产品关键字
	private int norParamNum;//已填写非必填项数量（已填写的非必填参数个数+自定义参数+已填写的规格参数）
	private int nortParamNum;//非必填项总数量（系统预置的总的非必填参数个数+规格参数）
	private int usrParamNum;//用户自定义参数数量 (已填写的自定义参数个数,可以填写的自定义参数最多5个)
	private int imgNum;//图片数量
	private int firstImageHeight;	 	 //第一张图片高度
	private int firstImageWidth;  		 //第一张图片宽度
	private long num;//供货总量
	private long minOrderNum;//最小起订量
	private String introduce;//产品简介
	private int priceType;//报价方式 0：电话报价 1：直接报价(区间、规格 混合)

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getNorParamNum() {
		return norParamNum;
	}
	public void setNorParamNum(int norParamNum) {
		this.norParamNum = norParamNum;
	}
	public int getNortParamNum() {
		return nortParamNum;
	}
	public void setNortParamNum(int nortParamNum) {
		this.nortParamNum = nortParamNum;
	}
	public int getUsrParamNum() {
		return usrParamNum;
	}
	public void setUsrParamNum(int usrParamNum) {
		this.usrParamNum = usrParamNum;
	}
	public int getImgNum() {
		return imgNum;
	}
	public void setImgNum(int imgNum) {
		this.imgNum = imgNum;
	}
	public int getFirstImageHeight() {
		return firstImageHeight;
	}
	public void setFirstImageHeight(int firstImageHeight) {
		this.firstImageHeight = firstImageHeight;
	}
	public int getFirstImageWidth() {
		return firstImageWidth;
	}
	public void setFirstImageWidth(int firstImageWidth) {
		this.firstImageWidth = firstImageWidth;
	}
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public int getPriceType() {
		return priceType;
	}
	public void setPriceType(int priceType) {
		this.priceType = priceType;
	}
	public long getMinOrderNum() {
		return minOrderNum;
	}
	public void setMinOrderNum(long minOrderNum) {
		this.minOrderNum = minOrderNum;
	}
	public String getBcid() {
		return bcid;
	}
	public void setBcid(String bcid) {
		this.bcid = bcid;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public int getOper() {
		return oper;
	}
	public void setOper(int oper) {
		this.oper = oper;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getValidate() {
		return validate;
	}
	public void setValidate(String validate) {
		this.validate = validate;
	}
	public String getValidates() {
		return validates;
	}
	public void setValidates(String validates) {
		this.validates = validates;
	}

}