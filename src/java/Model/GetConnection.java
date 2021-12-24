/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mangn
 */
public class GetConnection {
     public Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String un = "sa";
            String pw = "admin";
            String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=FPT_EDUCATION";
            try {
                conn = DriverManager.getConnection(url,un,pw);
            } catch (SQLException ex) {
                Logger.getLogger(GetConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GetConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
     public Connection getConnection(String un,String pw, String db){
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName="+db;
            try {
                conn = DriverManager.getConnection(url,un,pw);
            } catch (SQLException ex) {
                Logger.getLogger(GetConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GetConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
