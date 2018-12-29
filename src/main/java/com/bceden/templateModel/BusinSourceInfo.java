
/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: hc-psit 
 * Author: Gao xingkun
 * Createdate: ����11:04:14
 * Version: 1.0
 *
 */

package com.bceden.templateModel;

import java.util.Date;

/**
 * ʵʱ����ӷ���ԭʼ����
 * @project hc-psit
 * @author Gao xingkun
 * @version 1.0
 * @date 2014-4-9 ����11:04:14   
 */

public class BusinSourceInfo {
	
	private String bcid;  //��Ӧ��Ϣid,�����'-'�ָ�
	private long userid; //�̼�id
	private int oper; //�������ͣ�0�·�����1�·�����2�޸Ĵ���3�޸�����4δ�����ط���5�����ط���6ת���ڣ�7ɾ����8���ͨ����9����
	private Date createTime; //����ʱ��
	private String validate; //��Чʱ��
	private String validates;//�����Ч��";"�ָ�
	private String title;//��Ʒ����
	private String keyword;//��Ʒ�ؼ���
	private int norParamNum;//����д�Ǳ���������������д�ķǱ����������+�Զ������+����д�Ĺ�������
	private int nortParamNum;//�Ǳ�������������ϵͳԤ�õ��ܵķǱ����������+��������
	private int usrParamNum;//�û��Զ���������� (����д���Զ����������,������д���Զ���������5��)
	private int imgNum;//ͼƬ����
	private int firstImageHeight;	 	 //��һ��ͼƬ�߶�
	private int firstImageWidth;  		 //��һ��ͼƬ���
	private long num;//��������
	private long minOrderNum;//��С����
	private String introduce;//��Ʒ���
	private int priceType;//���۷�ʽ 0���绰���� 1��ֱ�ӱ���(���䡢��� ���)
	
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