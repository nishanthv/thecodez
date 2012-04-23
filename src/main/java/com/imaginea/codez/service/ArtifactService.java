package com.imaginea.codez.service;

import org.springframework.stereotype.Service;

import com.imaginea.codez.dao.ArtifactDAO;
import com.imaginea.codez.domain.Artifact;
import com.imaginea.codez.exception.ArtifactFetchException;
import com.imaginea.codez.exception.BaseException;
import com.imaginea.codez.utils.ArtifactHelper;

@Service
public class ArtifactService {

	private String mavenRepository;
	private String localRepositoryRootDir;
	private ArtifactDAO artifactDAO;

	/**
	 * 
	 * Downloads the artifact jar from maven repository, extracts its contents
	 * and stores the details in database.
	 * 
	 * @param artifact
	 * @return
	 * @throws BaseException
	 */
	public boolean addArtifact(Artifact artifact) throws ArtifactFetchException {
		try {
			if (!artifactDAO.exist(artifact)) {
				String jarFilePath = ArtifactHelper.downloadJar(artifact, mavenRepository,
						localRepositoryRootDir);
				ArtifactHelper.extractSource(jarFilePath);
				artifactDAO.addArtifact(artifact);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			throw new ArtifactFetchException("Failed to add Artifact: " + e.getMessage(), e);
		}
	}

	public void setArtifactDAO(ArtifactDAO artifactDAO) {
		this.artifactDAO = artifactDAO;
	}

	public void setMavenRepository(String mavenRepository) {
		this.mavenRepository = mavenRepository;
	}

	public void setLocalRepositoryRootDir(String localRepositoryRootDir) {
		this.localRepositoryRootDir = localRepositoryRootDir;
	}
}