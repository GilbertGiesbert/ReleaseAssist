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

import de.joern.play.releaseassist.form.ReleaseTableForm;
import de.joern.play.releaseassist.form.ReleaseTableFormValidator;
import de.joern.play.releaseassist.mock.MockReleaseTableBuilder;

@Controller
@RequestMapping("/release-table")
public class ReleaseTableController {
	
	@Autowired
	ReleaseTableFormValidator releaseTableFormValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(releaseTableFormValidator);
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

		model.addAttribute("form", new ReleaseTableForm());
		return "releaseTable";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String handleForm(@ModelAttribute("form") @Validated ReleaseTableForm form,
			BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		
		
		if(result.hasErrors()) {
			return "/releaseTable";
		}
		
		String releaseTable;
		try {
			releaseTable = MockReleaseTableBuilder.buildReleaseTable(form);
		}catch(Exception ex) {
			
			redirectAttributes.addFlashAttribute("failTitle", "pages.result.releaseTable.errorTitle");
			redirectAttributes.addFlashAttribute("failMessage", ex.getMessage());
			redirectAttributes.addFlashAttribute("failCause", ex.getCause().toString());
			redirectAttributes.addFlashAttribute("failStackTrace", ExceptionUtils.getStackTrace(ex));
			return "redirect:/release-table/action-fail";
		}
		
		redirectAttributes.addFlashAttribute("successTitle", "pages.result.releaseTable.successTitle");
		redirectAttributes.addFlashAttribute("successMessage", "pages.result.releaseTable.successMessage");
		redirectAttributes.addFlashAttribute("successResult", releaseTable);
		return "redirect:/release-table/action-success";
	}
}