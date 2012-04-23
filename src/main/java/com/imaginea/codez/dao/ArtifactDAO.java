package com.imaginea.codez.dao;

import java.util.List;

import com.imaginea.codez.domain.Artifact;

public interface ArtifactDAO {
	/**
	 * 
	 * Adds the artifact details to database.
	 * 
	 * @param artifact
	 */
	public void addArtifact(Artifact artifact);

	/**
	 * 
	 * Removes artifact data from database.
	 * 
	 * @param id
	 *            artifact id
	 */
	public void removeArtifact(Integer id);

	/**
	 * 
	 * Checks whether artifact exists or not.
	 * 
	 * @param artifact
	 * @return
	 */
	public boolean exist(Artifact artifact);
}
