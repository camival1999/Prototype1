package ui;

import java.io.Serializable;

import businessLogic.Engine;
import businessLogic.Reader;
import interface_prototype.Autor;
import interface_prototype.Inventario;
import interface_prototype.InventarioAdmin;
import interface_prototype.Login;

public class MainMenu implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private static Engine shop;
	
	public static void main(String[] args) throws InterruptedException{	
		shop = new Engine(); 
                //shop.testInventario(); test de tiempos
		shop.run();
		//LoginMenu lg = new LoginMenu(shop);
		boolean exit = false;
		new Inventario().setVisible(true);
                
                shop.end();
	}

	public static void adminMenu(Engine en) {
		int selection = 0;
		boolean exit = false;
		Reader reader = new Reader();
		
		System.out.println("     ****** Bienvenido a la tienda VirtUNAL *****\n");
		
		while(!exit) {		
			selection = 0;
		
			System.out.println("                   Men� principal\n            *--------------------------*");
			System.out.println("Seleccione una opci�n:\n");
			System.out.println("1.- Ver clientes                      2.- Ver administradores                  3.- Ver pedidos en curso");
			System.out.println("4.- Eliminar clientes o pedidos 	  5.- Cerrar sesi�n");
		
			try{
				selection = Integer.parseInt(reader.next());
									
				if(selection>5 || selection<1)
					System.out.println("			Entrada no v�lida");
			
				if(selection==1)
					shop.getDatabase().printClients();
				else if(selection==2)
					shop.getDatabase().printAdmins();
				else if(selection==3) {
					shop.getDatabase().printOrders();
				}else if(selection==4)
					shop.eliminar();
				else if(selection==5) {
					exit = true;
					en.setAdminState(false);	
				}
			}catch(NumberFormatException e) {
				System.out.println("			Entrada no v�lida");
			}
	
		}	
		shop.end();
		System.out.println("			Se ha cerrado sesi�n");
		
		
	}
	
	public static void clientMenu(Engine en) {
		int selection = 0;
		boolean exit = false;
		Reader reader = new Reader();
                
		System.out.println("     ****** Bienvenido a la tienda VirtUNAL *****\n");
		
		while(!exit) {		
		selection = 0;
		
		System.out.println("                   Men� principal\n            *--------------------------*");
		System.out.println("Seleccione una opci�n:\n");
		System.out.println("1.- Ver productos/Realizar pedido                  2.- Ver pedido en curso           3.- Cerrar sesi�n");
	
		
			try{
				selection = Integer.parseInt(reader.next());
									
				if(selection>5 || selection<1)
					System.out.println("			Entrada no v�lida");
			
				if(selection==1)
					shop.tomaPedido();
				else if(selection==2)
					System.out.println(shop.getClient().getShoppingCart());
				else if(selection==3) {
					exit = true;
					en.setClientState(false);
				}
			}catch(NumberFormatException e) {
				System.out.println("			Entrada no v�lida");
			}
	
		}	
		shop.end();
		System.out.println("			Se ha cerrado sesi�n");
		
		
	}
	
	
	
	public static Engine getEngine() {
		return shop;
	}
}
