import static javax.swing.JOptionPane.*;

class HelloAge4 {

    public static void main(String[] args) {
        String name =
                showInputDialog("Please type your name");
        String ageStr =
                showInputDialog("Please type your age");
        int age = Integer.parseInt(ageStr);
        showMessageDialog(null,
                "Hello " + age + " year old " + name);
    }
}