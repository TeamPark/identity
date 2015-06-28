package br.com.identity.core.model;

public class Identity {
	
	private Long id;
	private String email;
	
	public Identity(Long id, String email) {
		this.id = id;
		this.email = email;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}
}
