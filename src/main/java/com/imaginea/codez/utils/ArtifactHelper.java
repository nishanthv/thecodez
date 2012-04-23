package com.imaginea.codez.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import com.imaginea.codez.domain.Artifact;

public class ArtifactHelper {
	private static String JAR_SOURCE_FILE_EXTENSION = "sources.jar";
	private static String CODEZ_REPO_DIR_NAME = "codez-repository";
	private static String SOURCE_DIR_NAME = "source";

	/**
	 * 
	 * Downloads the artifact source jar.
	 * 
	 * @param artifact
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static String downloadJar(Artifact artifact, String mavenUrl, String localRepoRootDir)
			throws MalformedURLException, IOException {
		String artifactPath = constructArtifactPath(artifact);
		String artifactFileName = constructArtifactSourceFileName(artifact);
		String artifactMavenUrl = mavenUrl + File.separator + artifactPath + File.separator
				+ artifactFileName;
		String artifactLocalPath = constructArtifactLocalPath(artifact, localRepoRootDir);
		IOUtils.copy(new URL(artifactMavenUrl).openStream(),
				FileUtils.openOutputStream(new File(artifactLocalPath)));
		return artifactLocalPath;
	}

	/**
	 * 
	 * Extracts content from the jar file to destDir
	 * 
	 * @param jarFilePath
	 * @param destDir
	 * @throws IOException
	 */
	public static void extractSource(String jarFilePath) throws IOException {
		String destDir = new File(jarFilePath).getParent() + File.separator + SOURCE_DIR_NAME;
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

	public static String constructArtifactLocalPath(Artifact artifact, String rootDir) {
		return rootDir + File.separator + CODEZ_REPO_DIR_NAME + File.separator
				+ constructArtifactPath(artifact) + File.separator
				+ constructArtifactSourceFileName(artifact);
	}

	public static String constructArtifactPath(Artifact artifact) {
		return artifact.getGroupId().replace(".", "/") + File.separator + artifact.getArtifactId()
				+ File.separator + artifact.getVersion();
	}

	public static String constructArtifactSourceFileName(Artifact artifact) {
		return artifact.getArtifactId() + "-" + artifact.getVersion() + "-"
				+ JAR_SOURCE_FILE_EXTENSION;
	}
}
