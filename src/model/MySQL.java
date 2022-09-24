/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author poojithairosha
 */
public class MySQL {
    
    private static Connection connection;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Poojitha@2006";
    private static final String DATABASE = "code_fest";
    
    private static Statement createConnection() throws Exception {
        if(connection == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DATABASE, USERNAME, PASSWORD);
        }
        
        return connection.createStatement();
    }
    
    public static void iud(String query) {
        try {
            createConnection().executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static ResultSet search(String query) throws Exception {
        return createConnection().executeQuery(query);
    }
    
}
