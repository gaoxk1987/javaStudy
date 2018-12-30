package com.pay.zfb.vo;

import com.pay.zfb.validator.inteface.ValidateSignData;


public class DirectPayMentPV implements ValidateSignData{
   
	private String service;//接口名称	接口名称是否存在，且未关闭 TODO
	private String version;//版本号	接口对应版本是否存在，且未关闭 TODO
    private String partner;//商户号
    private String charset;//编码格式
    private String signType;//签名方式
    private String sign;//签名内容  TODO
    private String notifyURL;//服务器异步通知地址
	private String returnURL;//页面跳转同步通知页面路径
	private String orderCode;//商户网站唯一订单号 TODO
    private String subject;//商品名称 TODO
    private String showUrl;//商品展示地址
    private String subBody;//商品描述
    private String amount; //金额 
    private String timestamp; //此次电子协议时间戳 TODO
    private String sellerSSOID; //卖家ssoid
    private String receiverName;//收货人姓名
    private String receiverAddress;//收货人地址
    private String receiverPhone;//收货人电话


    /**
     * 慧付宝专用信息
     * @return
     */
    private String tradeCode;//慧付宝交易流水
    private String tradeType;//交易类型
    private String payFlowNumber;
    private String isrepost;//1:是重新请求
    private String payBankType;
    private String hfbBankCode;
    private String payBankId;

    public String getTradeCode() {
        return tradeCode;
    }

    public void setTradeCode(String tradeCode) {
        this.tradeCode = tradeCode;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getNotifyURL() {
        return notifyURL;
    }

    public void setNotifyURL(String notifyURL) {
        this.notifyURL = notifyURL;
    }

    public String getReturnURL() {
        return returnURL;
    }

    public void setReturnURL(String returnURL) {
        this.returnURL = returnURL;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getShowUrl() {
        return showUrl;
    }

    public void setShowUrl(String showUrl) {
        this.showUrl = showUrl;
    }

    public String getSubBody() {
        return subBody;
    }

    public void setSubBody(String subBody) {
        this.subBody = subBody;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSellerSSOID() {
        return sellerSSOID;
    }

    public void setSellerSSOID(String sellerSSOID) {
        this.sellerSSOID = sellerSSOID;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

	public String getPayFlowNumber() {
		return payFlowNumber;
	}

	public void setPayFlowNumber(String payFlowNumber) {
		this.payFlowNumber = payFlowNumber;
	}

	public String getIsrepost() {
		return isrepost;
	}

	public void setIsrepost(String isrepost) {
		this.isrepost = isrepost;
	}

	public String getPayBankType() {
		return payBankType;
	}

	public void setPayBankType(String payBankType) {
		this.payBankType = payBankType;
	}

	public String getHfbBankCode() {
		return hfbBankCode;
	}

	public void setHfbBankCode(String hfbBankCode) {
		this.hfbBankCode = hfbBankCode;
	}

	public String getPayBankId() {
		return payBankId;
	}

	public void setPayBankId(String payBankId) {
		this.payBankId = payBankId;
	}
    
}
