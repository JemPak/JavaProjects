/*
 * Representacion de la tabla almacena
 * en modelo orientado a objetos
 */
package Model;

/**
 * @author DAVID ANTONIO CASTRO
 * @author JUAN JOSE MONSALVE
 */
public class Almacena {
   private int idBodega;
   private int idProducto;
   private int cantidad;

    public Almacena(int idBodega, int idProducto, int cantidad) {
        this.idBodega = idBodega;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }

    public int getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(int idBodega) {
        this.idBodega = idBodega;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
   
   
}
