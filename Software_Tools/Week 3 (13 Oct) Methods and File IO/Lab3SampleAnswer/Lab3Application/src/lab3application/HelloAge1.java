import javax.swing.*;

class HelloAge1 {

    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("Input?");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Input?"));
        System.out.println("Hello " + age + " year old " + name);
    }
}