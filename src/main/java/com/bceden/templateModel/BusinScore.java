package com.bceden.templateModel;

/**
 * �̻���������
 * @author Gxk
 *
 */
public class BusinScore{

	private long bcid; //�̻�id
	private long userid; //�û�id
	private double score; //����
	private int state;   //�̻�״̬0����1ɾ����2����3���ͨ����4����
	private int star; //�Ǽ�
	private double hasphoto;//�Ƿ���ͼƬ����
	private double firstphoto;//��һ��ͼƬ����
	private double haslongtitle;//�������
	private double haslongintroduce;//˵������
	private double photocount;//ͼƬ��������
	private double hasnoparam;//�Ǳ��������
	private double hasnum;//��Ӧ��������
	private double userparam;//�û��Զ������
	private double hasprice;//��Ʒ���۷�ʽ�÷�
	private double hasMinNum;//��С�����÷�

	public double getHasprice() {
		return hasprice;
	}
	public void setHasprice(double hasprice) {
		this.hasprice = hasprice;
	}
	public double getHasphoto() {
		return hasphoto;
	}
	public void setHasphoto(double hasphoto) {
		this.hasphoto = hasphoto;
	}
	public double getFirstphoto() {
		return firstphoto;
	}
	public void setFirstphoto(double firstphoto) {
		this.firstphoto = firstphoto;
	}
	public double getHaslongtitle() {
		return haslongtitle;
	}
	public void setHaslongtitle(double haslongtitle) {
		this.haslongtitle = haslongtitle;
	}
	public double getHaslongintroduce() {
		return haslongintroduce;
	}
	public void setHaslongintroduce(double haslongintroduce) {
		this.haslongintroduce = haslongintroduce;
	}
	public double getPhotocount() {
		return photocount;
	}
	public void setPhotocount(double photocount) {
		this.photocount = photocount;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public long getBcid() {
		return bcid;
	}
	public void setBcid(long bcid) {
		this.bcid = bcid;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public double getHasnum() {
		return hasnum;
	}
	public void setHasnum(double hasnum) {
		this.hasnum = hasnum;
	}
	public double getUserparam() {
		return userparam;
	}
	public void setUserparam(double userparam) {
		this.userparam = userparam;
	}
	public double getHasnoparam() {
		return hasnoparam;
	}
	public void setHasnoparam(double hasnoparam) {
		this.hasnoparam = hasnoparam;
	}
	public double getHasMinNum() {
		return hasMinNum;
	}
	public void setHasMinNum(double hasMinNum) {
		this.hasMinNum = hasMinNum;
	}
	
}