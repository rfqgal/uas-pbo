/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unsia.rfqgal.uaspbo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rfqgal
 */
public class Connect {
    
    private static String url = "jdbc:mysql://localhost:3306/my-product";
    private static String username = "root";
    private static String password = "";
    private static Connection connection = null;
    
    static {
        connect();
    }
    
    public Connect() {
        connect();
    }
    
    private static void connect() {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(url, username, password);
                connection.setAutoCommit(false);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
