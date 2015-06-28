package br.com.identity.validator;

import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

public class EmailValidatorTest {
	
	@InjectMocks
	private EmailValidator validator;
	
	@Before
	public void setUp() {
		initMocks(this);
	}
	
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
