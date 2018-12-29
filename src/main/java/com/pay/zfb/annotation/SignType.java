package com.pay.zfb.annotation;


import static java.lang.annotation.ElementType.FIELD;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.pay.zfb.validator.SignTypeValidator;

/**
 * 签名方式
 * @project hfbcashier_immediately2account
 * @author chenlf 
 * @version 1.0
 * @date Jan 19, 2015 2:36:58 PM   
 */
@Target({FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SignTypeValidator.class)
@Documented
public @interface SignType {
	String message() default "{com.pay.zfb.validator.SignTypeValidator}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default{};
}
