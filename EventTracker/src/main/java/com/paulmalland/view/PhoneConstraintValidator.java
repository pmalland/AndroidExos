package com.paulmalland.view;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneConstraintValidator implements ConstraintValidator<Phone, String> {

	@Override
	public void initialize(Phone phone) {
		
		//ConstraintValidator.super.initialize(phone);
	}
	/**
	 * the actual validation
	 */
	@Override
	public boolean isValid(String phoneField, ConstraintValidatorContext cxt) {
		if(phoneField == null) {
			return false;
		}
		//basic Regex expression
		// numbers from 0 to 9, looks for parentheses, look for a dash, and * for any number of that.
		// Any number of one or a combination of the different things inside the []. Any other type of characters would
		// set the result to false.
		// Simple regex, could be way more crunchy
		return phoneField.matches("[0-9()-]*");
	}
}
