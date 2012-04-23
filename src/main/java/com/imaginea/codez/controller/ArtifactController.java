package com.imaginea.codez.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.imaginea.codez.domain.Artifact;
import com.imaginea.codez.exception.ArtifactFetchException;
import com.imaginea.codez.service.ArtifactService;

@Controller
@SessionAttributes
public class ArtifactController {

	@Autowired
	private ArtifactService artifactService;

	/**
	 * 
	 * @param artifact
	 * @return success page This Method takes input as Artifact object which has
	 *         all the artifact details and adds the details to the DB and
	 *         downloads the source
	 * @throws ArtifactFetchException
	 */
	@RequestMapping(value = "/artifactAdded", method = RequestMethod.POST)
	public ModelAndView addArtifact(@ModelAttribute("artifact") Artifact artifact)
			throws ArtifactFetchException {
		String message = "";
		if (artifactService.addArtifact(artifact)) {
			message = "Artifact has been added to repository";
		} else {
			message = "Artifact already exist in repository";
		}
		return new ModelAndView("success", "message", message);
	}

	/**
	 * 
	 * @return Add Artifact Details page This method is called when it gets a
	 *         redirected call and displays the fields to be keyed in
	 */
	@RequestMapping("/addArtifact")
	public ModelAndView addArtifact() {

		String message = "Enter your Artifact Details";
		return new ModelAndView("addArtifact", "message", message);
	}

	public void setArtifactService(ArtifactService artifactService) {
		this.artifactService = artifactService;
	}

}