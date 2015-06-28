package br.com.identity.core.model;

import static br.com.identity.util.RandomUtils.getRandomLong;
import static br.com.identity.util.RandomUtils.getRandomString;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import br.com.identity.core.dto.IdentityDTO;
import br.com.identity.core.repository.IdentityRepository;

public class SearcherByEmailTest {
	
	@InjectMocks
	private SearcherByEmail searcher;
	
	@Mock
	private IdentityRepository repository;
	
	@Before
	public void setUp() {
		initMocks(this);
	}
	
	@Test
	public void shouldFindIdentityByEmailAndReturnAIdentityDTO() {
		Long id = getRandomLong();
		String email = getRandomString();
		Identity identity = new Identity(id, email);
		
		when(repository.findByEmail(email)).thenReturn(identity);
		
		IdentityDTO result = searcher.search(email);
		
		assertEquals(id, result.getId());
		assertEquals(email, result.getEmail());
	}

}
