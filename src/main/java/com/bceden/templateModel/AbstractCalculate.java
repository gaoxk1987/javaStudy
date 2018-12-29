
/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: hc-bcs 
 * Author: Gao xingkun
 * Createdate: ����4:40:39
 * Version: 1.0
 *
 */

package com.bceden.templateModel;


/**
 * ģ�����ģʽ�������ԭʼ����
 * @project hc-bcs
 * @author Gao xingkun
 * @version 1.0
 * @date 2014-5-12 ����4:40:39   
 */

public abstract class AbstractCalculate {
    protected AbstractCalculate() {
    }
	 public final BusinScore calculateScore(BusinInfo businInfo) {
		 	BusinScore businScore = new BusinScore();
		 	double totalScore = 0.0;
		 	//�����̻�������Ϣ
		 	totalScore+=caluteTitle(businInfo,businScore );
		 	//�������
		 	totalScore+=caluteNoRequiredParam(businInfo,businScore );
	        //�Ǳ������
		 	totalScore+=caluteImage(businInfo,businScore );
	       //����ͼƬ��Ϣ�����޺�������
		 	totalScore+=caluteDetail(businInfo,businScore );
	       //�����һ��ͼƬ��Ϣ���ߴ磩
		 	totalScore+=caluteNum(businInfo,businScore );
	        //��Ӧ�� 
		 	totalScore+=calutePriceType(businInfo,businScore );
	        //������ϸ��Ϣ����
		 	totalScore+=caluteMinOrderNum(businInfo,businScore);	      
	        
			businScore.setScore(totalScore);
			/**************************�����Ǽ�*************************/
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
		 * �����Ǽ�
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
				if(businInfo.isPriceType()){//�����ֱ�ӱ���������
					star = 3;
				}else{
					star = 2;
				}
			}else if(score<520){
				if(businInfo.getHasImage()&&businInfo.getFirstImageType()==2&&businInfo.isPriceType()){//��ͼ ͼƬ�����С�ߴ�>=500 �м۸�
					star = 4;
				}else if(businInfo.getHasImage()&&businInfo.getFirstImageType()!=2&&businInfo.isPriceType()){//��ͼ ͼƬ�����С�ߴ�<500 �м۸�
					star = 3;
				}else{
					star = 2;
				}
			}else{
				if(businInfo.getHasImage()&&businInfo.getFirstImageType()==2&&businInfo.isPriceType()){//��ͼ ͼƬ�����С�ߴ�>=500 �м۸�
					star = 5;
				}else if(businInfo.getHasImage()&&businInfo.getFirstImageType()!=2&&businInfo.isPriceType()){//��ͼ ͼƬ�����С�ߴ�<500 �м۸�
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
			 	//�����̻�������Ϣ
			 	doBusinBasic(businSourceInfo,bisinInfo);
			 	//�������
		        doTitleSource(bisinInfo,businSourceInfo.getTitle(),businSourceInfo.getKeyword());
		        //�Ǳ������
		        doNoRPSource(businSourceInfo,bisinInfo);
		       //����ͼƬ��Ϣ�����޺�������
		        doImgInfo(businSourceInfo,bisinInfo);
		       //�����һ��ͼƬ��Ϣ���ߴ磩
		        doFirstImgInfo(businSourceInfo,bisinInfo);
		        //��Ӧ�� 
		        doHasNum(businSourceInfo,bisinInfo);
		        //������ϸ��Ϣ����
		        doIntroduceSource(businSourceInfo,bisinInfo);
		        //������ϸ��ϢͼƬ
		        doIntroduceImgSource(businSourceInfo,bisinInfo);
		        //��������
		        doPriceType(businSourceInfo,bisinInfo);
		        //��С����
		        doHasMinOrderNum(businSourceInfo,bisinInfo);
		        
		        return bisinInfo;
		    }
		 
		/**
		 * ���������Ϣ
		 * @author Gao xingkun
		 * @version 1.0
		 * @date 2014-5-12 ����7:52:37
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
