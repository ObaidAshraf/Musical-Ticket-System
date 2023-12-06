
import static javax.swing.JOptionPane.*;
import java.text.DecimalFormat;

class PoundsDemo {

    public static void main(String[] args) {
        DecimalFormat pounds = new DecimalFormat("£###,##0.00");
        double amount1 = 12345.667;
        double amount2 = 551.0204475308642;
        double amount3 = 314.4463734567901;
        showMessageDialog(null, "Amount 1 is " + pounds.format(amount1));
        showMessageDialog(null, "Amount 2 is " + pounds.format(amount2));
        showMessageDialog(null, "Amount 3 is " + pounds.format(amount3));
    }
}
