import static javax.swing.JOptionPane.*;
import java.util.*;

class DateDemo {

    public static void main(String[] args) {
        GregorianCalendar now = new GregorianCalendar();
        int thisYear = now.get(Calendar.YEAR);
        showMessageDialog(null, "This year is " + thisYear);
    }
}
