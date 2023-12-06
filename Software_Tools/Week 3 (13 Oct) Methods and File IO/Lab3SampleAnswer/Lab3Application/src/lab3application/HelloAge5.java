package lab3application;

import javax.swing.JOptionPane;
import java.util.*;

public class HelloAge5 {

    public static void main(String[] args) {

        GregorianCalendar now = new GregorianCalendar();

        String name
                = JOptionPane.showInputDialog("Please type your name");
        String ageStr
                = JOptionPane.showInputDialog("How old will you be at the end of this year");
        int age = Integer.parseInt(ageStr);
        int dobYear = (now.get(Calendar.YEAR) - age);

        JOptionPane.showMessageDialog(null, "Hello " + name + ". You were born in " + dobYear);
    }

}
