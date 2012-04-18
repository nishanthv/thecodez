package com.imaginea.codez.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.imaginea.codez.form.Artifact;

public class ArtifactDAOImpl implements ArtifactDAO {

	
	private HibernateTemplate hibernateTemplate;

	@Override
	@Transactional
	public void addArtifact(Artifact artifact) {
		hibernateTemplate.save(artifact);
	}

	@Override
	public List<Artifact> listArtifact() {
		// TODO Auto-generated method stub.
		return null;
	}

	@Override
	public void removeArtifact(Integer id) {
		// TODO Auto-generated method stub.

	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	
}
