package ui;

import businessLogic.Engine;
import businessLogic.Reader;

public class LoginMenu {
		private boolean admin = false;
		private boolean client = false;
	
	
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
			if(selection ==2) 
				e.registro();		
			
		
		
	}

}
