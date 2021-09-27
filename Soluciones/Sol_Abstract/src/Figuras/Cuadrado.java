
package Figuras;


public class Cuadrado extends Figure{
    
    @Override
    protected double get_Area(){
        return lado1*lado2;
    }
    
    @Override
    protected double get_Peremeter(){
        return (2*lado1)+(2*lado2);
    }
    
    @Override 
    protected String Draw_Figure(){
        String line = "";
        String lineInitial = "";
        String blankSpace = "";
        String delimit  = Figure.char_delimit;
        
        for (int i = 0; i < delimit.length(); i++) {
            blankSpace += " ";            
        }        
        for (int i = 0; i < Figure.lado1; i++) {
            lineInitial += delimit + " ";            
        }        
        line += lineInitial;
        for (int i = 0; i < Figure.lado1-2; i++) {
            line += "\n";
            for (int j = 0; j < Figure.lado1; j++) {
                if (j == 0 || j == Figure.lado1-1){
                    line += delimit + " ";
                } else{
                    line += blankSpace + " ";
                }    
            }           
        }
        line += "\n" + lineInitial;
        return line;
    }
    
    
    
}
