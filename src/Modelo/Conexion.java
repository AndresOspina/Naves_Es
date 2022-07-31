/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author USER
 */
public class Conexion {
    
    
   
    private final String user = "root";
    private final String password = "monster";
    private final String url = "jdbc:mysql://localhost:3306/naves";
    public Connection con = null;
    
public Connection getConexion() {
        con = null;
        try {           
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=(Connection)DriverManager.getConnection(this.url,this.user,this.password);
            
            JOptionPane.showInputDialog(null, "conexión exitosa");

        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex){
         Logger.getLogger (Conexion.class.getName()).log(Level.SEVERE,null,ex);
        }

        return con; 
    }
}
