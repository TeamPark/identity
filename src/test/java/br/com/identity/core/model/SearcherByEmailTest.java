package br.com.identity.core.model;

import static br.com.identity.util.RandomUtils.getRandomLong;
import static br.com.identity.util.RandomUtils.getRandomString;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import br.com.identity.core.dto.IdentityDTO;
import br.com.identity.core.repository.IdentityRepository;

public class SearcherByEmailTest extends SampleBaseTestCase {
	
	@InjectMocks
	private SearcherByEmail searcher;
	
	@Mock
	private IdentityRepository repository;
	
	@Test
	public void shouldSearchIdentityByEmail() {
		Long id = getRandomLong();
		String email = getRandomString();
		Identity identity = new Identity(id, email);
		
		when(repository.findByEmail(email)).thenReturn(identity);
		
		IdentityDTO result = searcher.search(email);
		
		assertNotNull(identity);
		assertEquals(id, result.getId());
		assertEquals(email, result.getEmail());
	}

}
