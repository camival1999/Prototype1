package businessLogic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import data.DB;
import data.Cliente;

public class DataLoader {
	public static File tmpDir = new File("ClientesDB.dat");
	
	public static File getTmpDir() {
		return tmpDir;
	}
	
	public static void confirmDataBase(DB db) throws InterruptedException{
	try {
		if(!tmpDir.exists()) {
			if(tmpDir.createNewFile()) {
			}	
		}else {
			loadClients(tmpDir,db);
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
	
	@SuppressWarnings({ "unchecked" })
	public static void loadClients(File tmpDir,DB db) throws InterruptedException {
		
		System.out.print("Cargando base de datos");	
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
			Hashtable<Integer, Cliente> clientBase = new Hashtable<Integer, Cliente>();
		
		try {
			FileInputStream fileIn = new FileInputStream(tmpDir);
				ObjectInputStream objectIn = new ObjectInputStream(fileIn);	
			
			clientBase = (Hashtable<Integer, Cliente>) objectIn.readObject();	
			
			objectIn.close();
				fileIn.close();
				
			db.setClientBase(clientBase);
		}
		catch (IOException e) {
			System.out.println(db.getClientBase().size() + " contacts retrieved");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
