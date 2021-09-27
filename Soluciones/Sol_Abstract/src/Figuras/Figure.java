
package Figuras;



public abstract class Figure {
    public static int lado1;
    public static int lado2;
    public static String char_delimit = "";
    
    protected abstract double get_Area();
    protected abstract double get_Peremeter();
    protected abstract String Draw_Figure();

}

