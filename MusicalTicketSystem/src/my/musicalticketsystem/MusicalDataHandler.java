/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.musicalticketsystem;
import java.util.*;
import java.io.*;

/**
 *
 * @author Administrator
 */
public class MusicalDataHandler {
    
    public HashMap<String, ArrayList<String[]>> read_data() {
        HashMap<String, ArrayList<String[]>> shows = new HashMap<>();
        ArrayList<String[]> list;
        String[] data;
        
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
            }
        }
        catch (IOException e) {  
            e.printStackTrace();  
        } 
        return shows;
    }
    
}
