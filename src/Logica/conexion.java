/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.sql.*;

/**
 *
 * @author juand
 */
public class conexion {
    public Connection getConexion(){
        String driver = "com.mysql.jdbc.Driver";
        String connectString = "jdbc:mysql://localhost:3306/empresaTelecomunicacion";
        String user = "root";
        String password = "20022509jd";
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(connectString, user, password);
            return con;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
