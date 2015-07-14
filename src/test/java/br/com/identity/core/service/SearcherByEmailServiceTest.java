package br.com.identity.core.service;

import static br.com.identity.util.RandomUtils.getRandomLong;
import static br.com.identity.util.RandomUtils.getRandomString;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import br.com.identity.core.entity.Identity;
import br.com.identity.core.repository.IdentityRepository;
import br.com.identity.core.service.SearcherByEmailService;
import br.com.identity.dto.IdentityDTO;
import br.com.identity.util.SampleBaseTest;

public class SearcherByEmailServiceTest extends SampleBaseTest {
	
	@InjectMocks
	private SearcherByEmailService searcher;
	
	@Mock
	private IdentityRepository repository;
	
	@Test
	public void shouldSearchIdentityByEmail() {
		Long id = getRandomLong();
		String email = getRandomString();
		Identity identity = new Identity();
		identity.setId(id);
		identity.setEmail(email);
		
		when(repository.findByEmail(email)).thenReturn(identity);
		
		IdentityDTO result = searcher.search(email);
		
		assertNotNull(identity);
		assertEquals(id, result.getId());
		assertEquals(email, result.getEmail());
	}
}
