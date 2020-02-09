package businessLogic;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;

import data.Admin;
import data.Cliente;
import data.DB;
import data.Pedido;
import data.Producto;


public class Engine implements Serializable{

	private static final long serialVersionUID = 1L;
		private static DB database;
		private boolean adminLogin = false;
		private boolean clientLogin = false;
		private boolean contains = false;
		private int index = -1;
		private Cliente client;
		private Admin admin;
                private Producto p;
		
	public void run() throws InterruptedException {
			Engine.database = new DB();
			businessLogic.DataLoader.confirmClientDataBase(Engine.database);
			businessLogic.DataLoader.confirmAdminDataBase(Engine.database);
			businessLogic.DataLoader.confirmInventoryDataBase(Engine.database); 
                        //addInventory(2,15,"Blusa","Talla S","/images/blusa.png");
		}
		
	public void end()  {
			File clients = new File("ClientesDB.dat");
			businessLogic.DataLoader.saveClients(clients,Engine.database);
			File admins = new File("AdminsDB.dat");
			businessLogic.DataLoader.saveAdmins(admins,Engine.database);
                        File inventory = new File("InventoryDB.dat");
			businessLogic.DataLoader.saveInventory(inventory,Engine.database);
		}
		
	public void login() {
			Reader rdLogin = new Reader();
			Reader rdLoginInt = new Reader();
			int selection = 0;
			String username = null;
			String password = null;
			
			System.out.println("Qu� tipo de usuario va a iniciar sesi�n?\n1.-Administrador         2.-Cliente");
				selection = rdLoginInt.nextInt();
				
			System.out.println("Introduzca su usuario:");
				username = rdLogin.nextLine();
			System.out.println("Introduzca su contrase�a:");
				password = rdLogin.nextLine();
			
				if(selection == 1) {
					System.out.println("Entro a 1");
					int counter = 0;
					for(Admin a : Engine.database.getAdminBase()) {
						if(a.getUsername().equals(username)) {
							if(a.getPassword().equals(password)) {
								System.out.println("Se ha encontrado una coincidencia!");
								this.adminLogin = true;
								this.clientLogin = false;
								this.admin = a;
							}
						}
						counter++;
						if(counter == Engine.database.getAdminBase().size() && adminLogin==false)
							System.out.println("Usuario o contrase�a incorrectos. ");
					}
							
				}else if(selection ==2) {
					int counter = 0;
						for(Cliente c : Engine.database.getClientBase()) {
							if(c.getUsername().equals(username)) {
								if(c.getPassword().equals(password)) {
									this.clientLogin = true;
									this.adminLogin = false;
									this.client = c;
									System.out.println("Se ha ingresado exitosamente");
								}else
									System.out.println("Contrase�a incorrecta");
							}else
							counter++;
							
								if(counter == Engine.database.getAdminBase().size())
									System.out.println("Usuario no encontrado.");
						}
					
				}else {
					System.out.println("Entrada inv�lida");
					clientLogin = false;
					adminLogin = false;
				}
		}
                
	public boolean loginI(String username,String password) {
                    boolean flag = false;
                    for(Cliente c : Engine.database.getClientBase()) {
                        if(flag) break;
			if(c.getUsername().equals(username)) {
				if(c.getPassword().equals(password)) {
					this.clientLogin = true;
					this.adminLogin = false;
					this.client = c;
                                        flag = true;
				}
                        }
                    }
                    if(!this.adminLogin){
                        for(Admin a : Engine.database.getAdminBase()) {
                            if(flag) break;
				if(a.getUsername().equals(username)) {
					if(a.getPassword().equals(password)) {
                                            this.adminLogin = true;
                                            this.clientLogin = false;
                                            this.admin = a;
                                            flag = true;
                                            
                                        }
				}
			}
                    }
                     return flag;
                }
                
