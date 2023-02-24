package com.school.customValidation;






import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MailValidator implements ConstraintValidator<CustomValidation, String> {

	@Override
	public boolean isValid(String mail, ConstraintValidatorContext context) {
	//List<String> mail=Arrays.asList(".@gmail.com");
		mail.contains("@gmail.com");
		if(mail.contains("@gmail.com"))
		return true;
		else {
			return false;
		}
	}

}
