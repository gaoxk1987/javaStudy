/**
 *
 */
package com.bceden.templateModel;

import java.util.Date;

/**
 * 商机信息
 * @author Gxk
 *
 */
public class BusinInfo{

    private static final long serialVersionUID = 1L;
    private String bcid;  //供应信息id,多个用'-'分隔
    private long userid; //商家id
    private int oper; //操作类型，0新发待审，1新发免审，2修改待审，3修改免审，4未过期重发，5过期重发，6转过期，7删除，8审核通过，9拒审
    private Date createTime; //发布时间
    private String validate; //有效时间
    private String validates;//多个有效期";"分隔
    private boolean hasImage;   //是否有图片
    private int imageAmount;      //图片数量
    private int noRequiredParam;  //非必填参数百分比（0:@=0%;1：0<@<30%；2：30%≤@＜60%；3：60%≤@＜80%;4:80%≤@＜100%;5:100%;6:该品类下无非必填参数）
    private int firstImageType; //第一张图片宽高最小尺寸 （0:@=0;1：180<=@<500；2：@>=500；）
    private int hasOtherTitleDetail;   //标题是否含有其它文字内容 （1：不包括产品关键字;2：包含产品关键字;3:“ 包含有不拆分的关键字 + 除关键字以外的文字（品类品牌型号算其它文字））
    private int detailAmount;			 //详细内容字数 （0:@=0%;1：0<@<15个字 ；2：15<=@<100字；3：100<=@<300字；4：@>=300字）
    private int detailImageAmount;   	 //详细内容中图片数量
    private boolean  hasNum;	 //是否存在供货总量
    private boolean  hasMinOrderNum;	 //是否存在最小起订量
    private int  userParamAmount;   	 //用户自定义参数个数
    private boolean priceType;//报价方式  是否是直接报价

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