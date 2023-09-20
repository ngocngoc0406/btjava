/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author HP
 */
public class ConnectMySQL {
    public static void main(String[] args) {
    Connection connection = null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver()); 
            String url = "jdbc:mySQL://127.0.0.1:3306/javadatabase";
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
