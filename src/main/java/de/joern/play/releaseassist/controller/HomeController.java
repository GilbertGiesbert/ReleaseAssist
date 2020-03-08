package de.joern.play.releaseassist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {
 
    @RequestMapping(method = RequestMethod.GET)
    public String mapHome(ModelMap model) {
        return "home";
    }
 
    @RequestMapping(value = "/release-build", method = RequestMethod.GET)
    public String mapReleaseBuild(ModelMap model) {
    	model.addAttribute("greeting", "hi, here's joern again");
        return "releaseBuild";
    }
    
    @RequestMapping(value = "/release-table", method = RequestMethod.GET)
    public String mapReleaseTable(ModelMap model) {
    	model.addAttribute("greeting", "hi, here's joern again");
        return "releaseTable";
    }
 
}