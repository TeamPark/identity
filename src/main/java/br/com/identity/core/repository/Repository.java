package br.com.identity.core.repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public abstract class Repository <T> {
	
	@Inject
	private EntityManager entityManager;
	
	public void save(T entity) {
		entityManager.getTransaction().begin();
		
		entityManager.persist(entity);
		
		entityManager.getTransaction().commit();
	}

}
