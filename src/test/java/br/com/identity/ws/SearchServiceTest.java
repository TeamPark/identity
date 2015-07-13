package br.com.identity.ws;

import static br.com.identity.util.RandomUtils.getRandomString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import br.com.identity.core.model.Searcher;
import br.com.identity.util.SampleBaseTest;
import br.com.identity.validator.EmailValidator;


public class SearchServiceTest extends SampleBaseTest {
	
	@InjectMocks
	private SearchService service;
	
	@Mock
	private Searcher searcher;
	
	@Mock
	private EmailValidator emailValidator;
	
	@Test
	public void shouldSearchByEmail() {
		String email = getRandomString();
		
		service.search(email);
		
		verify(emailValidator).validate(email);
		verify(searcher).search(email);
	}
	
	@Test
	public void shouldNotSearchByEmailWhenEmailIsInvalid() {
		String invalidEmail = getRandomString();
		
		doThrow(new IllegalArgumentException()).when(emailValidator).validate(invalidEmail);
		
		try {
			service.search(invalidEmail);
		} catch (IllegalArgumentException e) {
			//just to test
		}
		
		verify(searcher, never()).search(invalidEmail);
	}
}
