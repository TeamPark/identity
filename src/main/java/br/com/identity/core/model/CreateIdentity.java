package br.com.identity.core.model;

import javax.inject.Inject;

import br.com.identity.core.repository.IdentityRepository;

public class CreateIdentity {
	
	@Inject
	IdentityRepository repository;
	
	public void create(String email) {
		Identity identity = new Identity(null, email);
		repository.save(identity);
	}

}
