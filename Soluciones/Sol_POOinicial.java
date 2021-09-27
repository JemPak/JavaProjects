/**
 *
 * @author JUAN JOSE MONSALVE
 */

// clase 1 para ejecución
public class Principio {

    public static void main(String[] args) {
        Persona juan = new Persona("M", 34, "Juan Monsa Pat", "Ecuatoriano", "34t56u79o");
        System.out.println(juan.Departamento_residencia());
        System.out.println(juan.edad);
        System.out.println(juan.Alias());
    }
    
}

// clase 2
public class Persona {
    public String sexo;
    public int edad;
    public String nombre;
    public String nacionalidad;
    public String documento;

    public Persona(String sexo, int edad, String nombre, String nacionalidad, String documento) {
        this.sexo = sexo;
        this.edad = edad;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.documento = documento;
    }
    
    public boolean es_mayor_de_edad(){
        return (this.edad > 18);
    }
    
    public String Departamento_residencia(){
        if (documento.length() <= 5){
            return "Valle del Cauca";
        } else if (documento.length() <= 8){
            return "Antioquia";
        } return "Cundinamarca";       
    }
    
    public String Alias(){
        String alias = "";
        String[] partes = nombre.split(" ");
        System.out.println(nombre);
                
        for (String word: partes){
            alias += word.charAt(0);            
        }
        return alias;                
    }
}

