package ui;

import businessLogic.Engine;
import businessLogic.Reader;

public class LoginMenu {
		private boolean admin = false;
		private boolean client = false;
		private boolean exit = false;
	
	
	public LoginMenu(Engine e) {
		
			
	}
	
	public void loginRun(Engine e) {
		
		int selection = 0;
		System.out.println("Bienvenido a la pantalla de inicio de sesión.\nQué desea hacer?");
		System.out.println("1.- Iniciar sesión          2.-Registrarse          3.- Salir");
		Reader rd = new Reader();
		selection = rd.nextInt();
		
			if(selection == 1)
				e.login();
			else if(selection ==2) 
				e.registro();
			else if(selection ==3) {
				exit = true;
			}
		this.admin = e.getAdminState();
		this.client = e.getClientState();
	}

	public boolean getExitSate() {
		return exit;
	}
	public boolean getAdminState() {
		return admin;
	}
	public boolean getClientState() {
		return client;
	}
}