        public  void registroI(int id,String name,String username,String password ){
                try {
                    Cliente client = new Cliente(id,name,username,password);
                    Engine.database.saveClient(client);
                    System.out.println("Cliente guardado exitosamente!");
		}catch(RuntimeException e) {
                    System.out.println("No se puedo guardar el cliente, intente de nuevo");
		}
        }
                
        public  void registroA(int id,String name,String username,String password ){
                    try {
                        Admin admin = new Admin(id,name,username,password);
			Engine.database.saveAdmin(admin);
                        System.out.println("Admin guardado exitosamente!");
                    }catch(RuntimeException e) {
                        System.out.println("No se puedo guardar el admin, intente de nuevo");
                    }
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
						System.out.println("Introduzca la identificacion num�rica del administrador:");
							id = rdRegister.nextInt();
						System.out.println("Introduzca su usuario:");
							String username = rdRegister.next();
						System.out.println("Introduzca su contrase�a:");
							String password = rdRegister.next();
							
						Admin admin = new Admin(id,name,username,password);
						//try {
						Engine.database.saveAdmin(admin);
							System.out.println("Administrador guardado exitosamente!");
						//}catch(RuntimeException e) {
						//	System.out.println("No se puedo guardar el usuario, intente de nuevo");
						//}
					}catch(InputMismatchException e) {
						System.out.println("Identificaci�n no v�lida");
					}
				
				
			}
			else if(selection == 2 ) {
			
				System.out.println("Introduzca el nombre y apellido del cliente:");
				String name = rdRegister.nextLine();
				
					try {
						System.out.println("Introduzca la identificacion num�rica del cliente:");
							id = rdRegister.nextInt();	
						System.out.println("Introduzca su usuario:");
							String username = rdRegister.next();
						System.out.println("Introduzca su contrase�a:");
							String password = rdRegister.next();	
						Cliente client = new Cliente(id,name,username,password);
						try {
							Engine.database.saveClient(client);
							System.out.println("Cliente guardado exitosamente!");
						}catch(RuntimeException e) {
							System.out.println("No se puedo guardar el cliente, intente de nuevo");
						}
					}catch(InputMismatchException e) {
						System.out.println("Identificaci�n no v�lida");
					}
			}else
				System.out.println("Entrada inv�lida");
		}
		
	public  void tomaPedido() {
			Reader rdOrder = new Reader();
				Pedido order = new Pedido();
					String orderStr="";
					
			System.out.println("Introduzca el pedido en el formato *Item Cantidad*. Si solo es una unidad basta con poner solo *Item*. Escriba *fin* para terminar la toma del pedido");		
				orderStr = rdOrder.nextLowercase();
			
			while(orderStr.equals("fin")==false) {
				order.addContent(orderStr);
					orderStr = rdOrder.nextLowercase();
			}		
			Engine.database.updateClient(this.client, order);
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
							System.out.println("Error al eliminar cliente. Identificaci�n no v�lida");
						}
					}else if(select == 2) {
						temp.get(index).deleteOrder();
						System.out.println("Pedido eliminado exitosamente!");
					}
					Engine.database.setClientBase(temp);
			}else
				System.out.println("Entrada no v�lida. ID incorrecto o el cliente no existe");
		}		

	public void addInventory(int idProducto, int cantidad,String nombreProducto,String descripcion,String urlImagen){
            try {
                    Producto p1 = new Producto(idProducto,cantidad,nombreProducto,descripcion,urlImagen);   
                    
                    Engine.database.saveProducto(p1);
                    System.out.println("Producto guardado exitosamente!");
		}catch(RuntimeException e) {
                    System.out.println("No se puedo guardar el producto, intente de nuevo "+e);
		} 
        }	
		
		public DB getDatabase() {
			return Engine.database;
		}
		
		public boolean getAdminState() {
			return this.adminLogin;
		}
		
		public boolean getClientState() {
			return this.clientLogin;
		}

		public void setAdminState(Boolean b) {
			this.adminLogin = b;
		}
		
		public void setClientState(Boolean b) {
			this.clientLogin = b;
		}
		
		public Admin getAdmin() {
			return this.admin;
		}
		
		public Cliente getClient() {
			return this.client;
		}
		
	
		
		public void diezMil() {
			Engine.database = new DB();
			
			System.out.print("10.000 datos: ");
			
			long startTime = System.currentTimeMillis();  
				for(int i = 0; i<10000 ; i++) {	
					Cliente client = new Cliente(i,"Test " + i ,"test"+i , "default" + i);			
					Engine.database.saveClient(client);
				}
			long stopTime = System.currentTimeMillis();
		    	long elapsedTime = stopTime - startTime;
		    		
		    			System.out.println(elapsedTime + " ms");
		    			System.out.println("Cantidad de datos almacenados: " + Engine.database.getClientBase().size());
			
		}
		
		public void cienMil() {
			Engine.database = new DB();
			
			System.out.print("\n100.000 datos: ");
			
			long startTime = System.currentTimeMillis();  
				for(int i = 0; i<100000 ; i++) {	
					Cliente client = new Cliente(i,"Test " + i ,"test"+i , "default" + i);			
					Engine.database.saveClient(client);
				}
			long stopTime = System.currentTimeMillis();
		    	long elapsedTime = stopTime - startTime;		    		
		    			System.out.println(elapsedTime + " ms");
		    			System.out.println("Cantidad de datos almacenados: " + Engine.database.getClientBase().size());
			
			
		}
		
		public void millon() {
			Engine.database = new DB();
			
			System.out.print("\n1.000.000 datos: ");
			
			long startTime = System.currentTimeMillis();  
				for(int i = 0; i<1000000 ; i++) {	
					Cliente client = new Cliente(i,"Test " + i ,"test"+i , "default" + i);			
					Engine.database.saveClient(client);
				}
			long stopTime = System.currentTimeMillis();
		    	long elapsedTime = stopTime - startTime;
		    		double elapsedTimeS = (double) elapsedTime/1000.00;	
		    			double elapsedTimeM = elapsedTimeS/60;
		    				System.out.println(elapsedTime + " ms");
		    				System.out.println(elapsedTimeS + "s");
		    				System.out.println(elapsedTimeM + "min");
		    				System.out.println("Cantidad de datos almacenados: " + Engine.database.getClientBase().size());
		}
		
		public void diezMillones() {
			Engine.database = new DB();
			
			System.out.print("\n10.000.000 datos: ");
			
			long startTime = System.currentTimeMillis();  
				for(int i = 0; i<10000000 ; i++) {	
					Cliente client = new Cliente(i,"Test " + i ,"test"+i , "default" + i);			
					Engine.database.saveClient(client);
				}
			long stopTime = System.currentTimeMillis();
		    	long elapsedTime = stopTime - startTime;    		
	    		double elapsedTimeS = (double) elapsedTime/1000.00;	
    			double elapsedTimeM = elapsedTimeS/60;
    				System.out.println(elapsedTime + " ms");
    				System.out.println(elapsedTimeS + "s");
    				System.out.println(elapsedTimeM + "min");
    				System.out.println("Cantidad de datos almacenados: " + Engine.database.getClientBase().size());
		}
		
		public void cienMillones() {
			Engine.database = new DB();
			
			System.out.print("\n100.000.000 datos: ");
			
			long startTime = System.currentTimeMillis();  
				for(int i = 0; i<100000000 ; i++) {	
					Cliente client = new Cliente(i,"Test " + i ,"test"+i , "default" + i);			
					Engine.database.saveClient(client);
				}
			long stopTime = System.currentTimeMillis();
		    	long elapsedTime = stopTime - startTime;
		    		
	    		double elapsedTimeS = (double) elapsedTime/1000.00;	
    			double elapsedTimeM = elapsedTimeS/60;
    				System.out.println(elapsedTime + " ms");
    				System.out.println(elapsedTimeS + "s");
    				System.out.println(elapsedTimeM + "min");
    				System.out.println("Cantidad de datos almacenados: " + Engine.database.getClientBase().size());
		}


}


