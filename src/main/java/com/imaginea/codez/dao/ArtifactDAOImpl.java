package com.imaginea.codez.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.imaginea.codez.form.Artifact;

@Transactional
@Repository
public class ArtifactDAOImpl implements ArtifactDAO {

	private SessionFactory sessionFactory;

	@Override
	public void addArtifact(Artifact artifact) {
		sessionFactory.getCurrentSession().save(artifact);
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

	@Override
	public boolean isArtifactExist(Artifact artifact) {
		String query = "select ID from " + Artifact.class.getName()
				+ " where GROUPID=? and ARTIFACTID=? and VERSION=? ";
		return sessionFactory.getCurrentSession().createQuery(query)
				.setParameter(0, artifact.getGroupId()).setParameter(1, artifact.getArtifactId())
				.setParameter(2, artifact.getVersion()).setMaxResults(1).uniqueResult() != null;

	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
