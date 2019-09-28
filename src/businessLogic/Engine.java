package businessLogic;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;

import data.Admin;
import data.Cliente;
import data.DB;
import data.Pedido;

public class Engine implements Serializable{

	private static final long serialVersionUID = 1L;
		private static  DB database;
		private boolean admin = false;
		private boolean client = false;
		private boolean contains = false;
		private int index = -1;
		
	public void run() throws InterruptedException {
			Engine.database = new DB();
			businessLogic.DataLoader.confirmClientDataBase(Engine.database);
			businessLogic.DataLoader.confirmAdminDataBase(Engine.database);
		}
		
		public void end()  {
			File clients = new File("ClientesDB.dat");
			businessLogic.DataLoader.saveClients(clients,Engine.database);
			File admins = new File("AdminsDB.dat");
			businessLogic.DataLoader.saveAdmins(admins,Engine.database);
		}
		
		public void login() {
			Reader rdLogin = new Reader();
			Reader rdLoginInt = new Reader();
			int selection = 0;
			String username = null;
			String password = null;
			
			System.out.println("Qué tipo de usuario va a iniciar sesión?\n1.-Administrador         2.-Cliente");
				selection = rdLoginInt.nextInt();
				
			System.out.println("Introduzca su usuario:");
				username = rdLogin.nextLine();
			System.out.println("Introduzca su contraseña:");
				password = rdLogin.nextLine();
			
				if(selection == 1) {
					int counter = 0;
					for(Admin a : database.getAdminBase()) {
						if(a.getUsername().equals(username)) {
							if(a.getPassword().equals(password)) {
								admin = true;
							}
						}
						counter++;
						if(counter == database.getAdminBase().size() && admin==false)
							System.out.println("Usuario o contraseña incorrectos. ");
					}
							
				}else if(selection ==2) {
					int counter = 0;
						for(Cliente c : database.getClientBase()) {
							if(c.getUsername().equals(username)) {
								if(c.getPassword().equals(password)) {
									client = true;
								}else
									System.out.println("Contraseña incorrecta");
							}
							counter++;
								if(counter == database.getAdminBase().size())
									System.out.println("Usuario no encontrado.");
						}
					
				}else
					System.out.println("Entrada inválida");
					
		}
			

		
		
		public  void registro() {
			Reader rdRegister = new Reader();
			Reader rdRegisterInt = new Reader();
			int selection = 0;
			int id = -1;
			
			System.out.println("Que tipo de usuario desea registrar?\n1.-Administrador         2.-Cliente");
			selection = rdRegisterInt.nextInt();
			
			if(selection ==1) {
				
				System.out.println("Introduzca el nombre y apellido del administrador:");
				
				String name = rdRegister.nextLine();
				
				
					try {
						System.out.println("Introduzca la identificacion numérica del administrador:");
							id = rdRegister.nextInt();
						System.out.println("Introduzca su usuario:");
							String username = rdRegister.next();
						System.out.println("Introduzca su contraseña:");
							String password = rdRegister.next();
							
						Admin admin = new Admin(id,name,username,password);
						try {
							Engine.database.saveAdmin(admin);
							System.out.println("Administrador guardado exitosamente!");
						}catch(RuntimeException e) {
							System.out.println("No se puedo guardar el usuario, intente de nuevo");
						}
					}catch(InputMismatchException e) {
						System.out.println("Identificación no válida");
					}
				
				
			}
			else if(selection == 2 ) {
			
				System.out.println("Introduzca el nombre y apellido del cliente:");
				String name = rdRegister.nextLine();
				
					try {
						System.out.println("Introduzca la identificacion numérica del cliente:");
							id = rdRegister.nextInt();	
						System.out.println("Introduzca su usuario:");
							String username = rdRegister.next();
						System.out.println("Introduzca su contraseña:");
							String password = rdRegister.next();	
						Cliente client = new Cliente(id,name,username,password);
						try {
							Engine.database.saveClient(client);
							System.out.println("Cliente guardado exitosamente!");
						}catch(RuntimeException e) {
							System.out.println("No se puedo guardar el cliente, intente de nuevo");
						}
					}catch(InputMismatchException e) {
						System.out.println("Identificación no válida");
					}
			}else
				System.out.println("Entrada inválida");
		}
		
		
		public  void tomaPedido() {
			Reader rdOrder = new Reader();
				Pedido order = new Pedido();
					String orderStr="";
					Reader rdInt = new Reader();
					
			System.out.println("Introduzca el ID del cliente: ");			
				Integer id = Integer.parseInt(rdInt.next());
					
			System.out.println("Introduzca el pedido en el formato *Item Cantidad*. Si solo es una unidad basta con poner solo *Item*. Escriba *fin* para terminar la toma del pedido");		
				orderStr = rdOrder.nextLowercase();
			
			while(orderStr.equals("fin")==false) {
				order.addContent(orderStr);
					orderStr = rdOrder.nextLowercase();
			}		
			database.updateClient(id, order);
		}

		
		public void eliminar() {
			Reader rdElim = new Reader();
			ArrayList<Cliente> temp = new ArrayList<Cliente>();
			temp = Engine.database.getClientBase();
			
			System.out.println("Introduzca el ID del cliente: ");
			Integer id = rdElim.nextInt();
					
			for(Cliente c : Engine.database.getClientBase()) {
				if(c.getId() == id) {
					 contains = true;
					  index = Engine.database.getClientBase().indexOf(c);
				}else {
					 contains = false;
					 index = -1;
				}
			}
			
			if(contains) {
				System.out.println("1.-Eliminar cliente          2.- Eliminar pedido");
			
				int select = rdElim.nextInt();
				
					if(select==1) {
						try {
							temp.remove(index);
							System.out.println("Cliente eliminado exitosamente!");
						}catch(NullPointerException e) {
							System.out.println("Error al eliminar cliente. Identificación no válida");
						}
					}else if(select == 2) {
						temp.get(index).deleteOrder();
						System.out.println("Pedido eliminado exitosamente!");
					}
				Engine.database.setClientBase(temp);
			}else
				System.out.println("Entrada no válida. ID incorrecto o el cliente no existe");
		}		

		
		
		public DB getDatabase() {
			return Engine.database;
		}

		
		public boolean getAdminState() {
			return admin;
		}

		
		
		public boolean getClientState() {
			return client;
		}
}
