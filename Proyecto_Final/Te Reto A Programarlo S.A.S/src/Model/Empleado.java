/*
 * Representacion de la tabla Empleado 
 * en Modelo de clase Orientada a Objetos
 */
package Model;

/**
 * @author DAVID ANTONIO CASTRO
 * @author JUAN JOSE MONSALVE
 */
public class Empleado {
    private int idBodega;
    private int idEmpleado;
    private String nombre;
    private int edad;

    public Empleado(int idBodega, int idEmpleado, String nombre, int edad) {
        this.idBodega = idBodega;
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.edad = edad;
    }
    
    public Object[] ToArray(){
        return new Object[]{this.idBodega, this.idEmpleado, this.nombre, this.edad};
    }


    public int getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(int idBodega) {
        this.idBodega = idBodega;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
    
}
