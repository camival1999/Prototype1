package businessLogic;

import java.io.File;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.InputMismatchException;

import data.Cliente;
import data.DB;
import data.Pedido;

public class Engine implements Serializable{

	private static final long serialVersionUID = 1L;
		private static  DB database;
	
		
		public void run() throws InterruptedException {
			Engine.database = new DB();
			businessLogic.DataLoader.confirmDataBase(Engine.database);
		}
		
		public void end()  {
			File tmpDir = new File("ClientesDB.dat");
			businessLogic.DataLoader.saveClients(tmpDir,Engine.database);
		}
			
		public  void registro() {
			Reader rdRegister = new Reader();
			int id = -1;
			
			System.out.println("Introduzca el nombre y apellido del cliente:");
			String name = rdRegister.nextLine();
			System.out.println("Introduzca la identificacion numérica del cliente:");
			try {
				id = rdRegister.nextInt();	
				Cliente client = new Cliente(id,name);
					try {
						database.saveClient(client);
						System.out.println("Cliente guardado exitosamente!");
					}catch(RuntimeException e) {
						System.out.println("No se puedo guardar el cliente, intente de nuevo");
					}
			}catch(InputMismatchException e) {
				System.out.println("Identificación no válida");
			}
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
			Hashtable<Integer,Cliente> temp = new Hashtable<Integer,Cliente>();
			temp = Engine.database.getClientBase();
			
			System.out.println("Introduzca el ID del cliente: ");
			Integer id = rdElim.nextInt();
			
			System.out.println("id: " + id);
			System.out.println("contiene: " + temp.containsKey(id));
			
			if(temp.containsKey(id)) {
				System.out.println("1.-Eliminar cliente          2.- Eliminar pedido");
			
				int select = rdElim.nextInt();
				
					if(select==1) {
						try {
							temp.remove(id);
							System.out.println("Cliente eliminado exitosamente!");
						}catch(NullPointerException e) {
							System.out.println("Error al eliminar cliente. Identificación no válida");
						}
					}else if(select == 2) {
						temp.get(id).setOrder(null);
						System.out.println("Pedido eliminado exitosamente!");
					}
				Engine.database.setClientBase(temp);
			}else
				System.out.println("Entrada no válida. ID incorrecto o el cliente no existe");
		}		

		public DB getDatabase() {
			return Engine.database;
		}
}
