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
	
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public String showFail(ModelMap model) {
		
//		if(model.get("resultMessage") == null) {
//			return "redirect:/";
//		}
		return "result";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showForm(ModelMap model) {

		model.addAttribute("releaseTableForm", new ReleaseTableForm());
		return "releaseTable";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String handleForm(@ModelAttribute("releaseTableForm") @Validated ReleaseTableForm form,
			BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		
		
		if(result.hasErrors()) {
			return "/releaseTable";
		}
		
		redirectAttributes.addFlashAttribute("resultSuccess", true);
		redirectAttributes.addFlashAttribute("resultTitle", "pages.result.releaseTable.successTitle");
		redirectAttributes.addFlashAttribute("resultMessage", "pages.result.releaseTable.successMessage");
		
		try {
			String releaseTable = MockReleaseTableBuilder.buildReleaseTable(form);
			redirectAttributes.addFlashAttribute("resultContent", releaseTable);
		}catch(Exception ex) {
			
			redirectAttributes.addFlashAttribute("resultSuccess", false);
			redirectAttributes.addFlashAttribute("resultTitle", "pages.result.releaseTable.errorTitle");
			redirectAttributes.addFlashAttribute("resultMessage", "pages.result.releaseTable.errorMessage");
			redirectAttributes.addFlashAttribute("resultContent", ExceptionUtils.getStackTrace(ex));
		}
		return "redirect:/release-table/result";
	}
}