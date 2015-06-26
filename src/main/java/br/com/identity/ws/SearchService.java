package br.com.identity.ws;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.com.identity.core.dto.IdentityDTO;
import br.com.identity.core.model.ByEmail;
import br.com.identity.core.model.Searcher;

@WebService
public class SearchService {
	
	@Inject
	@ByEmail
	private Searcher searcher;
	
	@WebMethod
	public IdentityDTO search(@WebParam(name="email")String email) {
		validate(email);
		
		return searcher.search(email);
    }

	private void validate(String email) {
		if (email == null) {
			throw new IllegalArgumentException("email inválido");
		}
	}
}