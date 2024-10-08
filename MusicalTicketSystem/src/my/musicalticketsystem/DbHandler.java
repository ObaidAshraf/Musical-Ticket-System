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
import java.util.regex.Pattern;
/**
 *
 * @brief: A class to handle connection and data insertion/retrieval into/from Derby Database
 * 
 */
public class DbHandler {
    
    /**
     * Some private class variables
     */
    private String framework = "embedded";
    private String protocol = "jdbc:derby://localhost:1527/";
    private String dbName = "MusicalTicketSystem";
    Connection conn = null;
    
    /**
     * @brief: A method to construct a connection with the database
     */
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
            dialogBox dbox = new dialogBox();
            dbox.show_dialog("Failed to connect to database " + dbName);
        }
    }
    
    /**
     * @brief: A method to insert a record into database
     * @param record 
     */
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
    
    /**
     * @brief: Method to retrieve records from database
     * @return Map containing records
     */
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
    
    /**
     * 
     * @brief: Method to retrieve records from database based on some filter
     * @param pattern
     * @param column
     * @return Map containing records
     */
    public HashMap<String, ArrayList<String[]>> fetch_filtered_records_from_db(String pattern, String column) {
        HashMap<String, ArrayList<String[]>> shows = new HashMap<>();
        Statement s;
        ResultSet rs = null;
        ArrayList<String[]> list;
        String[] data;
        try {
            s = conn.createStatement();
            if (column.equals("price")) {
                if (!Pattern.matches("[0-9]+", pattern)) {
                    dialogBox dbox = new dialogBox();
                    dbox.show_dialog("Invalid price");
                    return shows;
                }
            }
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
    
    /**
     * @brief: Method to clear table containing records
     */
    public void clear_shows_table() {
        Statement s;
        int rs;
        try {
            s = conn.createStatement();
            rs = s.executeUpdate("TRUNCATE TABLE SHOWS");
            conn.commit();
        } catch (Exception e) {
            System.err.println("Failed to clear records in database " + dbName);
            dialogBox dbox = new dialogBox();
            dbox.show_dialog("Failed to clear records in database " + dbName);
        }
    }
    
    /**
     * @brief: Close connection with database
     */
    public void close_db_connection() {
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    
}
