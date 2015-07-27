package br.com.identity.ws;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.com.identity.core.service.CreateIdentityService;
import br.com.identity.validator.EmailValidator;

@WebService
@Stateless
public class CreateWebService {
	
	@Inject
	private CreateIdentityService createIdentity;
	
	@Inject
	private EmailValidator emailValidator;
	
	@WebMethod
	public void create(@WebParam(name="email")String email) {
		emailValidator.validate(email);
		
		createIdentity.create(email);
	}

}
