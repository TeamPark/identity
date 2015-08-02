package br.com.identity.core.repository;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

public abstract class Repository <T> {
	
	@PersistenceContext(unitName = "teampark")
	private EntityManager entityManager;
	
	private final Class<T> persistentClass;
	
	@SuppressWarnings("unchecked")
	protected Repository() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	protected Session getSession() {
		return (Session) entityManager.getDelegate();
	}
	
	public void save(T entity) {
		entityManager.persist(entity);
	}
		
	protected Criteria createCriteria(Criterion... criterions) {
		Criteria criteria = getSession().createCriteria(persistentClass);
		for (Criterion criterion : criterions) {
			criteria.add(criterion);
		}
		return criteria;
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> findByCriterions(Criterion... criterions) {
		Criteria criteria = createCriteria(criterions);
		return criteria.list();
	}
	
	protected T findFirstByCriterions(Criterion... criterions) {
		List<T> list = findByCriterions(criterions);
		return (!list.isEmpty()) ? list.iterator().next() : null;
	}

}
