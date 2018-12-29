package com.pay.zfb.validator;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.pay.zfb.annotation.SignType;

/**
 * 签名方式验证
 * @project hfbcashier_immediately2account
 * @author chenlf 
 * @version 1.0
 * @date Jan 19, 2015 2:41:17 PM   
 */

public class SignTypeValidator implements ConstraintValidator<SignType, String>{

	
	/**
	 * 
	 * @author chenlf
	 * @version 1.0
	 * @date Jan 19, 2015 2:42:36 PM
	 * @see javax.validation.ConstraintValidator#initialize(java.lang.annotation.Annotation)
	 */
	@Override
	public void initialize(SignType constraintAnnotation) {
	}

	
	/**
	 * 
	 * @author chenlf
	 * @version 1.0
	 * @date Jan 19, 2015 2:42:36 PM
	 * @see javax.validation.ConstraintValidator#isValid(java.lang.Object, javax.validation.ConstraintValidatorContext)
	 */
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		//DSA、RSA、MD5三个值可选，必须大写
		com.pay.zfb.zfbenum.SignType[] signTypes = com.pay.zfb.zfbenum.SignType.values();
		for(com.pay.zfb.zfbenum.SignType signType : signTypes){
			if(signType.name().toUpperCase().equals(value)){
				return true;
			}
		}
		return false;
	}

}
