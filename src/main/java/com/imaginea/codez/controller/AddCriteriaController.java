package com.imaginea.codez.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddCriteriaController {

	
	@RequestMapping("/addCriteria")
	public ModelAndView addCriteria() {

		String message = "Enter your Artifact Details";
		return new ModelAndView("addArtifact", "message", message);
	}
	
}
