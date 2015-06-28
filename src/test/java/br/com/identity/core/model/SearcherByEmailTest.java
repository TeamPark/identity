package br.com.identity.core.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import br.com.identity.core.dto.IdentityDTO;
import br.com.identity.core.repository.IdentityRepository;

public class SearcherByEmailTest extends SampleBaseTestCase {

	@InjectMocks
	SearcherByEmail searcher;
	
	@Mock
	IdentityRepository repository;
	
	@Test
	public void shouldSearchByEmail() {
		
		final String email = "teampark@gmail.com";
		final Long id = 1234567L;
		
		when(repository.findByEmail(email)).thenReturn(new Identity(id, email));
		
		IdentityDTO identity = searcher.search(email);
		
		assertNotNull(identity);
		assertEquals(email, identity.getEmail());
		assertEquals(id, identity.getId());
	}
}