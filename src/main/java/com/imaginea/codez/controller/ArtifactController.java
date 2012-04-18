package com.imaginea.codez.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.imaginea.codez.form.Artifact;
import com.imaginea.codez.service.ArtifactService;

@Controller
@SessionAttributes
public class ArtifactController {

	@Autowired
	private ArtifactService artifactService;

	@RequestMapping(value = "/addArtifact", method = RequestMethod.POST)
	public ModelAndView addContact(@ModelAttribute("artifact") Artifact artifact) {
		artifactService.addArtifact(artifact);

		String message = "Successfully added your artifact";
		return new ModelAndView("success", "message", message);
	}

}
