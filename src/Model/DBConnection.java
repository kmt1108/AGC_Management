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
 * @author kieum
 */
public class DBConnection {
    final String dbName="AGC_MANAGEMENT";
    final String conString="jdbc:sqlserver://KIEUMANHTIEN-PC\\SQLEXPRESS:1433;integratedSecurity=True;databaseName="+dbName;
    public Connection getConnection(){
        Connection conn=null;
        try {
            conn=DriverManager.getConnection(conString);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
