package com.imaginea.codez.dao;

import java.util.List;

import com.imaginea.codez.form.Artifact;

public interface ArtifactDAO {
	public void addArtifact(Artifact artifact);

	public List<Artifact> listArtifact();

	public void removeArtifact(Integer id);
	
	public boolean isArtifactExist(Artifact artifact);
}
