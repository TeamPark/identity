package br.com.identity.core.model;

import br.com.identity.core.dto.IdentityDTO;

public interface Searcher {

	IdentityDTO search(String value);
	
}