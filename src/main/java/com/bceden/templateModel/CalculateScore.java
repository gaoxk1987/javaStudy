/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: hc-bcs 
 * Author: Gao xingkun
 * Createdate: 9:32:52
 * Version: 1.0
 *
 */

package com.bceden.templateModel;


/**
 *
 * @project hc-bcs
 * @author Gao xingkun
 * @version 1.0
 * @date 2014-5-13 9:32:52   
 */

public class CalculateScore extends AbstractCalculate {

    /* (non-Javadoc)
     * @see com.hc360.bcs.utils.AbstractCalculate#caluteTitle(com.hc360.bcs.bo.BusinInfo, com.hc360.bcs.bo.BusinScore)
     */

    @Override
    double caluteTitle(BusinInfo businInfo, BusinScore businScore) {
        // TODO Auto-generated method stub
        return 0;
    }


    /* (non-Javadoc)
     * @see com.hc360.bcs.utils.AbstractCalculate#caluteNoRequiredParam(com.hc360.bcs.bo.BusinInfo, com.hc360.bcs.bo.BusinScore)
     */

    @Override
    double caluteNoRequiredParam(BusinInfo businInfo, BusinScore businScore) {
        // TODO Auto-generated method stub
        return 0;
    }


    /* (non-Javadoc)
     * @see com.hc360.bcs.utils.AbstractCalculate#caluteImage(com.hc360.bcs.bo.BusinInfo, com.hc360.bcs.bo.BusinScore)
     */

    @Override
    double caluteImage(BusinInfo businInfo, BusinScore businScore) {
        // TODO Auto-generated method stub
        return 0;
    }


    /* (non-Javadoc)
     * @see com.hc360.bcs.utils.AbstractCalculate#caluteDetail(com.hc360.bcs.bo.BusinInfo, com.hc360.bcs.bo.BusinScore)
     */

    @Override
    double caluteDetail(BusinInfo businInfo, BusinScore businScore) {
        // TODO Auto-generated method stub
        return 0;
    }


    /* (non-Javadoc)
     * @see com.hc360.bcs.utils.AbstractCalculate#caluteNum(com.hc360.bcs.bo.BusinInfo, com.hc360.bcs.bo.BusinScore)
     */

    @Override
    double caluteNum(BusinInfo businInfo, BusinScore businScore) {
        // TODO Auto-generated method stub
        return 0;
    }


    /* (non-Javadoc)
     * @see com.hc360.bcs.utils.AbstractCalculate#calutePriceType(com.hc360.bcs.bo.BusinInfo, com.hc360.bcs.bo.BusinScore)
     */

    @Override
    double calutePriceType(BusinInfo businInfo, BusinScore businScore) {
        // TODO Auto-generated method stub
        return 0;
    }


    /* (non-Javadoc)
     * @see com.hc360.bcs.utils.AbstractCalculate#caluteMinOrderNum(com.hc360.bcs.bo.BusinInfo, com.hc360.bcs.bo.BusinScore)
     */

    @Override
    double caluteMinOrderNum(BusinInfo businInfo, BusinScore businScore) {
        // TODO Auto-generated method stub
        return 0;
    }

    class CalculateSource extends calculateSource{


        /* (non-Javadoc)
         * @see com.hc360.bcs.utils.AbstractCalculate.calculateSource#doTitleSource(com.hc360.bcs.bo.BusinInfo, java.lang.String, java.lang.String)
         */

        @Override
        void doTitleSource(BusinInfo bisinInfo, String businTitle,
                           String businKeyword) {
            // TODO Auto-generated method stub

        }


        /* (non-Javadoc)
         * @see com.hc360.bcs.utils.AbstractCalculate.calculateSource#doNoRPSource(com.hc360.bcs.bo.BusinSourceInfo, com.hc360.bcs.bo.BusinInfo)
         */

        @Override
        void doNoRPSource(BusinSourceInfo businSourceInfo, BusinInfo bisinInfo) {
            // TODO Auto-generated method stub

        }


        /* (non-Javadoc)
         * @see com.hc360.bcs.utils.AbstractCalculate.calculateSource#doImgInfo(com.hc360.bcs.bo.BusinSourceInfo, com.hc360.bcs.bo.BusinInfo)
         */

        @Override
        void doImgInfo(BusinSourceInfo businSourceInfo, BusinInfo bisinInfo) {
            // TODO Auto-generated method stub

        }


        /* (non-Javadoc)
         * @see com.hc360.bcs.utils.AbstractCalculate.calculateSource#doFirstImgInfo(com.hc360.bcs.bo.BusinSourceInfo, com.hc360.bcs.bo.BusinInfo)
         */

        @Override
        void doFirstImgInfo(BusinSourceInfo businSourceInfo, BusinInfo bisinInfo) {
            // TODO Auto-generated method stub

        }


        /* (non-Javadoc)
         * @see com.hc360.bcs.utils.AbstractCalculate.calculateSource#doHasNum(com.hc360.bcs.bo.BusinSourceInfo, com.hc360.bcs.bo.BusinInfo)
         */

        @Override
        void doHasNum(BusinSourceInfo businSourceInfo, BusinInfo bisinInfo) {
            // TODO Auto-generated method stub

        }


        /* (non-Javadoc)
         * @see com.hc360.bcs.utils.AbstractCalculate.calculateSource#doIntroduceSource(com.hc360.bcs.bo.BusinSourceInfo, com.hc360.bcs.bo.BusinInfo)
         */

        @Override
        void doIntroduceSource(BusinSourceInfo businSourceInfo,
                               BusinInfo bisinInfo) {
            // TODO Auto-generated method stub

        }


        /* (non-Javadoc)
         * @see com.hc360.bcs.utils.AbstractCalculate.calculateSource#doIntroduceImgSource(com.hc360.bcs.bo.BusinSourceInfo, com.hc360.bcs.bo.BusinInfo)
         */

        @Override
        void doIntroduceImgSource(BusinSourceInfo businSourceInfo,
                                  BusinInfo bisinInfo) {
            // TODO Auto-generated method stub

        }


        /* (non-Javadoc)
         * @see com.hc360.bcs.utils.AbstractCalculate.calculateSource#doPriceType(com.hc360.bcs.bo.BusinSourceInfo, com.hc360.bcs.bo.BusinInfo)
         */

        @Override
        void doPriceType(BusinSourceInfo businSourceInfo, BusinInfo bisinInfo) {
            // TODO Auto-generated method stub

        }


        /* (non-Javadoc)
         * @see com.hc360.bcs.utils.AbstractCalculate.calculateSource#doHasMinOrderNum(com.hc360.bcs.bo.BusinSourceInfo, com.hc360.bcs.bo.BusinInfo)
         */

        @Override
        void doHasMinOrderNum(BusinSourceInfo businSourceInfo,
                              BusinInfo bisinInfo) {
            // TODO Auto-generated method stub

        }

    }
}