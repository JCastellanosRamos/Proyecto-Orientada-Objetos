/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author josesito
 */
public class Conectar {
    Connection con = null;
    public Connection conexion (){
        try{
            //cargar nuestro driver 
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/ATRES","root","root");
            System.out.println("Conexión Establecida");
        }catch (ClassNotFoundException | SQLException e){
            System.out.println("ERROR DE CONEXION");
        }
        return con;
    }
}

