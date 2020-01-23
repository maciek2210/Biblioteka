/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marek
 */
public class ConnectionManager {
    
    private Connection conn;
    
    public Connection getConnection() {
        
        try {
            
            if(conn!=null && !conn.isClosed())
                return conn;
            // SQLite connection string
            Class.forName("org.sqlite.JDBC");
     // System.out.println(new File("baza.db").getAbsolutePath());
           String url = "jdbc:sqlite:"+new File("baza.db").getAbsolutePath();
        //  String url = "jdbc:sqlite:C:\\SVN\\nf\\baza.db";
   

//    String url = "jdbc:sqlite:baza.db";
            conn = null;
           
                conn = DriverManager.getConnection(url);
          
            return conn;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    
    
}
