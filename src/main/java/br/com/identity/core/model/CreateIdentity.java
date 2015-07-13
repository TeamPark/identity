package br.com.identity.core.model;

import javax.inject.Inject;

import br.com.identity.core.repository.IdentityRepository;
import br.com.identity.core.repository.entity.Identity;

public class CreateIdentity {
	
	@Inject
	IdentityRepository repository;
	
	public void create(String email) {
		Identity identity = new Identity();
		identity.setEmail(email);
		
		repository.save(identity);
	}
}
