import static javax.swing.JOptionPane.*;

class CarRepair {

    public static void main(String[] args) {
        String partsStr = showInputDialog("What is the parts cost");
        String hoursStr = showInputDialog("How many hours");
        double parts = Double.parseDouble(partsStr);
        double hours = Double.parseDouble(hoursStr);
        // calculate bill before VAT
        double bill = parts + hours * 20;
        // add VAT
        bill = bill * 1.175;
        showMessageDialog(null, "Your bill is £" + bill);
    }
}