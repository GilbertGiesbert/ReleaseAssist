package de.joern.play.releaseassist.form;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;


public abstract class ReleaseAssistFormValidator {

	protected void validateNotBlank(Map<String, String> fieldMap, Errors errors) {	
		
		boolean foundBlank = false;
		for(String fieldName : fieldMap.keySet()) {
			
			String fieldValue = fieldMap.get(fieldName);
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