package de.joern.play.releaseassist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/release-build")
public class ReleaseBuildController {
 
    @RequestMapping(value = "/release-success", method = RequestMethod.GET)
    public String mapReleaseBuild(ModelMap model) {
    	model.addAttribute("greeting", "hi, here's joern again");
        return "releaseBuildSuccess";
    }
 
}