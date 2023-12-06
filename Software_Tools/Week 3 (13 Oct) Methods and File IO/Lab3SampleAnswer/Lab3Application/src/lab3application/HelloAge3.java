import javax.swing.JOptionPane;
import static java.lang.System.*;

class HelloAge3 {

    public static void main(String[] args) {
        String name =
                JOptionPane.showInputDialog("Please type your name");
        String ageStr =
                JOptionPane.showInputDialog("Please type your age");
        int age = Integer.parseInt(ageStr);
        out.println("Hello " + age + " year old " + name);
    }
}