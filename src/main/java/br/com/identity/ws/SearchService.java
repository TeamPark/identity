package br.com.identity.ws;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.com.identity.core.dto.IdentityDTO;
import br.com.identity.core.model.ByEmail;
import br.com.identity.core.model.Searcher;
import br.com.identity.validator.EmailValidator;

@WebService
public class SearchService {
	
	@Inject
	@ByEmail
	private Searcher searcher;
	
	@Inject
	private EmailValidator emailValidator;
	
	@WebMethod
	public IdentityDTO search(@WebParam(name="email")String email) {
		emailValidator.validate(email);
		
		return searcher.search(email);
    }	
}
