package lab3application;

import static javax.swing.JOptionPane.showMessageDialog;
import java.text.DecimalFormat;

 public class CarpetCalculator3 { 

    public static void main(String[] args) {
        //this is a program 
        // TODO code application logic here
        DecimalFormat twoDec = new DecimalFormat(".##");
        double squareMetres, totalCost;
        //  assigning those we know the value of
        int roomLength = 6;
        int roomWidth = 4;
        double carpetPrice = 19.99;

        squareMetres = roomLength * roomWidth;
        //calculate the cost
 
        totalCost = squareMetres * carpetPrice;
        //display message
        showMessageDialog(null,
                "The cost of the carpet is £" + twoDec.format(totalCost));
    }

    public static double calculateCost(double roomArea, double carpetPrice) {
        double answer = roomArea * carpetPrice ;
        return answer;
    }

    public double calculateCost2(double roomArea, double carpetPrice) {
        double answer = roomArea + carpetPrice ;
        return answer;
    }    
}

