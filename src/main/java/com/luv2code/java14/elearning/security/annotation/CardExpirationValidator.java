package com.luv2code.java14.elearning.security.annotation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CardExpirationValidator implements ConstraintValidator<CardExpiration, String> {
	
	@Override
	public boolean isValid(String expiredDate, ConstraintValidatorContext context) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yy");
		simpleDateFormat.setLenient(false);
		Date expiry = null;
		try {
			expiry = simpleDateFormat.parse(expiredDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		boolean expired = expiry.after(new Date());
		return expired;
	}

}