import static javax.swing.JOptionPane.*;

class CarRepair2 {

    public static void main(String[] args) {
        String partsStr = showInputDialog("What is the parts cost");
        String hoursStr = showInputDialog("How many hours");
        String costStr =
                showInputDialog("What is the labour cost per hour");
        String vatStr =
                showInputDialog("What is the current VAT rate");
        double parts = Double.parseDouble(partsStr);
        double hours = Double.parseDouble(hoursStr);
        double cost = Double.parseDouble(costStr);
        double vat = Double.parseDouble(vatStr);
        // calculate bill before VAT
        double bill = parts + hours * cost;
        // add VAT. Note how it is calculated
        bill = bill * (1 + vat / 100);
        showMessageDialog(null, "Your bill is £" + bill);
    }
}