package br.com.identity.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.com.identity.core.dto.IdentityDTO;
import br.com.identity.core.model.Searcher;
import br.com.identity.core.model.SearcherByEmail;

@WebService
public class SearchService {

	@WebMethod
	public IdentityDTO search(@WebParam(name="email")String email) {
		
		validate(email);
		
		final Searcher searcher = new SearcherByEmail(email);
		
		return searcher.search();
    }

	private void validate(String email) {
		
		if (email == null) {
			throw new IllegalArgumentException("email inválido");
		}
	}
}