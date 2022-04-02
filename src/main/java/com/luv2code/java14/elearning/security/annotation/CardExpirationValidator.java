package com.luv2code.java14.elearning.security.annotation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.luv2code.java14.elearning.common.exception.InvalidEntityException;

public class CardExpirationValidator implements ConstraintValidator<CardExpiration, String> {
	
	@Override
	public boolean isValid(String expiredDate, ConstraintValidatorContext context) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yy");
		simpleDateFormat.setLenient(false);
		Date expiry = null;
		try {
			expiry = simpleDateFormat.parse(expiredDate);
		} catch (ParseException e) {
			throw new InvalidEntityException("Date is invalid");
		}
		boolean expired = expiry.after(new Date());
		return expired;
	}

}