package ui;

import businessLogic.Engine;
import businessLogic.Reader;
import interface_prototype.Login;
import interface_prototype.usersManager;

public class LoginMenu {
		private boolean admin;
		private boolean client;
		private boolean exit;
	
	public LoginMenu(Engine e) {
		this.admin = false;
		this.client = false;
		this.exit = false;
	}
	
	
	
	public void loginRun(Engine e) {
		new usersManager().setVisible(true);
		int selection = 0;
		System.out.println("Bienvenido a la pantalla de inicio de sesi�n.\nQu� desea hacer?");
		System.out.println("1.- Iniciar sesi�n          2.-Registrarse          3.- Salir");
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
