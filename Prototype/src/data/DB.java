package data;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.Map.Entry;


public class DB implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private Hashtable<Integer, Cliente> clientBase;
	
	public DB() {
		this.clientBase = new Hashtable<Integer, Cliente>();
	}
	
	public void saveClient(Cliente u) {											//Guarda el cliente en la base de datos	
		if(!clientBase.containsKey(u.getId()))
		clientBase.put(u.getId(),u);
		else
			throw new RuntimeException();
	}

	public void updateClient(Integer id, Pedido order) {						//actualiza la informacion del cliente en la base de datos
		clientBase.get(id).assignOrder(order);
	}
	
	public void print() {														//Imprime los usuarios registrados actuales
		if(this.clientBase.isEmpty()) {
			System.out.println("No hay clientes!");
		}else {
		 StringBuilder builder = new StringBuilder();
		for ( Entry<Integer, Cliente> entry : this.clientBase.entrySet()){
			builder.append("\n---------*---------\n");
	        builder.append(entry.getValue().toString());        
	    }

	   System.out.println(builder.toString());
		}
	}
	
	public Hashtable<Integer, Cliente> getClientBase() {
		return clientBase;
	}
	
	public void setClientBase(Hashtable<Integer, Cliente> database) {
		this.clientBase = database;
	}

	
	

}
