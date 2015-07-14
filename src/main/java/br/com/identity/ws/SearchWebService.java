package br.com.identity.ws;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.com.identity.annotation.ByEmail;
import br.com.identity.core.service.SearcherService;
import br.com.identity.dto.IdentityDTO;
import br.com.identity.validator.EmailValidator;

@WebService
public class SearchWebService {
	
	@Inject
	@ByEmail
	private SearcherService searcher;
	
	@Inject
	private EmailValidator emailValidator;
	
	@WebMethod
	public IdentityDTO search(@WebParam(name="email")String email) {
		emailValidator.validate(email);
		
		return searcher.search(email);
    }	
}
