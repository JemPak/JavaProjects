/*
 * Conexion inicial a la base de datos
 */
package Connections;

/**
 * @author DAVID ANTONIO CASTRO
 * @author JUAN JOSE MONSALVE
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.json.simple.*;
import org.json.simple.parser.*;

public class InitialConnectionSQL {
    /*
        Conexion estatica con la base de datos
        los archivos correspondientes a las credenciales
        de acceso a la base de datos se encuentran en el JSON
    */
    public static Connection getConnection(){
        JSONParser parser = new JSONParser();
        Connection SQLconnection = null;
//        String url = "jdbc:mysql://localhost:3306/DbTodoLoBuenoSAS";
//        String username = "root";
//        String password = "*Monsalve18"; 
        try {
            // Ruta del json con las propiedades del acceso a la base de datos
            String credentials_path = System.getProperty("user.dir") + "/src/utils/DataProperties.json";
            JSONObject jsonObject = (JSONObject)parser.parse(new FileReader(credentials_path));
            
            String host     = (String)jsonObject.get("db_ip");
            String port     = (String)jsonObject.get("dp_port");
            String username = (String)jsonObject.get("db_user");
            String password = (String)jsonObject.get("db_pssword");
            
            // Nombre de la base de datos DbTodoLoBuenoSAS
            String dbURL = "jdbc:mysql://"+host+":"+port+"/DbTodoLoBuenoSAS" ;
            
            SQLconnection = DriverManager.getConnection(dbURL, username, password);

        } 
        catch( SQLException | FileNotFoundException ex ) {
            ex.printStackTrace();
        } 
        catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return SQLconnection;
    }
}
