/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL-PC
 */
public class DBconnect {
    
    public static Connection connectdb() {

        var url = "jdbc:mysql://localhost:3306/GYM";
        String user = "root";
        String password = "12345678";

        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(url, user, password);

                   

        } catch (ClassNotFoundException | SQLException e) {
                     JOptionPane.showMessageDialog(null, "Database Connected Unsuccessful");
        }

        return conn;
    }
}
