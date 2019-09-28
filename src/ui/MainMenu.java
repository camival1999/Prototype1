package ui;

import java.io.Serializable;

import businessLogic.Engine;
import businessLogic.Reader;

public class MainMenu implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private static Engine starter;
	
	public static void main(String[] args) throws InterruptedException{
		starter = new Engine();
		starter.run();
		
			//int selection=0;
			//boolean exit = false;			
			//Reader reader = new Reader();
			
		LoginMenu lg = new LoginMenu(starter);	
		lg.loginRun(starter);
		
		adminMenu();
		
		
	}

	public static void adminMenu() {
		int selection = 0;
		boolean exit = false;
		Reader reader = new Reader();
		
		System.out.println("     ****** Bienvenido a la tienda VirtUNAL *****\n");
		
		while(!exit) {		
		selection = 0;
		
		System.out.println("                   Menú principal\n            *--------------------------*");
		System.out.println("Seleccione una opción:\n");
		System.out.println("1.- Ver clientes                  2.- Registrar nuevo cliente                  3.- Tomar pedido");
		System.out.println("4.- Eliminar cliente/pedido       5.- Salir");
		
			try{
				selection = Integer.parseInt(reader.next());
									
				if(selection>5 || selection<1)
					System.out.println("			Entrada no válida");
			
				if(selection==1)
					starter.getDatabase().printClients();
				else if(selection==2)
					starter.registro();
				else if(selection==3)
					starter.tomaPedido();
				else if(selection==4)
					starter.eliminar();
				else if(selection==5)
					exit = true;
			
			}catch(NumberFormatException e) {
				System.out.println("			Entrada no válida");
			}
	
		}	
		starter.end();
		System.out.println("			Hasta pronto!");
		
		
	}
	

	public static Engine getEngine() {
		return starter;
	}
}
