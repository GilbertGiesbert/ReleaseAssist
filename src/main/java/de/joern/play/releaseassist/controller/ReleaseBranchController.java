package de.joern.play.releaseassist.controller;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import de.joern.play.releaseassist.form.ReleaseBranchForm;
import de.joern.play.releaseassist.form.ReleaseBranchFormValidator;
import de.joern.play.releaseassist.mock.MockReleaseBranchBuilder;

@Controller
@RequestMapping("/release-branch")
public class ReleaseBranchController {
	
	private static final Logger LOG = LoggerFactory.getLogger(ReleaseBranchController.class);
	
	@Autowired
	ReleaseBranchFormValidator releaseBranchFormValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(releaseBranchFormValidator);
	}
	
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public String showFail(ModelMap model) {
		
		if(model.get("resultType") == null) {
			return "redirect:/";
		}
		return "result";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showForm(ModelMap model) {

		model.addAttribute("releaseBranchForm", new ReleaseBranchForm());
		return "releaseBranch";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String handleForm(@ModelAttribute("releaseBranchForm") @Validated ReleaseBranchForm form,
			BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		
		LOG.debug("handleForm(): form="+form);
		
		if(result.hasErrors()) {
			return "/releaseBranch";
		}
		
		redirectAttributes.addFlashAttribute("resultSuccess", true);
		redirectAttributes.addFlashAttribute("resultType", "releaseBranch");
		
		try {
			MockReleaseBranchBuilder.buildReleaseBranch(form);
		}catch(Exception ex) {
			
			redirectAttributes.addFlashAttribute("resultSuccess", false);
			redirectAttributes.addFlashAttribute("resultContent", ExceptionUtils.getStackTrace(ex));
		}
		return "redirect:/release-branch/result";
	}

}