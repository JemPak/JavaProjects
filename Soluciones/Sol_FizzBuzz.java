import java.util.Scanner;
public class ejercicio7{   
    
    public static String diagonales(double[][] matriz){ 
        double diagonal_principal = 0, diagonal_secundaria = 0;
        String[] resultado_diagonales = new String[2]; // arrglo vacio donde almacenaré los resultados de las 2 diagonales

        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[i].length; j++){
                if (i == j){ // proceso para la diagonal principal
                    diagonal_principal += matriz[i][j];
                }    
                if (i+j == matriz.length-1){ // proceso para la diagonal secundaria
                    diagonal_secundaria += matriz[i][j];
                }            
            }
        }                 

        if (diagonal_principal%2 == 0){
            resultado_diagonales[0] = "Fizz";
        } else{
            resultado_diagonales[0] =  "Buzz";
        }

        if (diagonal_secundaria%2 == 0){
            resultado_diagonales[1] = "Fizz";
        } else{
            resultado_diagonales[1] =  "Buzz";
        }
        return resultado_diagonales[0] + " - " + resultado_diagonales[1]; 
    }
      
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        
        double[][] matriz;
        int tamano;
        String values = new String();
        
        while (true){
            System.out.print("Ingresa el tamaño de tu matriz: ");
            tamano = sc.nextInt();
            matriz = new double[tamano][tamano];
            System.out.println("Ingresa fila a fila los valores de la matriz:");
            for (int i=0; i < tamano; i++){
                System.out.print("Ingresa los valores de la fila " +(i+1) +" separados por un guion (-): ");   
                Scanner cs = new Scanner(System.in);
                values = cs.nextLine();
                String[] new_values = values.split("-");
                for (int j = 0; j < tamano; j++) {
                    matriz[i][j] = Double.parseDouble(new_values[j]);                                
                }
            }
            System.out.println("-----------");
            System.out.println(diagonales(matriz));
            System.out.println("-----------");
            System.out.println("\n");
        }
    }
    
}