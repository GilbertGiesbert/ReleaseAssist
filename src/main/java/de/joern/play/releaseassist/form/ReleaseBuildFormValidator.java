package de.joern.play.releaseassist.form;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ReleaseBuildFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ReleaseBuildForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ReleaseBuildForm form = (ReleaseBuildForm) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gitLabUserName", "common.formError.blank");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gitLabPassword", "common.formError.blank");
		
	}

}
