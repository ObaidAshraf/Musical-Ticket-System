/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.musicalticketsystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author Administrator
 */
public class DbHandler {
    
    private String framework = "embedded";
    private String protocol = "jdbc:derby://localhost:1527/";
    Connection conn = null;
    
    public void setup_db_connection() {
        Properties props = new Properties();
        props.put("user", "app");
        props.put("password", "app");

        String dbName = "MusicalTicketSystem";
        try {
            conn = DriverManager.getConnection(protocol + dbName+ "", props);

            System.out.println("Connected to and created database " + dbName);
            conn.setAutoCommit(false);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void insert_record_into_db(String[] record) {
        ArrayList<Statement> statements = new ArrayList<Statement>();
        PreparedStatement psInsert;
        PreparedStatement psUpdate;
        Statement s;
        ResultSet rs = null;
        
        try {       
            s = conn.createStatement();
            statements.add(s);


            psInsert = conn.prepareStatement("insert into shows values (?, ?, ?, ?, ?, ?, ?, ?)");
            statements.add(psInsert);

            for (int i = 1; i <= record.length; i++)
                psInsert.setString(i, record[i-1]);
            
            psInsert.executeUpdate();

            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    public void close_db_connection() {
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    
}
