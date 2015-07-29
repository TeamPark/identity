package br.com.identity.core.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class Repository <T> {
	
	@PersistenceContext(unitName = "teampark")
	private EntityManager entityManager;
	
	public void save(T entity) {
		entityManager.persist(entity);
	}
	
}
