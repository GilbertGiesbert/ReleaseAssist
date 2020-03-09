package de.joern.play.releaseassist.form;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
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
		
		Map<String, String> checkMap = new HashMap<>();
		checkMap.put("gitLabUserName", form.getGitLabUserName());
		checkMap.put("initDocumentationReleasePageUrl", form.getInitDocumentationReleasePageUrl());
		checkMap.put("initDocumentationUserName", form.getInitDocumentationUserName());
		checkMap.put("releaseBranchName", form.getReleaseBranchName());
		
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
