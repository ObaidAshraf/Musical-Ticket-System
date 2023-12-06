
import javax.swing.*;

class HelloAge2 {

    public static void main(String[] args) {
        String name =
                JOptionPane.showInputDialog("Please type your name");
        String ageStr =
                JOptionPane.showInputDialog("Please type your age");
        int age = Integer.parseInt(ageStr);
        JOptionPane.showMessageDialog(null,
                "Hello " + age + " year old " + name);
    }
}