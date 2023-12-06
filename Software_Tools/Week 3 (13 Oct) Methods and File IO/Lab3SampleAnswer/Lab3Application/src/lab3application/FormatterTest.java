import java.util.Formatter;
import static javax.swing.JOptionPane.*;

class FormatterTest {

    public static void main(String[] args) {
        Formatter formatter = new Formatter();
        formatter.format("%d = %#o = %#X", 10, 10, 10);
        //argument to format is just like argument to printf
        showMessageDialog(null, formatter.toString());
    }
}
