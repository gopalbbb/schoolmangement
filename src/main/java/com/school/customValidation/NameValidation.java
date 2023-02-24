package com.school.customValidation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NameValidation implements ConstraintValidator<NameValidator, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value.equalsIgnoreCase("abc"))
			return false;
		
		return true;
	}

}
