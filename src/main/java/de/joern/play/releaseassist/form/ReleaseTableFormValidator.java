package de.joern.play.releaseassist.form;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ReleaseTableFormValidator extends ReleaseAssistFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ReleaseTableForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ReleaseTableForm form = (ReleaseTableForm) target;
		
		Map<String, String> fieldMap = new HashMap<>();
		fieldMap.put("jiraUserName", form.getJiraUserName());
		fieldMap.put("lastReleaseBranchName", form.getLastReleaseBranchName());
		
		validateNotBlank(fieldMap, errors);
	}

}
