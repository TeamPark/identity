package br.com.identity.core.repository;

import static org.hibernate.criterion.Restrictions.eq;

import br.com.identity.core.entity.Identity;

public class IdentityRepository extends Repository<Identity> {
	
	public Identity findByEmail(String email) {
		return findFirstByCriterions(eq("email", email));
	}
	
}
