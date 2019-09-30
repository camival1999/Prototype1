package businessLogic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import data.DB;
import data.Admin;
import data.Cliente;

public class DataLoader {
	public static File clients = new File("ClientesDB.dat");
	public static File admins = new File("AdminsDB.dat");
	
	public static File getClientsFile() {
		return clients;
	}
	
	public static File getAdminsFile() {
		return admins;
	}

	
	public static void confirmClientDataBase(DB db) throws InterruptedException{
	try {
		if(!clients.exists()) {
			if(clients.createNewFile()) {
			}	
		}else {
			loadClients(clients,db);
		}
	} catch (IOException e) {
		System.out.println("error de archivo");
	}
}
	
	public static void confirmAdminDataBase(DB db) throws InterruptedException{
		try {
			if(!admins.exists()) {
				if(admins.createNewFile()) {
				}	
			}else {
				loadAdmins(admins,db);
			}
		} catch (IOException e) {
			System.out.println("error de archivo");
		}
	}

		
	public static void saveClients(File tmpDir,DB db)  {
		try {
			FileOutputStream fileOut = new FileOutputStream(tmpDir);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			
				objectOut.writeObject(db.getClientBase());
			System.out.println(db.getClientBase().size() + " clientes guardados");
			objectOut.close();
		}
		catch (IOException e) {
			System.out.println("No se pudo guardar la base de datos");
		}
	}
	
	public static void saveAdmins(File tmpDir,DB db)  {
		try {
			FileOutputStream fileOut = new FileOutputStream(tmpDir);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			
				objectOut.writeObject(db.getAdminBase());
			System.out.println(db.getAdminBase().size() + " Admins guardados");
			objectOut.close();
		}
		catch (IOException e) {
			System.out.println("No se pudo guardar la base de datos");
		}
	}

	
	@SuppressWarnings({ "unchecked" })
	public static void loadClients(File tmpDir,DB db) throws InterruptedException {
		
		System.out.print("Cargando clientes");	
		TimeUnit.MILLISECONDS.sleep(400);
		System.out.print(".");
		TimeUnit.MILLISECONDS.sleep(400);
		System.out.print(".");	
		TimeUnit.MILLISECONDS.sleep(400);
		System.out.print(".");
		TimeUnit.MILLISECONDS.sleep(400);
		System.out.print(".");
		TimeUnit.MILLISECONDS.sleep(400);
		System.out.println(".\n");
		ArrayList<Cliente> clientBase = new ArrayList<Cliente>();
		
		try {
			FileInputStream fileIn = new FileInputStream(tmpDir);
				ObjectInputStream objectIn = new ObjectInputStream(fileIn);	
			
			clientBase = (ArrayList<Cliente>) objectIn.readObject();	
			
			objectIn.close();
				fileIn.close();
				
			db.setClientBase(clientBase);
			System.out.println(db.getClientBase().size() + " clients retrieved successfully\n");
		}
		catch (IOException e) {
			System.out.println(db.getClientBase().size() + " contacts retrieved. Operation failed.");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "unchecked" })
	public static void loadAdmins(File tmpDir,DB db) throws InterruptedException {
		
		System.out.print("Cargando administradores");	
		TimeUnit.MILLISECONDS.sleep(400);
		System.out.print(".");
		TimeUnit.MILLISECONDS.sleep(400);
		System.out.print(".");	
		TimeUnit.MILLISECONDS.sleep(400);
		System.out.print(".");
		TimeUnit.MILLISECONDS.sleep(400);
		System.out.print(".");
		TimeUnit.MILLISECONDS.sleep(400);
		System.out.println(".\n");
			ArrayList<Admin> adminBase = new ArrayList<Admin>();
		
		try {
			FileInputStream fileIn = new FileInputStream(tmpDir);
				ObjectInputStream objectIn = new ObjectInputStream(fileIn);	
			
				adminBase = (ArrayList<Admin>) objectIn.readObject();	
			
			objectIn.close();
				fileIn.close();
				
			db.setAdminBase(adminBase);
			System.out.println(db.getAdminBase().size() + " admins retrieved successfully\n");
		}
		catch (IOException e) {
			System.out.println(db.getAdminBase().size() + " contacts retrieved. Operation failed.");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
