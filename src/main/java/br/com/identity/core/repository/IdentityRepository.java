package br.com.identity.core.repository;

import java.util.Random;

import br.com.identity.core.model.Identity;
import br.com.identity.core.repository.entity.IdentityEntity;

public class IdentityRepository extends Repository<IdentityEntity> {
	
	public Identity findByEmail(String email) {
		
		final IdentityEntity entity = executeQuery(email);
		
		return convertEntityToModel(entity);
	}
	
	public void save(Identity identity) {
		IdentityEntity entity = convertModelToEntity(identity);
		super.save(entity);
	}

	private IdentityEntity executeQuery(String email) {
		// TODO implement query
		final IdentityEntity entity = new IdentityEntity(new Random().nextLong(), email);
		
		return entity;
	}
	
	private Identity convertEntityToModel(final IdentityEntity entity) {
		return new Identity(entity.getId(), entity.getEmail());
	}
	
	private IdentityEntity convertModelToEntity(Identity identity) {
		return new IdentityEntity(null, identity.getEmail());
	}
	
}
