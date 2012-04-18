package com.imaginea.codez.service;

import org.springframework.stereotype.Service;

import com.imaginea.codez.dao.ArtifactDAO;
import com.imaginea.codez.form.Artifact;

@Service
public class ArtifactService {

	private ArtifactDAO artifactDAO;

	public void addArtifact(Artifact artifact) {
		// TODO: Need to add a code to generate maven repository url for the
		// given artifact and download the the package.
		artifactDAO.addArtifact(artifact);
	}

	public void setArtifactDAO(ArtifactDAO artifactDAO) {
		this.artifactDAO = artifactDAO;
	}
}
