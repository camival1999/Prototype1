package data;

public class Cliente extends Usuario {

	
	private static final long serialVersionUID = 1L;
	private Pedido shoppingCart;
		
		
	public Cliente() {
		this.id = 0;
		this.name = "defaultName defaultSurname";
		this.username = "default";
		this.password = "123";
		this.shoppingCart = new Pedido();
	}
	
	public Cliente (int id, String name, String username, String password) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
	}
	
	public Cliente (int id, String name, String username, String password, Pedido order) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.shoppingCart = order;
	}	
	
	
	
	public void assignOrder(Pedido newOrder) {
		
		newOrder.setId(this.getId());
		
		if(this.shoppingCart==null)
			this.setShoppingCart(newOrder);
		else 
			System.out.println("No se puedo crear. El cliente ya posee un pedido en curso!");
	}
	
	public void deleteOrder () {
		this.shoppingCart = null;
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

	public Pedido getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(Pedido order) {
		this.shoppingCart = order;
	}

	@Override
	public String toString() {
		return "Id cliente: " + id + "\nNombre: " + name + "\nUsuario: " + username + "\nPedido: " + shoppingCart;
	}
}
