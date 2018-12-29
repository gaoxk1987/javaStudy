package com.bceden.templateModel;

/**
 * 商机质量分数
 * @author Gxk
 *
 */
public class BusinScore{

	private long bcid; //商机id
	private long userid; //用户id
	private double score; //分数
	private int state;   //商机状态0待审，1删除，2拒审，3审核通过，4过期
	private int star; //星级
	private double hasphoto;//是否有图片分数
	private double firstphoto;//第一张图片分数
	private double haslongtitle;//标题分数
	private double haslongintroduce;//说明分数
	private double photocount;//图片数量分数
	private double hasnoparam;//非必填项分数
	private double hasnum;//供应总量分数
	private double userparam;//用户自定义分数
	private double hasprice;//产品报价方式得分
	private double hasMinNum;//最小起订量得分

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