package de.joern.play.releaseassist.form;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ReleaseTableFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ReleaseTableForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ReleaseTableForm form = (ReleaseTableForm) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jiraUserName", "common.formError.blank");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jiraPassword", "common.formError.blank");
		
	}

}
