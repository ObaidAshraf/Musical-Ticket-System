/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.musicalticketsystem;
import java.util.*;
import java.io.*;
import java.text.*;

/**
 *
 * @author Administrator
 * @brief: A class serving as glue between DbHandler and MusicalTicketSystem classes
 */
public class MusicalDataHandler {
    
    /**
     * @brief Method to read CSV file and insert records into Database
     * @param filename 
     */
    public void read_data_and_insert_into_db(String filename) {
        ArrayList<String[]> list;
        String[] data;
        
        DbHandler dbHandler = new DbHandler();
        try {
            dbHandler.setup_db_connection();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 0 || values.length != 8) {
                    dialogBox dbox = new dialogBox();
                    dbox.show_dialog("File is invalid");
                    return;
                }
                data = new String[] {values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7]};
                dbHandler.insert_record_into_db(data);
            }
        }
        catch (IOException e) {  
            e.printStackTrace();  
        } 
        
    }
    
    /**
     * @brief Method to fetch recrods from Database
     * @return Map containing records
     */
    public HashMap<String, ArrayList<String[]>> get_records_from_db() {
        HashMap<String, ArrayList<String[]>> shows =  new HashMap<String, ArrayList<String[]>>();
        DbHandler dbHandler = new DbHandler();

        try {
            dbHandler.setup_db_connection();
        } catch (Exception e) {
            e.printStackTrace();
            return shows;
        }
        
        shows = dbHandler.fetch_records_from_db();
        return shows;
    }
    
    /**
     * @brief Method to fetch records from database based on provided filter
     * @param pattern
     * @param column
     * @return 
     */
    public HashMap<String, ArrayList<String[]>> get_filtered_records_from_db(String pattern, String column) {
        HashMap<String, ArrayList<String[]>> shows =  new HashMap<String, ArrayList<String[]>>();
        DbHandler dbHandler = new DbHandler();

        try {
            dbHandler.setup_db_connection();
        } catch (Exception e) {
            e.printStackTrace();
            return shows;
        }
        
        shows = dbHandler.fetch_filtered_records_from_db(pattern, column);
        return shows;
    }
    
    /**
     * @brief Method to clear all records from Database
     */
    public void clear_all_records() {
        DbHandler dbHandler = new DbHandler();
        try {
            dbHandler.setup_db_connection();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        dbHandler.clear_shows_table();
    }
    
    /**
     * @brief Method to generate and save receipt (as text file)
     * @param cName
     * @param customer_data 
     */
    public void save_receipt(String cName, ArrayList<String[]> customer_data) {
        String[] data;
        boolean hdr_written = false;
        int total_amount = 0;
        String dateTime = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String filename = cName + "_receipt_" + dateTime + ".txt";
        String data_line = "";
//        System.out.println(cName + " has " + customer_data.size() + " tickets.");

        try {
            File receiptFile = new File(filename);
            if (!receiptFile.createNewFile()) {
                System.out.println("Failed to create receipt file");            
                dialogBox dbox = new dialogBox();
                dbox.show_dialog("Failed to create receipt file");
                return;
            }
        
            FileWriter fwriter = new FileWriter(filename);
            for(int k = 0; k < customer_data.size(); k++) {
              data = customer_data.get(k);
              total_amount += Integer.parseInt(data[data.length-1]);
              if (!hdr_written) {
                fwriter.write("Customer Name: " + data[0] + "\n");
                fwriter.write("Customer Email: " + data[1] + "\n");
                fwriter.write("---------------------------------------------------------------\n");
                fwriter.write("Show Title | Show Date | Show Time | Ticket | Seat No | Price |\n");
                fwriter.write("---------------------------------------------------------------\n");
                hdr_written = true;
              }
              for (int j = 2; j < data.length-1; j++) {
                  fwriter.write(data[j] + " | ");
              }
              fwriter.write("\u00A3" + data[data.length-1] + " | ");
              fwriter.write('\n');
            }
        
            fwriter.write("\n\n");
            fwriter.write("Total Amount (in \u00A3): " + total_amount + "\n");
            fwriter.write("---------------------------------------------------------------\n");
            fwriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
