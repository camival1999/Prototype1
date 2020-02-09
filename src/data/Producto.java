package data;

import java.io.Serializable;

/**
 *
 * @author John_Riaño
 */
public class Producto implements Serializable{
    private int idProducto;
    private String nombreProducto;
    private int cantidad;
    private String descripcion;
    private String urlImagen;
    private static final long serialVersionUID = 1L;

    public Producto(){
    }
    public Producto(int idProducto, int cantidad,String nombreProducto,String descripcion,String urlImagen){
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.urlImagen = urlImagen;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
            
}
