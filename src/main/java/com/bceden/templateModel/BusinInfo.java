/**
 * 
 */
package com.bceden.templateModel;

import java.util.Date;

/**
 * �̻���Ϣ
 * @author Gxk
 *
 */
public class BusinInfo{
	
	private static final long serialVersionUID = 1L;
	private String bcid;  //��Ӧ��Ϣid,�����'-'�ָ�
	private long userid; //�̼�id
	private int oper; //�������ͣ�0�·�����1�·�����2�޸Ĵ���3�޸�����4δ�����ط���5�����ط���6ת���ڣ�7ɾ����8���ͨ����9����
	private Date createTime; //����ʱ��
	private String validate; //��Чʱ��
	private String validates;//�����Ч��";"�ָ�
	private boolean hasImage;   //�Ƿ���ͼƬ
	private int imageAmount;      //ͼƬ����
	private int noRequiredParam;  //�Ǳ�������ٷֱȣ�0:@=0%;1��0<@<30%��2��30%��@��60%��3��60%��@��80%;4:80%��@��100%;5:100%;6:��Ʒ�����޷Ǳ��������
	private int firstImageType; //��һ��ͼƬ�����С�ߴ� ��0:@=0;1��180<=@<500��2��@>=500����
	private int hasOtherTitleDetail;   //�����Ƿ��������������� ��1����������Ʒ�ؼ���;2��������Ʒ�ؼ���;3:�� �����в���ֵĹؼ��� + ���ؼ�����������֣�Ʒ��Ʒ���ͺ����������֣���
	private int detailAmount;			 //��ϸ�������� ��0:@=0%;1��0<@<15���� ��2��15<=@<100�֣�3��100<=@<300�֣�4��@>=300�֣�
	private int detailImageAmount;   	 //��ϸ������ͼƬ����
	private boolean  hasNum;	 //�Ƿ���ڹ�������
	private boolean  hasMinOrderNum;	 //�Ƿ������С����
	private int  userParamAmount;   	 //�û��Զ����������
	private boolean priceType;//���۷�ʽ  �Ƿ���ֱ�ӱ���

	public String getValidates() {
		return validates;
	}
	public void setValidates(String validates) {
		this.validates = validates;
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
	public boolean getHasImage() {
		return hasImage;
	}
	public void setHasImage(boolean hasImage) {
		this.hasImage = hasImage;
	}
	public int getImageAmount() {
		return imageAmount;
	}
	public void setImageAmount(int imageAmount) {
		this.imageAmount = imageAmount;
	}
	public int getNoRequiredParam() {
		return noRequiredParam;
	}
	public void setNoRequiredParam(int noRequiredParam) {
		this.noRequiredParam = noRequiredParam;
	}
	public int getHasOtherTitleDetail() {
		return hasOtherTitleDetail;
	}
	public void setHasOtherTitleDetail(int hasOtherTitleDetail) {
		this.hasOtherTitleDetail = hasOtherTitleDetail;
	}
	public int getDetailAmount() {
		return detailAmount;
	}
	public void setDetailAmount(int detailAmount) {
		this.detailAmount = detailAmount;
	}
	public int getDetailImageAmount() {
		return detailImageAmount;
	}
	public void setDetailImageAmount(int detailImageAmount) {
		this.detailImageAmount = detailImageAmount;
	}
	public boolean getHasNum() {
		return hasNum;
	}
	public void setHasNum(boolean hasNum) {
		this.hasNum = hasNum;
	}
	public int getUserParamAmount() {
		return userParamAmount;
	}
	public void setUserParamAmount(int userParamAmount) {
		this.userParamAmount = userParamAmount;
	}
	public boolean isPriceType() {
		return priceType;
	}
	public void setPriceType(boolean priceType) {
		this.priceType = priceType;
	}
	public int getFirstImageType() {
		return firstImageType;
	}
	public void setFirstImageType(int firstImageType) {
		this.firstImageType = firstImageType;
	}
	public boolean isHasMinOrderNum() {
		return hasMinOrderNum;
	}
	public void setHasMinOrderNum(boolean hasMinOrderNum) {
		this.hasMinOrderNum = hasMinOrderNum;
	}

}