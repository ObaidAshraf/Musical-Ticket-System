
import static javax.swing.JOptionPane.*;

class CarpetCalculator1 {

    public static void main(String[] args) {
        final String BEST_CARPET = "Berber";
        final String ECONOMY_CARPET = "Pile";

        int roomLength = 4;
        int roomWidth = 3;
        int roomArea = roomLength * roomWidth;

        double carpetPrice, totalCost;

        // best carpet
        carpetPrice = 27.95;
        totalCost = roomArea * carpetPrice;
        showMessageDialog(null,
                "The cost of " + BEST_CARPET + " is £" + totalCost);

        // economy carpet
        carpetPrice = 15.95;
        totalCost = roomArea * carpetPrice;
        showMessageDialog(null,
                "The cost of " + ECONOMY_CARPET + " is £" + totalCost);
    }
}