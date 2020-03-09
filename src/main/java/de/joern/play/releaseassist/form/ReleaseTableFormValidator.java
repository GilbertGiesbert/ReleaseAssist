package de.joern.play.releaseassist.form;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
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
		
		Map<String, String> checkMap = new HashMap<>();
		checkMap.put("jiraUserName", form.getJiraUserName());
		checkMap.put("lastReleaseBranchName", form.getLastReleaseBranchName());
		
		boolean foundBlank = false;
		for(String fieldName : checkMap.keySet()) {
			
			String fieldValue = checkMap.get(fieldName);
			if(StringUtils.isBlank(fieldValue)) {
				errors.rejectValue(fieldName, "common.blankString");
				foundBlank = true;
			}
		}
		
		if(foundBlank) {
			errors.reject("common.formError.global.blankFields");
		}
		
	}

}
