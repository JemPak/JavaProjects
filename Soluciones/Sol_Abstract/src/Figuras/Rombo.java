
package Figuras;


public class Rombo extends Figure{
       
    @Override
    protected double get_Area(){
        return lado1*lado2;
    }
    
    @Override
    protected double get_Peremeter(){
        return 4*lado1;
    }
    
    @Override 
    protected String Draw_Figure(){
        // no importa los lados ya que son iguales
        String figure = "";
        String[] line = new String[Figure.lado1];
        String blankSpace = "";
        String delimit  = Figure.char_delimit;
        
        for (int i = 0; i < delimit.length(); i++){ 
            blankSpace += " ";
        }       
        for (int i = Figure.lado1; i > 0; i--) {
            String inline = "";
            for (int j = 0; j < i; j++) {
                inline += blankSpace + " ";               
            }
            inline += delimit + " ";
            for (int k = 0; k < (Figure.lado1-i)*2-1; k++) {
                //System.out.println("here");
                inline += blankSpace + " ";                
            }
            if (i != Figure.lado1){
                inline += delimit;
            }
            //inline += delimit;
            figure += inline + "\n";
            line[Figure.lado1-i] = inline;            
        }       
        for (int i = line.length-2; i > -1; i--) {
            figure += line[i] + "\n";        
        }
        return figure;
        
    }
    
}
