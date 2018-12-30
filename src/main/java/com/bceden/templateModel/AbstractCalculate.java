/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: hc-bcs 
 * Author: Gao xingkun
 * Createdate: 下午4:40:39
 * Version: 1.0
 *
 */

package com.bceden.templateModel;


/**
 * 模版设计模式处理算分原始数据
 * @project hc-bcs
 * @author Gao xingkun
 * @version 1.0
 * @date 2014-5-12 下午4:40:39   
 */

public abstract class AbstractCalculate {
	protected AbstractCalculate() {
	}
	public final BusinScore calculateScore(BusinInfo businInfo) {
		BusinScore businScore = new BusinScore();
		double totalScore = 0.0;
		//处理商机基本信息
		totalScore+=caluteTitle(businInfo,businScore );
		//处理标题
		totalScore+=caluteNoRequiredParam(businInfo,businScore );
		//非必填参数
		totalScore+=caluteImage(businInfo,businScore );
		//处理图片信息（有无和数量）
		totalScore+=caluteDetail(businInfo,businScore );
		//处理第一张图片信息（尺寸）
		totalScore+=caluteNum(businInfo,businScore );
		//供应量
		totalScore+=calutePriceType(businInfo,businScore );
		//处理详细信息字数
		totalScore+=caluteMinOrderNum(businInfo,businScore);

		businScore.setScore(totalScore);
		/**************************计算星级*************************/
		businScore.setStar(getStar(totalScore,businInfo));
		businScore.setUserid(businInfo.getUserid());

		return businScore;
	}

	abstract double caluteTitle (BusinInfo businInfo,BusinScore businScore );
	abstract double caluteNoRequiredParam (BusinInfo businInfo,BusinScore businScore );
	abstract double caluteImage (BusinInfo businInfo,BusinScore businScore );
	abstract double caluteDetail (BusinInfo businInfo,BusinScore businScore );
	abstract double caluteNum (BusinInfo businInfo,BusinScore businScore );
	abstract double calutePriceType (BusinInfo businInfo,BusinScore businScore );
	abstract double caluteMinOrderNum (BusinInfo businInfo,BusinScore businScore );

	/**
	 * 计算星级
	 * @param score
	 * @return
	 */
	public final int getStar(double score,BusinInfo businInfo ){
		int star =0;
		if(score<240){
			star = 1;
		}else if(score<360){
			star = 2;
		}else if(score<440){
			if(businInfo.isPriceType()){//如果是直接报价则三星
				star = 3;
			}else{
				star = 2;
			}
		}else if(score<520){
			if(businInfo.getHasImage()&&businInfo.getFirstImageType()==2&&businInfo.isPriceType()){//有图 图片宽高最小尺寸>=500 有价格
				star = 4;
			}else if(businInfo.getHasImage()&&businInfo.getFirstImageType()!=2&&businInfo.isPriceType()){//有图 图片宽高最小尺寸<500 有价格
				star = 3;
			}else{
				star = 2;
			}
		}else{
			if(businInfo.getHasImage()&&businInfo.getFirstImageType()==2&&businInfo.isPriceType()){//有图 图片宽高最小尺寸>=500 有价格
				star = 5;
			}else if(businInfo.getHasImage()&&businInfo.getFirstImageType()!=2&&businInfo.isPriceType()){//有图 图片宽高最小尺寸<500 有价格
				star = 3;
			}else{
				star = 2;
			}
		}
		return star;
	}

	abstract class calculateSource{
		protected calculateSource() {
		}
		public final BusinInfo calculateSource(BusinSourceInfo businSourceInfo) {
			BusinInfo bisinInfo = new BusinInfo();
			//处理商机基本信息
			doBusinBasic(businSourceInfo,bisinInfo);
			//处理标题
			doTitleSource(bisinInfo,businSourceInfo.getTitle(),businSourceInfo.getKeyword());
			//非必填参数
			doNoRPSource(businSourceInfo,bisinInfo);
			//处理图片信息（有无和数量）
			doImgInfo(businSourceInfo,bisinInfo);
			//处理第一张图片信息（尺寸）
			doFirstImgInfo(businSourceInfo,bisinInfo);
			//供应量
			doHasNum(businSourceInfo,bisinInfo);
			//处理详细信息字数
			doIntroduceSource(businSourceInfo,bisinInfo);
			//处理详细信息图片
			doIntroduceImgSource(businSourceInfo,bisinInfo);
			//报价类型
			doPriceType(businSourceInfo,bisinInfo);
			//最小起订量
			doHasMinOrderNum(businSourceInfo,bisinInfo);

			return bisinInfo;
		}

		/**
		 * 处理基础信息
		 * @author Gao xingkun
		 * @version 1.0
		 * @date 2014-5-12 下午7:52:37
		 * @param businSourceInfo
		 * @param businInfo void
		 */
		public void doBusinBasic(BusinSourceInfo businSourceInfo,BusinInfo businInfo){
			businInfo.setBcid(businSourceInfo.getBcid());
			businInfo.setUserid(businSourceInfo.getUserid());
			businInfo.setCreateTime(businSourceInfo.getCreateTime());
			businInfo.setOper(businSourceInfo.getOper());
			businInfo.setValidate(businSourceInfo.getValidate());
			businInfo.setValidates(businSourceInfo.getValidates());
		}

		abstract void doTitleSource (BusinInfo bisinInfo,String businTitle,String businKeyword);
		abstract void doNoRPSource (BusinSourceInfo businSourceInfo,BusinInfo bisinInfo);
		abstract void doImgInfo (BusinSourceInfo businSourceInfo,BusinInfo bisinInfo);
		abstract void doFirstImgInfo (BusinSourceInfo businSourceInfo,BusinInfo bisinInfo);
		abstract void doHasNum (BusinSourceInfo businSourceInfo,BusinInfo bisinInfo);
		abstract void doIntroduceSource (BusinSourceInfo businSourceInfo,BusinInfo bisinInfo);
		abstract void doIntroduceImgSource (BusinSourceInfo businSourceInfo,BusinInfo bisinInfo);
		abstract void doPriceType (BusinSourceInfo businSourceInfo,BusinInfo bisinInfo);
		abstract void doHasMinOrderNum (BusinSourceInfo businSourceInfo,BusinInfo bisinInfo);
	}
}