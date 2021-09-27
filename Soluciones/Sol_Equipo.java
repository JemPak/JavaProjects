
/**
 *
 * @author JUAN JOSE MONSALVE
 */
// Clase 1
public class Ejecutar {

    /**
     * Clase para ejecutar el programa, insertar las consultas en el Main
     */
    public static void main(String[] args) {
        // TODO code application logic here
        equipoFutbol america = new equipoFutbol("col", 6, "colombia");
        Jugador andres = new Jugador("andres rodrigues", 28, 34000,"34");
        america.agregarJugador(andres);
        Jugador camilo = new Jugador("camilo perez", 23, 30000,"3");
        Jugador benito = new Jugador("benito lopez", 22, 26000,"8");
        Jugador carlos = new Jugador("carlos martinez", 19, 45000,"10");
        Jugador marcos = new Jugador("marcos hernandez", 25, 18000,"20");
        Jugador julian = new Jugador("julian andrade", 30, 40000,"21");
        
        Entrenador juan = new Entrenador("hernesto amador", "3", 17, 90000);
        america.agregarEntrenador(juan);       
        america.agregarJugador(camilo);
        america.agregarJugador(benito);
        america.agregarJugador(marcos);
        america.agregarJugador(carlos);
        america.agregarJugador(julian);
        
        america.jugadores.get(3).AgregarPosicion("Delantero");
        america.jugadores.get(3).AgregarEquipoAnterior("ballenita");
        america.jugadores.get(5).cambiarDorsal("14");
        System.out.println(america.jugadores.get(5).edad);
        
        
    }
    
}

// Clase 1 para el entrenador
public class Entrenador {
    public String nombre;
    public String antiguedad;
    private int salario;
    public int añosExperiencia;

    public Entrenador(String nombre, String antiguedad, int añosExperiencia, int salario) {
        this.nombre = nombre;
        this.antiguedad = antiguedad;
        this.añosExperiencia = añosExperiencia;
        this.salario = salario;
    } 
}

// Clase 2 para el jugador
import java.util.ArrayList;

public class Jugador {
    public String nombre;
    public int edad;
    private int salario;
    public ArrayList<String> posiciones = new ArrayList<>();
    public String dorsal;
    public int minutosJugados;
    public ArrayList<String> equiposAnteriores = new ArrayList<>();
    
    public Jugador(String nombre, int edad, int salario, String dorsal){
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
        this.dorsal = dorsal;
    }
    
    public void AgregarPosicion(String posicion){
        this.posiciones.add(posicion);
    }
    
    public void AgregarEquipoAnterior(String equipo){
        equiposAnteriores.add(equipo);
    }
    
    public void cambiarDorsal(String numero){
        this.dorsal = numero;
    }
}

// Clase 3 del Equipo

import java.util.ArrayList;

public class equipoFutbol {

    // Atributos
    public String nombre;
    public int antiguedad;
    public ArrayList<Jugador> jugadores = new ArrayList<>() ;
    public Entrenador entrenador;
    public String pais;
    
    public equipoFutbol(String nombre, int antiguedad, String pais){
        this.nombre = nombre;
        this.antiguedad = antiguedad;
        this.pais = pais;        
    }
    
    public void agregarJugador(Jugador jugador){
        this.jugadores.add(jugador);
        
    }
    
    public void agregarEntrenador(Entrenador entrena){
        this.entrenador = entrena;        
    }
        
}