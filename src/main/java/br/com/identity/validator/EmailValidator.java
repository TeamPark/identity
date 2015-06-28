package br.com.identity.validator;

public class EmailValidator {

	public void validate(String email) {
		isNotBlank(email);
	}
	
	private void isNotBlank(String email) {
		if (email == null || email.isEmpty()) {
			throw new IllegalArgumentException("invalid email");
		}
	}
}
