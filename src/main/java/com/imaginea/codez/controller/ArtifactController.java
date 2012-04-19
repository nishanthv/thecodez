package com.imaginea.codez.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.imaginea.codez.exception.CodezException;
import com.imaginea.codez.form.Artifact;
import com.imaginea.codez.service.ArtifactService;

@Controller
public class ArtifactController {

	@Autowired
	private ArtifactService artifactService;

	@RequestMapping(value = "/addArtifact", method = RequestMethod.POST)
	public ModelAndView addArtifact(@ModelAttribute("artifact") Artifact artifact)
			throws CodezException {
		try {
			artifactService.addArtifact(artifact);
		} catch (CodezException e) {
			throw new CodezException(e.getMessage(), e);
		}
		String message = "Artifact has been added to repository";
		return new ModelAndView("success", "message", message);
	}
}
