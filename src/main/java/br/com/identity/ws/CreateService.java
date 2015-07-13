package br.com.identity.ws;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.com.identity.core.model.CreateIdentity;
import br.com.identity.validator.EmailValidator;

@WebService
public class CreateService {
	
	@Inject
	private CreateIdentity createIdentity;
	
	@Inject
	private EmailValidator emailValidator;
	
	@WebMethod
	public void create(@WebParam(name="email")String email) {
		emailValidator.validate(email);
		
		createIdentity.create(email);
	}

}
