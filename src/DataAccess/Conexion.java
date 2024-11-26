/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author NEISER
 */
public class Conexion {
    
    private static String URI = "jdbc:mysql://127.0.0.1:3307/lab";
    private static String user = "root";
    private static String pass = "admin";

    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(URI, user, pass);
            return connection;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
