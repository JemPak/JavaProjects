/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import Connections.InitialConnectionSQL;
import Model.Empleado;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.simple.parser.ParseException;
/**
 * @author DAVID ANTONIO CASTRO
 * @author JUAN JOSE MONSALVE
 */

/*
    Gestion y acceso al CRUD de la base de datos correspondiente
    a la tabla Empleados
*/
public class DAOempleado {
    private Connection conn = null;
    
    public void InsertEmpleado(Empleado empleado) throws SQLException{
        // conexion a base de datos
        conn = InitialConnectionSQL.getConnection();
        
        // Ingresar los valores en la sentencia de Inserción
        String insert = "INSERT INTO empleado (idBodega,idEmpleado,nombre,edad) VALUES (?,?,?,?)";      
        PreparedStatement statement = conn.prepareStatement(insert);
        statement.setInt(1, empleado.getIdBodega());
        statement.setInt(2, empleado.getIdEmpleado());
        statement.setString(3, empleado.getNombre());
        statement.setInt(4, empleado.getEdad());
        int rows_inserted = statement.executeUpdate();
        if (rows_inserted > 0) {
            JOptionPane.showMessageDialog(null, "Registro insertado Exitosamente!");
        }else{
            JOptionPane.showMessageDialog(null, "Inserción Fallida!");
        }
        conn.close();
    }
    /*
        Seleccion de los empleados filtrando por los
        campos no nulos del HashMap.
        Con este filtro me ahorro hacer varias sobrecargas de este metodo.
    */
    
    /*
        ejecucion de la consulta, el HashMap pasado por parametro 
        es previamente creado en el controlador y trae consigo la informacion
        referente a los campos de consulta que escogio la persona, por el momento 
        solo se permite la consulta de 2 campos.
    */
    public ArrayList<Empleado> SelectEmpleados(HashMap<String, String> filtro){
        
        // Declaración del Array que contendra los resultados de la consulta
        ArrayList<Empleado> empleados = new ArrayList<>();
        try {
            conn = InitialConnectionSQL.getConnection();
            
            // Creacion de posibles Querrys a ejecutar
            String select_sin_filtro = "SELECT idBodega, idEmpleado, nombre, edad FROM empleado;";
            String select_de_dos_filtros = "SELECT idBodega, idEmpleado, nombre, edad FROM empleado WHERE ?=? AND ?=?;";
            String select_de_un_filtro = "SELECT idBodega, idEmpleado, nombre, edad FROM empleado WHERE ?=?;";
            String select;
            
            Map<String, String> filtros = new HashMap<>();
            // Filtro de los datos que vienen del HashMap y que representan la consulta, solo datos no nulos
            for (Map.Entry<String, String> cond : filtro.entrySet()) {
                if (cond.getValue() != null) {
                    filtros.put(cond.getKey(), cond.getValue());
                }
            }
            // seleccion de la Querry adecuada segun los campos seleccionados
            select = (filtros.size() == 2) ?select_de_dos_filtros : (1 == filtros.size()) ? select_de_un_filtro : select_sin_filtro;
            PreparedStatement statement = conn.prepareStatement(select);
            
            //Agregado de las sentencias al Querry
            int index = 0;
            for (Map.Entry<String, String> filt : filtros.entrySet()) {
                index++;
                if ("nombre".equals(filt.getKey())) {
                    statement.setString(index, filt.getKey());
                    statement.setString(index+1, filt.getValue());
                }else{
                    statement.setString(index, filt.getKey());
                    statement.setInt(index+1, Integer.parseInt(filt.getValue()));
                }
                index++;
            }
            
            // 3 horas resolviendo el Querry, a java no le gustan las '' :v
            System.out.println(statement.toString());
            select = statement.toString().substring(statement.toString().indexOf("SELECT")).replace("\'", "");
            if (select.contains("nombre")) {
                // Filtro para el nombre, se reemplaza por un like '%%'
                
                String nombre_fil = "nombre="+filtro.get("nombre");
                String con_comilla = "nombre LIKE '%"+filtro.get("nombre")+"%\'";
                select = select.replace(nombre_fil, con_comilla); 
            }
            
            PreparedStatement new_state = conn.prepareStatement(select);
            ResultSet result = new_state.executeQuery();

            while(result.next()){
                empleados.add(new Empleado(result.getInt(1), result.getInt(2), result.getString(3), result.getInt(4)));            
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOempleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empleados;
    }
    /*
        Por cuestiones de tiempo solo se permite la
        Actualizacion de nombre y edad en esta funcion.
        2 horas analizando que el Querry del nombre dia llevar comillas simples :v
    */
    public void UpdateEmpleados(int idEmpleado, String nombre, Integer edad) throws SQLException, IOException, FileNotFoundException, ParseException{
        conn = InitialConnectionSQL.getConnection();
        
        String Update;
        // Selecion de la Sentencia adecuada de actualizacion deacuerdo a los campos actualizados
        if (nombre != null && edad != null) {
            Update = "UPDATE empleado SET nombre='" + nombre + "', edad="+String.valueOf(edad)+" WHERE idEmpleado="+ String.valueOf(idEmpleado);
        } else {
            if (edad != null) {
                Update = "UPDATE empleado SET edad="+String.valueOf(edad)+" WHERE idEmpleado="+String.valueOf(idEmpleado);
            }else{
                Update = "UPDATE empleado SET nombre='"+ nombre +"' WHERE idEmpleado="+String.valueOf(idEmpleado);
            }
        }
        // Ejecucion de la sentencia
        Statement statement = conn.createStatement();
        int rows_afected = statement.executeUpdate(Update);
        if (rows_afected > 0) {
            JOptionPane.showMessageDialog(null, "Actualización Exitosa!");
        } else{
            JOptionPane.showMessageDialog(null, "Actualización Fallida!");
        }
        conn.close();
    }
    
    /*
        Metodo para eliminar empleados de la base de datos,
        utilizar con precaución, puede causar fallas irreparables.
        recibe una lista de empleados a los cuales se les quiere borrar la ID,
        por el momento solo un borrado a la vez
    */
    public void DeleteEmpleados(List<Integer> idEmpleados) throws SQLException, IOException, FileNotFoundException, ParseException{
        conn = InitialConnectionSQL.getConnection();
        int rows_afected = 0;
        
        //Iterado sobre el array para acceder a su Id  y borrar el registro
        for (int i = 0; i < idEmpleados.size(); i++) {
            Integer id = idEmpleados.get(i);
            String Delete = "DELETE FROM empleado WHERE idEmpleado="+String.valueOf(id)+";";
            Statement statement = conn.createStatement();
            rows_afected += statement.executeUpdate(Delete);
        }
        
        if (rows_afected == idEmpleados.size()) {
            JOptionPane.showMessageDialog(null, "Borrado Exitoso!");
        }else{
            JOptionPane.showMessageDialog(null, "Borrado Fallido!");
        }
        conn.close();
    }

}
