/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.piapoo;
import java.sql.*;
import java.util.logging.*;
import java.sql.Connection;
/**
 *
 * @author AnaPao
 */
public class Conectar {
    String jdbcUrl = "jdbc:mysql://localhost:3306/pia"; //Cambiar el nombre de la base de datos
    String user= "root";
    String password = ""; //Poner tu contraseña de MySQL
    Connection cx;
      public Connection conectar()
    {
        try {
              cx = DriverManager.getConnection(jdbcUrl, user, password);
              System.out.println("Se conecto a la base de datos");
        } catch(SQLException ex){
            System.out.println("No se conecto a la base de datos");
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cx;
    }
      public void desconectar(){
        try{
            cx.close();
        }catch(SQLException ex){
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
