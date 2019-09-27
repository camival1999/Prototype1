package data;

import java.io.Serializable;

public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private Pedido order;
		
		
	public Cliente() {
		this.id = 0;
		this.name = "defaultName defaultSurname";
		this.order = new Pedido();
	}
	
	public Cliente (int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Cliente (int id, String name, Pedido order) {
		this.id = id;
		this.name = name;
		this.order = order;
	}	
	
	public void assignOrder(Pedido newOrder) {
		
		newOrder.setId(this.getId());
		
		if(this.order==null)
			this.setOrder(newOrder);
		else 
			System.out.println("No se puedo crear. El cliente ya posee un pedido en curso!");
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

	public Pedido getOrder() {
		return order;
	}

	public void setOrder(Pedido order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Id cliente: " + id + "\nNombre: " + name + "\nPedido: " + order;
	}
}
