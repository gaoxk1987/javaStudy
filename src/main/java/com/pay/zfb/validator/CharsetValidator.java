package com.pay.zfb.validator;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.pay.zfb.annotation.Charset;

/**
 * 编码格式验证器
 * @project hfbcashier_immediately2account
 * @author chenlf 
 * @version 1.0
 * @date Jan 19, 2015 2:41:17 PM   
 */

public class CharsetValidator implements ConstraintValidator<Charset, String>{

	
	/**
	 * 
	 * @author chenlf
	 * @version 1.0
	 * @date Jan 19, 2015 2:42:36 PM
	 * @see javax.validation.ConstraintValidator#initialize(java.lang.annotation.Annotation)
	 */
	@Override
	public void initialize(Charset constraintAnnotation) {
	}

	
	/**
	 * 
	 * @version 1.0
	 * @date Jan 19, 2015 2:42:36 PM
	 * @see javax.validation.ConstraintValidator#isValid(java.lang.Object, javax.validation.ConstraintValidatorContext)
	 */
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		//仅支持utf-8、gbk
		if("utf-8".equals(value) || "gbk".equals(value)){
			return true;
		}
		return false;
	}

}
