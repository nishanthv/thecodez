package com.imaginea.codez.form;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Srinivas K.
 * 
 */

@Entity
@Table(name = "artifact")
public class Artifact {

	private int id;
	private String groupId;
	private String artifactId;
	private String version;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "GROUPID")
	public String getGroupId() {
		return this.groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	@Column(name = "ARTIFACTID")
	public String getArtifactId() {
		return this.artifactId;
	}

	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}

	@Column(name = "VERSION")
	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
