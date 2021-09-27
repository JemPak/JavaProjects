/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAOS.DAOempleado;
import Model.Empleado;
import View.ResultsConsultaEmpleado;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.simple.parser.ParseException;

/**
 * @author DAVID ANTONIO CASTRO
 * @author JUAN JOSE MONSALVE
 */

/*
    Clase para el manejo de eventos en las Interfaces,
    por el momento solo tiene funcionalidad en la
    Interfaz ViewEmpleado.
*/
public class ActionEvents {
    
    
    
    public static void insertarEmpleado(Empleado empleado){
        try {
            DAOempleado new_empleado = new DAOempleado();
            new_empleado.InsertEmpleado(empleado);                        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Inserción Fallida!");
        }
    }
    
    public static void updateEmpleado(int idEmpleado, String nombre, String edad){
        // Asigancion de la edad deacuerdo a lo pasado por parametro
        Integer new_edad = ("".equals(edad)) ? null: Integer.valueOf(edad);
        // Asignacion del valor nombre correspondiente a su informacion, si es vacio null
        nombre = ("".equals(nombre)) ? null: nombre;
        
        // Llamado al DAO con la informacion de actualizacion, idEmpleado, nomnre y edad del empleado
        try {
            DAOempleado new_empleado = new DAOempleado();
            try {            
                new_empleado.UpdateEmpleados(idEmpleado, nombre, new_edad);
            } catch (IOException ex) {
                Logger.getLogger(ActionEvents.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(ActionEvents.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Actualización Fallida!");
//            e.printStackTrace();
        }
    }
    
    public static void ConsultaEmpleado(String idBodega,String idEmpleado, String nombre, String edad){
        // diccionario de consultas, null si el campo es vacia
        HashMap<String, String> dic_consulta = new HashMap<>();
        dic_consulta.put("idBodega", ("".equals(idBodega)) ? null: idBodega);
        dic_consulta.put("idEmpleado", ("".equals(idEmpleado)) ? null: idEmpleado);
        dic_consulta.put("nombre", ("".equals(nombre)) ? null: nombre);
        dic_consulta.put("edad", ("".equals(edad)) ? null: edad);
        ArrayList<Empleado> consulta;
        DAOempleado new_empleado = new DAOempleado();
        consulta = new_empleado.SelectEmpleados(dic_consulta);
        // Llamado a la interfaz para mostrar los datos de la consulta
        ResultsConsultaEmpleado resultados = new ResultsConsultaEmpleado(consulta);
    }
    
    public static void deleteEmpleado(String empleado){
        // Id a borrar, luego implementar borrado multiple
        Integer idEmpleado = Integer.valueOf(empleado);
        List<Integer> IdsEmpleados = new ArrayList<>();
        IdsEmpleados.add(idEmpleado);
        try {
            DAOempleado new_empleado = new DAOempleado();
            new_empleado.DeleteEmpleados(IdsEmpleados);
        } catch (SQLException e) {
//            System.out.println("Fallo en evnts");
            JOptionPane.showMessageDialog(null, "Eliminación Fallida!");
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(ActionEvents.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ActionEvents.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
