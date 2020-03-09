package de.joern.play.releaseassist.controller;

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

@Controller
@RequestMapping("/release-build")
public class ReleaseBuildController {
	
	@Autowired
	ReleaseBuildFormValidator releaseBuildFormValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(releaseBuildFormValidator);
	}
	
	@RequestMapping(value = "/build-success", method = RequestMethod.GET)
	public String showSuccess(ModelMap model) {
		return "releaseBuildSuccess";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getForm(ModelMap model) {

		model.addAttribute("form", new ReleaseBuildForm());
		return "releaseBuild";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String postSuccess(@ModelAttribute("form") @Validated ReleaseBuildForm form,
			BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		
		
		if(result.hasErrors()) {
			return "/releaseBuild";
		}
		
		redirectAttributes.addFlashAttribute("successMessage", "Voller Erfolg - release bau");
		
		return "redirect:/release-build/release-success";
	}

}