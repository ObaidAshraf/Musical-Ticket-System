package lab3application;

import javax.swing.JOptionPane.*;
import java.util.*;
import javax.swing.JOptionPane;

public class Tank {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner keyboard = new Scanner(System.in);

        String strLong;
        String strWide;
        String strDeep;
        //double volTank = 0;
            
        JOptionPane.showMessageDialog(null, "This application to calculate the volume of fish tank in mm");
        // enter the variables long, wide and deep as well
        strLong = JOptionPane.showInputDialog("please enter the long size");
        long longSize = Long.parseLong(strLong); // convert string to long number
        strWide = JOptionPane.showInputDialog("please enter the wide size");
        long wideSize = Long.parseLong(strWide); // convert string to long number
        strDeep = JOptionPane.showInputDialog("please enter the deep size");
        long deepSize = Long.parseLong(strDeep); // convert string to long number
        // calculate the volume of the tank
        long volTank =Math.round(calculateVolume(longSize,wideSize,deepSize));
        //volTank = Math.round((longSize * wideSize * deepSize) / 1000000);
        //System.out.print(volTank);
        JOptionPane.showMessageDialog(null, "The volume to the nearset liter is" + volTank);
    }
    
    
    private static long calculateVolume (long l,long w, long d){
        
        long volume=0;
        volume = l*w*d;
        return volume;
    }

}
