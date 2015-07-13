package br.com.identity.core.repository.entity;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="identity")
public class IdentityEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="identity_id_seq", sequenceName="identity_id_seq", allocationSize=1)
	@GeneratedValue(strategy= SEQUENCE, generator="identity_id_seq")
	private Long id;
	private String email;
	
	public IdentityEntity() {
		
	}
	
	public IdentityEntity(String email) {
		this.email = email;
	}
	
	public IdentityEntity(Long id, String email) {
		this.id = id;
		this.email = email;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
