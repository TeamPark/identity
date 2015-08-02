package br.com.identity.core.repository;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import br.com.identity.core.entity.Identity;
import br.com.identity.fixture.CriterionFixture;
import br.com.identity.util.SampleBaseTest;

public class RepositoryTest extends SampleBaseTest {

	@InjectMocks
	private Repository<Identity> dao = createDao();

	@Mock
	private EntityManager entityManager;
	
	@Mock
	private Session session;
	
	@Mock
	private Criteria criteria;

	private Repository<Identity> createDao() {
		return new Repository<Identity>() {
		};
	}
	
	@Test
	public void shouldSaveEntityUsingEntityManager() {
		Identity entity = new Identity();
		
		dao.save(entity);
		
		verify(entityManager).persist(entity);
	}
	
	@Test
	public void shouldCreateCriteriaWithCriterionsInformed() {
		Criterion criterion1 = CriterionFixture.get().build();
		Criterion criterion2 = CriterionFixture.get().build();
		Criterion criterion3 = CriterionFixture.get().build();
		
        when(entityManager.getDelegate()).thenReturn(session);
        when(session.createCriteria(Identity.class)).thenReturn(criteria);
        
		dao.createCriteria(criterion1, criterion2, criterion3);
		
		verify(criteria).add(criterion1);
		verify(criteria).add(criterion2);
		verify(criteria).add(criterion3);
	}
	
	@Test
	public void shoulFindEntitiesMatchesWithInformedCriterions() {
		Criterion criterion1 = CriterionFixture.get().build();
		Criterion criterion2 = CriterionFixture.get().build();
		Criterion criterion3 = CriterionFixture.get().build();
		
		when(entityManager.getDelegate()).thenReturn(session);
        when(session.createCriteria(Identity.class)).thenReturn(criteria);
		
		dao.findByCriterions(criterion1, criterion2, criterion3);
		
		verify(criteria).add(criterion1);
		verify(criteria).add(criterion2);
		verify(criteria).add(criterion3);
		verify(criteria).list();
	}
	
	@Test
	public void shouldReturnFirstResultMatchesWithInformedCriterions() {
		Criterion criterion = CriterionFixture.get().build();
		Identity identity1 = new Identity();
		Identity identity2 = new Identity();
		Identity identity3 = new Identity();
		List<Identity> queryResult = asList(identity1, identity2, identity3);
		
		when(entityManager.getDelegate()).thenReturn(session);
        when(session.createCriteria(Identity.class)).thenReturn(criteria);
		when(criteria.list()).thenReturn(queryResult);
		
		Identity result = dao.findFirstByCriterions(criterion);
		
		assertEquals(identity1, result);
	}
	
	@Test
	public void shouldReturnNullWhenNoResultMatchesWithInformedCriterions() {
		Criterion criterion = CriterionFixture.get().build();
		List<Identity> queryResult = new ArrayList<>();
		
		when(entityManager.getDelegate()).thenReturn(session);
        when(session.createCriteria(Identity.class)).thenReturn(criteria);
		when(criteria.list()).thenReturn(queryResult);
		
		Identity result = dao.findFirstByCriterions(criterion);
		
		assertNull(result);
	}

}
