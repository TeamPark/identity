package br.com.identity.core.service;

import javax.inject.Inject;

import br.com.identity.annotation.ByEmail;
import br.com.identity.core.entity.Identity;
import br.com.identity.core.repository.IdentityRepository;
import br.com.identity.dto.IdentityDTO;

@ByEmail
public class SearcherByEmailService implements SearcherService {
	
	@Inject
	private IdentityRepository repository;
	
	@Override
	public IdentityDTO search(String email) {
		final Identity identity = repository.findByEmail(email);
		
		return convertModelToDTO(identity);
	}

	private IdentityDTO convertModelToDTO(final Identity identity) {
		return new IdentityDTO(identity.getId(), identity.getEmail());
	}
}
