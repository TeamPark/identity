package br.com.identity.core.service;

import javax.inject.Inject;

import br.com.identity.core.entity.Identity;
import br.com.identity.core.repository.IdentityRepository;

public class CreateIdentityService {
	
	@Inject
	IdentityRepository repository;
	
	public void create(String email) {
		Identity identity = new Identity();
		identity.setEmail(email);
		
		repository.save(identity);
	}
}
