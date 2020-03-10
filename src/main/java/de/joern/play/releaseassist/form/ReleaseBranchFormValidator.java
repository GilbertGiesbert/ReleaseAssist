package de.joern.play.releaseassist.form;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ReleaseBranchFormValidator extends ReleaseAssistFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ReleaseBranchForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ReleaseBranchForm form = (ReleaseBranchForm) target;
		
		Map<String, String> fieldMap = new HashMap<>();
		fieldMap.put("gitLabUserName", form.getGitLabUserName());
		fieldMap.put("initDocumentationReleasePageUrl", form.getInitDocumentationReleasePageUrl());
		fieldMap.put("initDocumentationUserName", form.getInitDocumentationUserName());
		fieldMap.put("releaseBranchName", form.getReleaseBranchName());
		
		validateNotBlank(fieldMap, errors);
	}

}
