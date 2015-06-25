package br.com.identity.core.model;

import br.com.identity.core.dto.IdentityDTO;
import br.com.identity.core.repository.IdentityRepository;

public class SearcherByEmail implements Searcher {
	
//	@Inject
//	private IdentityRepository repository;
	
	private String email;
	
	public SearcherByEmail(String email) {
		super();
		this.email = email;
	}

	@Override
	public IdentityDTO search() {
		
		final IdentityRepository repository = new IdentityRepository();
		
		final Identity identity = repository.findByEmail(this.email);
		
		return convertModelToDTO(identity);
	}

	private IdentityDTO convertModelToDTO(final Identity identity) {
		return new IdentityDTO(identity.getId(), identity.getEmail());
	}
}