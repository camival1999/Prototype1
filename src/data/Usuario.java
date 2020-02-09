package data;

import java.io.Serializable;

public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	protected int id;
	protected String name;
	protected String username;
	protected String password;
	
	public Usuario() {
		this.id = 0;
		this.name = "defaultName defaultSurname";
		
	}
	
	public Usuario (int id, String name) {
		this.id = id;
		this.name = name;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
	

}
