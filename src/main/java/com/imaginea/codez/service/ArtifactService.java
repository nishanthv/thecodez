package com.imaginea.codez.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import com.imaginea.codez.dao.ArtifactDAO;
import com.imaginea.codez.exception.CodezException;
import com.imaginea.codez.form.Artifact;

@Service
public class ArtifactService {

	private static String JAR_SOURCE_FILE_EXTENSION = "sources.jar";
	private static String CODEZ_REPO_DIR_NAME = "codez-repository";
	private static String SOURCE_DIR_NAME = "source";
	private String localRepositoryDir;
	private String mavenRepository;
	private String localRepositoryRootDir;
	private ArtifactDAO artifactDAO;

	public void addArtifact(Artifact artifact) throws CodezException {
		try {
			downloadAndExtractArtifactJar(artifact);
			artifactDAO.addArtifact(artifact);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CodezException("Falied to add Artifact: "
					+ constructArtifactSourceFileName(artifact), e);
		}
	}

	public void setArtifactDAO(ArtifactDAO artifactDAO) {
		this.artifactDAO = artifactDAO;
	}

	public void setMavenRepository(String mavenRepository) {
		this.mavenRepository = mavenRepository;
	}

	public void setLocalRepositoryRootDir(String localRepositoryRootDir) {
		localRepositoryDir = localRepositoryRootDir + File.separator + CODEZ_REPO_DIR_NAME;
	}

	/**
	 * 
	 * Downloads the artifact and extract the content.
	 * 
	 * @param artifact
	 * @throws MalformedURLException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private void downloadAndExtractArtifactJar(Artifact artifact) throws MalformedURLException,
			FileNotFoundException, IOException {
		String artifactPath = constructArtifactPath(artifact);
		String artifactFileName = constructArtifactSourceFileName(artifact);
		String artifactMavenUrl = mavenRepository + File.separator + artifactPath + File.separator
				+ artifactFileName;
		String artifactLocalPath = localRepositoryDir + File.separator + artifactPath
				+ File.separator + artifactFileName;
		IOUtils.copy(new URL(artifactMavenUrl).openStream(),
				FileUtils.openOutputStream(new File(artifactLocalPath)));
		String destDir = localRepositoryDir + File.separator + artifactPath + File.separator
				+ SOURCE_DIR_NAME;
		extractJar(artifactLocalPath, destDir);
	}

	/**
	 * 
	 * Extracts content from the jar file to destDir
	 * 
	 * @param jarFilePath
	 * @param destDir
	 * @throws IOException
	 */
	public void extractJar(String jarFilePath, String destDir) throws IOException {
		JarFile jar = new JarFile(jarFilePath);
		Enumeration<JarEntry> entries = jar.entries();
		while (entries.hasMoreElements()) {
			JarEntry entry = entries.nextElement();
			File file = new File(destDir + File.separator + entry.getName());
			if (entry.isDirectory()) {
				FileUtils.forceMkdir(file);
				continue;
			}
			InputStream is = jar.getInputStream(entry);
			FileUtils.copyInputStreamToFile(is, file);
		}
	}

	private String constructArtifactPath(Artifact artifact) {
		return artifact.getGroupId().replace(".", "/") + File.separator + artifact.getArtifactId()
				+ File.separator + artifact.getVersion();
	}

	private String constructArtifactSourceFileName(Artifact artifact) {
		return artifact.getArtifactId() + "-" + artifact.getVersion() + "-"
				+ JAR_SOURCE_FILE_EXTENSION;
	}
}