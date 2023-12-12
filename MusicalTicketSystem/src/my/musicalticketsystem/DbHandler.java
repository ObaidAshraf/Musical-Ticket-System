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
import java.util.*;

/**
 *
 * @author Administrator
 */
public class DbHandler {
    
    private String framework = "embedded";
    private String protocol = "jdbc:derby://localhost:1527/";
    private String dbName = "MusicalTicketSystem";
    Connection conn = null;
    
    public void setup_db_connection() {
        Properties props = new Properties();
        props.put("user", "app");
        props.put("password", "app");
        
        try {
            conn = DriverManager.getConnection(protocol + dbName+ "", props);

            System.out.println("Connected to and created database " + dbName);
            conn.setAutoCommit(false);
        } catch(Exception e) {
            System.err.println("Failed to connect to database " + dbName);
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

            psInsert = conn.prepareStatement("INSERT INTO SHOWS VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
            statements.add(psInsert);

            for (int i = 1; i <= record.length; i++)
                psInsert.setString(i, record[i-1]);
            
            psInsert.executeUpdate();

            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    public  HashMap<String, ArrayList<String[]>> fetch_records_from_db() {
        HashMap<String, ArrayList<String[]>> shows = new HashMap<>();
        Statement s;
        ResultSet rs = null;
        ArrayList<String[]> list;
        String[] data;
        try {
            s = conn.createStatement();
            rs = s.executeQuery("SELECT * FROM SHOWS");
            while (rs.next()) {
                data = new String[8];
                for (int i = 0; i < data.length; i++)
                    data[i] = rs.getString(i+1);
                
                list = shows.get(data[0]);
                if (list == null) {
                    list = new ArrayList<String[]>();
                }
                list.add(data);
                shows.put(data[0], list);
            }
            
        } catch (Exception e) {
            System.err.println("Failed to Fetch records from database " + dbName);
            return shows;
        }
        
        return shows;
    }
    
    public HashMap<String, ArrayList<String[]>> fetch_filtered_records_from_db(String pattern, String column) {
        HashMap<String, ArrayList<String[]>> shows = new HashMap<>();
        Statement s;
        ResultSet rs = null;
        ArrayList<String[]> list;
        String[] data;
        try {
            s = conn.createStatement();
            rs = s.executeQuery("SELECT * FROM SHOWS WHERE UPPER(" + column + ") LIKE UPPER('%" + pattern + "%')");
            while (rs.next()) {
                data = new String[8];
                for (int i = 0; i < data.length; i++)
                    data[i] = rs.getString(i+1);
                
                list = shows.get(data[0]);
                if (list == null) {
                    list = new ArrayList<String[]>();
                }
                list.add(data);
                shows.put(data[0], list);
            }
            
        } catch (Exception e) {
            System.err.println("Failed to Fetch records from database " + dbName);
            return shows;
        }
        
        return shows;
    }
    
    public void clear_shows_table() {
        Statement s;
        int rs;
        try {
            s = conn.createStatement();
            rs = s.executeUpdate("TRUNCATE TABLE SHOWS");
            conn.commit();
        } catch (Exception e) {
            System.err.println("Failed to clear records in database " + dbName);
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
