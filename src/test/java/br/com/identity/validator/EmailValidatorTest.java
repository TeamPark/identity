package br.com.identity.validator;

import org.junit.Test;
import org.mockito.InjectMocks;

import br.com.identity.util.SampleBaseTest;

public class EmailValidatorTest extends SampleBaseTest {
	
	@InjectMocks
	private EmailValidator validator;
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionWhenEmailIsNull() {
		String email = null;

		validator.validate(email);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionWhenEmailIsBlank() {
		String email = "";

		validator.validate(email);
	}
}
