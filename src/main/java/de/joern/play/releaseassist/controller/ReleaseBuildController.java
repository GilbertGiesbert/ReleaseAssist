package de.joern.play.releaseassist.controller;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import de.joern.play.releaseassist.form.ReleaseBuildForm;
import de.joern.play.releaseassist.form.ReleaseBuildFormValidator;
import de.joern.play.releaseassist.mock.MockReleaseBuilder;
import de.joern.play.releaseassist.mock.MockReleaseTableBuilder;

@Controller
@RequestMapping("/release-build")
public class ReleaseBuildController {
	
	@Autowired
	ReleaseBuildFormValidator releaseBuildFormValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(releaseBuildFormValidator);
	}
	
	@RequestMapping(value = "/action-success", method = RequestMethod.GET)
	public String showSuccess(ModelMap model) {
		return "actionSuccess";
	}
	
	@RequestMapping(value = "/action-fail", method = RequestMethod.GET)
	public String showFail(ModelMap model) {
		return "actionFail";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showForm(ModelMap model) {

		model.addAttribute("form", new ReleaseBuildForm());
		return "releaseBuild";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String handleForm(@ModelAttribute("form") @Validated ReleaseBuildForm form,
			BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		
		
		if(result.hasErrors()) {
			return "/releaseBuild";
		}
		
		try {
			MockReleaseBuilder.buildRelease(form);
		}catch(Exception ex) {
			
			redirectAttributes.addFlashAttribute("failTitle", "pages.result.releaseTable.errorTitle");
			redirectAttributes.addFlashAttribute("failMessage", ex.getMessage());
			redirectAttributes.addFlashAttribute("failCause", ex.getCause().toString());
			redirectAttributes.addFlashAttribute("failStackTrace", ExceptionUtils.getStackTrace(ex));
			return "redirect:/release-build/action-fail";
		}
		
		redirectAttributes.addFlashAttribute("successTitle", "pages.result.releaseTable.successTitle");
		redirectAttributes.addFlashAttribute("successMessage", "pages.result.releaseTable.successMessage");
		return "redirect:/release-build/action-success";
	}

}