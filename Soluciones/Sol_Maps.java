/**
 *
 * @author JUAN JOSE MONSALVE
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Arbol_contactos {
    protected Map<String, Map> contacts = new TreeMap<>();
    
    protected boolean varia = true;
    
    String[] partirEntrada(String word){
        return word.split(",");
    }
    
    
    public void agregarContacto(String[] datos){
        Map<String, List> inline = new TreeMap<>();
        String name = datos[0];
        if (!contacts.containsKey(name)){
            Integer edad  = Integer.parseInt(datos[1]);
            contacts.put(name, new TreeMap<String, Object>());
            contacts.get(name).put("edad", edad);
        }
        String relacion = datos[2];
        List<String> personas = new ArrayList<>();
        for (int i = 3; i < datos.length; i++) personas.add(datos[i]);
        inline.put(relacion, personas);
        contacts.get(name).put("relacion", inline);
    }
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Arbol_contactos arbol = new Arbol_contactos();
        int n = 6 ;     // camtidad de registros a ingresar, se puede modificar
        System.out.println("Ingrese linea a linea cada uno de los registro\nseparador por coma (,)");
        for (int i = 0; i<n; i++) {            
            String dato = sc.nextLine();
            arbol.agregarContacto(arbol.partirEntrada(dato));
        }
        System.out.println("Este es el diccionario registrado");
        System.out.println("Su siguiente paso es exportarlo a JSON");
        System.out.println(arbol.contacts);
    }   
}