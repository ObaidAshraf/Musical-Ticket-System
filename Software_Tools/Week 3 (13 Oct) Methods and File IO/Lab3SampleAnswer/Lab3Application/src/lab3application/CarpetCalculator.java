import static javax.swing.JOptionPane.*;

class CarpetCalculator {

    public static void main(String[] args) {
        //declaring the types of variables we will use
        double squareMetres, totalCost;
        //  assigning those we know the value of
        int roomLength = 6;
        int roomWidth = 4;
        double carpetPrice = 19.99;
        //calculate the area
        squareMetres = roomLength * roomWidth;
        //calculate the cost
        totalCost = squareMetres * carpetPrice;
        //display message
        showMessageDialog(null,
                "The cost of the carpet is £" + totalCost);
    }
}
