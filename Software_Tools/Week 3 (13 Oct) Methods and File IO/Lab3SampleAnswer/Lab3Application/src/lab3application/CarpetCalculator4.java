package lab3application;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class CarpetCalculator4 {

    public static void main(String[] args) {
        // TODO code application logic here

        final String BEST_CARPET = "Berber";
        final String ECONOMY_CARPET = "Pile";

        String roomLengthStr
                = showInputDialog("What is the room length (m)");
        String roomWidthStr
                = showInputDialog("What is the room width (m)");

        int roomLength = Integer.parseInt(roomLengthStr);
        int roomWidth = Integer.parseInt(roomWidthStr);
        int roomArea = roomLength * roomWidth;

        double carpetPrice, totalCost;

        // best carpet
        carpetPrice = 37.95;
        double answer = CarpetCalculator3.calculateCost(roomArea, carpetPrice);
        totalCost = answer;
        showMessageDialog(null,
                "The cost of " + BEST_CARPET + " is £" + totalCost);
        // economy carpet
        carpetPrice = 16.95;
        double economyAnswer = CarpetCalculator3.calculateCost(roomArea, carpetPrice);
        totalCost = economyAnswer;
        showMessageDialog(null,
                "The cost of " + ECONOMY_CARPET + " is £" + totalCost);
    }

}
