
package Figuras;

import javax.swing.JOptionPane;


public class Tester {

    public static void main(String[] args) {
        Figure figura = null; 
        boolean band = true;
        while (band){  
            String op = JOptionPane.showInputDialog(
            "1. Ingresar lado1" + "\n" +
            "2. Ingresar lado2"+ "\n" +
            "3. Ingresar caracter" + "\n" +
            "4. Formar Cuadrado" + "\n" +
            "5. Formar Rectangulo" + "\n" +
            "6. Formar Rombo" + "\n" +
            "7. Salir" + "\n"
            );
            
            switch (op){
                case "1":
                    Figure.lado1 = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el lado1"));                    
                    break;
                case "2":
                    Figure.lado2 = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el lado2"));
                    break;
                case "3":
                    Figure.char_delimit = JOptionPane.showInputDialog("Ingresa el caracter delimitante");
                    break;
                case "4":
                    figura = new Cuadrado();
                    break;
                case "5":
                    figura = new Rectangulo();
                    break;
                case "6":
                    figura = new Rombo();
                    break;                    
                case "7":
                    band = false;                    
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida, intenta nuevamente!!");
                    break;
            }
        
            if (Figure.lado1 > 1 && Figure.lado2 > 1 && !"".equals(Figure.char_delimit) && (op.equals("4") || op.equals("5") || op.equals("6"))){
                         
                System.out.println("Area del cuadrado: " + figura.get_Area()); 
                System.out.println("Perimetro del cuadrado: " + figura.get_Peremeter());
                System.out.println("Imagen del Cuadrado: " + "\n");                
                System.out.println(figura.Draw_Figure());
               
            }
        }
    }
    
}
