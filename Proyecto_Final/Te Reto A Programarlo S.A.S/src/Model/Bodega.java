/*
 * Representación de la tabla Bodega
 * en clase orientada a objetos
 */
package Model;

/**
 * @author DAVID ANTONIO CASTRO
 * @author JUAN JOSE MONSALVE
 */
public class Bodega {
    private int idBodega;
    private String nombre;
    private String direccion;

    public Bodega(int idBodega, String nombre, String direccion) {
        this.idBodega = idBodega;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public int getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(int idBodega) {
        this.idBodega = idBodega;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    
}
