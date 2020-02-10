package data;

import businessLogic.DataLoader;
import java.io.Serializable;
import java.util.ArrayList;


public class DB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Cliente> clientBase;
	private ArrayList<Admin> adminBase;
        private ArrayList<Producto> inventoryBase;

	DataLoader dl;
	public DB() {
		this.clientBase = new ArrayList<Cliente>();
		this.adminBase = new ArrayList<Admin>();
                this.inventoryBase = new ArrayList<Producto>();
                
	}
	
	
	
	public void saveAdmin(Admin a) {											//Guarda el admin en la base de datos	
		/*
		int count = 1;
		for(Admin ao : adminBase ) {
			if(ao.getId()==a.getId()|| ao.getUsername() == a.getUsername()) {
				System.out.println("de verdad no se guard�");
				throw new RuntimeException();
			}
				
				
			else if(count == adminBase.size()) {
					adminBase.add(a);
					System.out.println("de verdad se guard�");
			}else {
				count++;
				System.out.println("la cagaste prro");
			}
		}
		*/
		
		if(!adminBase.contains(a))
			adminBase.add(a);
			else
				throw new RuntimeException();
            
	}
	
	public void saveClient(Cliente u) {											//Guarda el cliente en la base de datos	
		/*
		int count = 1;
		for(Cliente c : clientBase) {
		
			if(c.getId()==u.getId()|| c.getUsername() == u.getUsername())
				throw new RuntimeException();
				
			else if(count == clientBase.size())
				clientBase.add(u);
			else
				count++;			
		}
		*/
		if(!clientBase.contains(u))
			clientBase.add(u);
			else
				throw new RuntimeException();
	}
        
	public void saveProducto(Producto p){
            System.out.println("123324");
                if(!inventoryBase.contains(p) )
                   inventoryBase.add(p);
                else
                  throw new RuntimeException();
        }
        
	public void updateClient(Cliente c, Pedido order) {							//actualiza la informacion del cliente en la base de datos
		int index = clientBase.indexOf(c);
		clientBase.get(index).assignOrder(order);
	}
	
	public void printAdmins() {													//Imprime los administradores registrados actuales
		if(this.adminBase.isEmpty()) {
			System.out.println("No hay administradores!");
		}else {
		 StringBuilder builder = new StringBuilder();
		for ( Admin a : this.adminBase){
			builder.append("\n---------*---------\n");
	        builder.append(a.toString());        
	    }

	   System.out.println(builder.toString());
		}
	}
	
	public void printClients() {												//Imprime los usuarios registrados actuales
		if(this.clientBase.isEmpty()) {
			System.out.println("No hay clientes!");
		}else {
		 StringBuilder builder = new StringBuilder();
		 for(Cliente c: clientBase) {
		//for ( Entry<Integer, Cliente> entry : this.clientBase.entrySet()){
			builder.append("\n---------*---------\n");
			builder.append(c.toString());
	        //builder.append(entry.getValue().toString());        
	    }

	   System.out.println(builder.toString());
		}
	}
	
	public void printOrders() {
		
		for(Cliente c : clientBase) {
			System.out.println("No. clientes: " + clientBase.size());
			System.out.println(c.getShoppingCart());
		}
		
	}
	
	
	
	public ArrayList<Cliente> getClientBase() {
		return clientBase;
	}
	
	public void setClientBase(ArrayList<Cliente> database) {
		this.clientBase = database;
	}
	
	public ArrayList<Admin> getAdminBase() {
		return adminBase;
	}
	
	public void setAdminBase(ArrayList<Admin> adminBase) {
		this.adminBase = adminBase;
	}
        
        public ArrayList<Producto> getInventoryBase() {
            return inventoryBase;
        }

        public void setInventoryBase(ArrayList<Producto> inventoryBase) {
            this.inventoryBase = inventoryBase;
        }
        
}
