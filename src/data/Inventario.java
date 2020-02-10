package data;

import java.io.Serializable;
import java.util.HashMap;

public class Inventario implements Serializable {
	
	private HashMap<Producto,Integer> inventario;

	private static final long serialVersionUID = 1L;

        
        public Inventario() {
		this.inventario= new HashMap<Producto,Integer>();
	}
			
	public void agregarInventario(Producto prod , int cantidad) {                                                  //Agregar elementos a la base con la forma "producto, cantidad a agregar".
		
		if(this.inventario.isEmpty()) {                                                                     //caso 1: lista vac�a, nada que comprobar, agrega directamente
			this.inventario.put(prod, cantidad);
			return;
		}
		if(inventario.get(prod) == null)                                                                    //caso contrario, revisar si el id del pedido ya existe, en caso de que no, lo agrega;																//caso 2: si no est�, agregar directamente
			this.inventario.put(prod,cantidad);			
		else
                    this.inventario.replace(prod, this.inventario.get(prod) + cantidad);
                    
	}
        
        public void eliminarInventario(Producto prod , int cantidad) {                                                  //Egregar elementos de la base con la forma "producto, cantidad a eliminar".
                    this.inventario.replace(prod, this.inventario.get(prod) - cantidad);           
	}
        
        
}