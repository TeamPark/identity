package br.com.identity.core.repository;

import br.com.identity.core.entity.Identity;

public class IdentityRepository extends Repository<Identity> {
	
	public Identity findByEmail(String email) {
		final Identity entity = executeQuery(email);
		return entity;
	}
	
	public void save(Identity identity) {
		super.save(identity);
	}

	private Identity executeQuery(String email) {
		// TODO implement query
		final Identity identity = new Identity();
		identity.setEmail(email);
		
		return identity;
	}
}
