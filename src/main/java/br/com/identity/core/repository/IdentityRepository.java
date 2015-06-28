package br.com.identity.core.repository;

import java.util.Random;

import br.com.identity.core.model.Identity;
import br.com.identity.core.repository.entity.IdentityEntity;

public class IdentityRepository {
	
	public Identity findByEmail(String email) {
		
		final IdentityEntity entity = executeQuery(email);
		
		return convertEntityToModel(entity);
	}

	private IdentityEntity executeQuery(String email) {
		
		// TODO implement query
		final IdentityEntity entity = new IdentityEntity(new Random().nextLong(), email);
		
		return entity;
	}
	
	private Identity convertEntityToModel(final IdentityEntity entity) {
		return new Identity(entity.getId(), entity.getEmail());
	}
}