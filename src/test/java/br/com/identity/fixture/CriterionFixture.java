package br.com.identity.fixture;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Criterion;
import org.hibernate.engine.spi.TypedValue;

public class CriterionFixture {
	
	private Criterion criterion = new Criterion() {
		private static final long serialVersionUID = 1L;

		@Override
		public String toSqlString(Criteria arg0, CriteriaQuery arg1) throws HibernateException {
			return null;
		}
		
		@Override
		public TypedValue[] getTypedValues(Criteria arg0, CriteriaQuery arg1) throws HibernateException {
			return null;
		}
	};
	
	public static CriterionFixture get() {
		return new CriterionFixture();
	}
	
	public Criterion build() {
		return criterion;
	}

	public List<Criterion> buildList(int size) {
		List<Criterion> list = new ArrayList<Criterion>();
		for (int i = 0; i < size; i++) {
			list.add(build());
		}
		return list;
	}
}
