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

import de.joern.play.releaseassist.form.ReleaseTableForm;
import de.joern.play.releaseassist.form.ReleaseTableFormValidator;

@Controller
@RequestMapping("/release-table")
public class ReleaseTableController {
	
	@Autowired
	ReleaseTableFormValidator releaseTableFormValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(releaseTableFormValidator);
	}
	
	@RequestMapping(value = "/table-success", method = RequestMethod.GET)
	public String showSuccess(ModelMap model) {
		return "releaseTableSuccess";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getForm(ModelMap model) {

		model.addAttribute("form", new ReleaseTableForm());
		return "releaseTable";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String postSuccess(@ModelAttribute("form") @Validated ReleaseTableForm form,
			BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		
		
		if(result.hasErrors()) {
			return "/releaseTable";
		}
		
		redirectAttributes.addFlashAttribute("successMessage", "Voller Erfolg - release tabelle");
		
		return "redirect:/release-table/table-success";
	}

}