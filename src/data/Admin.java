package data;

public class Admin extends Usuario {

	private static final long serialVersionUID = 1L;
		
		
	public Admin() {
		this.id = 0;
		this.name = "defaultName defaultSurname";
		this.username = "default";
		this.password = "123";
	}
	
	public Admin (int id, String name, String username, String password) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
	}
	
	
	
	
	public void viewClients() {
			
	}
	
	public void createOrder() {
		
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Id Admin: " + id + "\nNombre: " + name;
	}
}


