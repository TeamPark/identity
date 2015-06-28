package br.com.identity.core.model;

import javax.inject.Inject;

import br.com.identity.core.dto.IdentityDTO;
import br.com.identity.core.repository.IdentityRepository;

@ByEmail
public class SearcherByEmail implements Searcher {
	
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
