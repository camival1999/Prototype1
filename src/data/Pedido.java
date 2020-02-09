package data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import businessLogic.Reader;


public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id = 0;
	private ArrayList<String> content;	
	private String status = "null";

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
        
	public Pedido() {
		this.id = 1;
		this.content= new ArrayList<String>();
	}

	public Pedido(int id) {
		this.id = id;
		this.content= new ArrayList<String>();
	}
	
	
		
	public void addContent(String thing_qty) {				//Agregar elementos al pedido con un String en la forma "item cantidad".
		
		if(this.content.isEmpty()) {									//caso 1: lista vac�a, nada que comprobar, agrega directamente
			this.content.add(thing_qty);
			return;
		}
		int index = duplicatePos(thing_qty); 							//caso contrario, revisar si el item que voy a agregar ya est� con otra cantidad;		
		
		if(index == -1) 												//caso 2: si no est�, agregar directamente
			this.content.add(thing_qty);			
		else{	
			String item = this.content.get(index);						//caso 3: busca el item ya guardado, obtiene la cantidad anterior y le agrega la nueva		
			
			Reader readerOld = new Reader(item);
			Reader readerNew = new Reader(thing_qty);
			
			String element = readerOld.next();
			
			int qtyOld;
				int qtyNew;
				
			try {	
				 qtyOld = readerOld.nextInt();
			}catch(NoSuchElementException e) {			
				 qtyOld = 1;
			}
			readerNew.next();
				
			try {
				qtyNew = readerNew.nextInt();
			}catch(NoSuchElementException e) {
				qtyNew = 1;
			}
					int qty = qtyOld+qtyNew;
						String newItem = (element + " " + Integer.toString(qty));
							this.content.remove(index);
								this.content.add(newItem);	
		}	
	}
			
	public int duplicatePos(String check)  {				//Revisa si el item que se desea agregar ya est� en la lista o no.	
		Iterator<String> it = content.iterator();			//Crea un iterador de la lista, y scanners para obtener solo los item, al estar en la forma "item cantidad"
		Reader readerOld = new Reader(check);
				String temp = "";
						int index= -1;
							String tempScanner = "";	
							
		String item = readerOld.next();				
		
		while(it.hasNext()) {								//recorre el ArrayList en b�squeda de una coincidencia de items y devuelve el index donde est� para reemplazar luego.
			temp = it.next();
			
			Reader readerNew = new Reader(temp);
			tempScanner = readerNew.next();
					
			if(tempScanner.equals(item))
				return ++index;
			else 
				index++;
				
		}
		return -1;											//en caso de no haber coincidencias, devuelve -1.
	}

	
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<String> getContent() {
		return content;
	}

	public void setContent(ArrayList<String> content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		
			StringBuilder builder = new StringBuilder();
			
			
			for ( String s : this.content){
				String[] outputArr=s.split(" ");
				int spaces = 20 - outputArr[0].length();
				String space = "";
				String capital = outputArr[0].toString().substring(0, 1).toUpperCase() + outputArr[0].toString().substring(1);
			
					for(int i = 1; i<=spaces;i++) {
						space = (space + " ");
					}	
					
					builder.append(capital);
						builder.append(space);
					try {
						builder.append(outputArr[1]);
					}catch(ArrayIndexOutOfBoundsException e) {
						builder.append("1");
					}
	        builder.append("\n"); 
	    }	
		return ("Pedido No. " + this.id + "\n" + "\n" + builder);
	
		
	}
	
}
