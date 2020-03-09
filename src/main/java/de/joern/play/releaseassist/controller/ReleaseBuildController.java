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

@Controller
@RequestMapping("/release-build")
public class ReleaseBuildController {
	
	@Autowired
	ReleaseBuildFormValidator releaseBuildFormValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(releaseBuildFormValidator);
	}
	
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public String showFail(ModelMap model) {
		
		if(model.get("resultMessage") == null) {
			return "redirect:/";
		}
		return "result";
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
		
		redirectAttributes.addFlashAttribute("resultSuccess", true);
		redirectAttributes.addFlashAttribute("resultTitle", "pages.result.releaseBuild.successTitle");
		redirectAttributes.addFlashAttribute("resultMessage", "pages.result.releaseBuild.successMessage");
		
		try {
			MockReleaseBuilder.buildRelease(form);
		}catch(Exception ex) {
			
			redirectAttributes.addFlashAttribute("resultSuccess", false);
			redirectAttributes.addFlashAttribute("resultTitle", "pages.result.releaseBuild.successTitle");
			redirectAttributes.addFlashAttribute("resultMessage", "pages.result.releaseBuild.successMessage");
			redirectAttributes.addFlashAttribute("resultContent", ExceptionUtils.getStackTrace(ex));
		}
		return "redirect:/release-build/result";
	}

}