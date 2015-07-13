package br.com.identity.core.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProducer {
	
	@Produces
	@ApplicationScoped
	public EntityManagerFactory createEntityManagerFactory() {
		return Persistence.createEntityManagerFactory("teampark");
	}
	
	@Produces
	@RequestScoped
	public EntityManager createEntityManager(EntityManagerFactory factory) {
		return factory.createEntityManager();
	}

	public void closeEntityManager(@Disposes EntityManager entityManager) {
		entityManager.close();
	}

}
