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
 */
public class MusicalDataHandler {
    
    public HashMap<String, ArrayList<String[]>> read_data() {
        HashMap<String, ArrayList<String[]>> shows = new HashMap<>();
        ArrayList<String[]> list;
        String[] data;
        
        DbHandler dbHandler = new DbHandler();
        try {
            dbHandler.setup_db_connection();
        } catch (Exception e) {
            e.printStackTrace();
            return shows;
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader("shows.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                list = shows.get((String)values[0]);
                if (list == null) {
                    list = new ArrayList<String[]>();
                }
                data = new String[] {values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7]};
                list.add(data);
                shows.put(values[0], list);
                dbHandler.insert_record_into_db(data);
            }
        }
        catch (IOException e) {  
            dbHandler.close_db_connection();
            e.printStackTrace();  
        } 
        
        dbHandler.close_db_connection();
        return shows;
    }
    
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
            return;
        }
    }
    
    
}
