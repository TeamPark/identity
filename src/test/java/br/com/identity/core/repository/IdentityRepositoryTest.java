package br.com.identity.core.repository;

import static br.com.identity.util.RandomUtils.getRandomString;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import br.com.identity.core.entity.Identity;
import br.com.identity.util.SampleBaseTest;

public class IdentityRepositoryTest extends SampleBaseTest {
	
	@InjectMocks
	private IdentityRepository repository;
	
	@Mock
	private EntityManager entityManager;
	
	@Mock
	private Session session;
	
	@Mock
	private Criteria criteria;
	
	@Test
	public void shouldFindIdentityByEmail() {
		String email = getRandomString();
		Identity identity = new Identity();
		identity.setEmail(email);
		List<Identity> identities = Arrays.asList(identity);
		
		when(entityManager.getDelegate()).thenReturn(session);
        when(session.createCriteria(Identity.class)).thenReturn(criteria);
		when(criteria.list()).thenReturn(identities);
		
		Identity result = repository.findByEmail(email);
		
		assertEquals(email, result.getEmail());
	}

}
