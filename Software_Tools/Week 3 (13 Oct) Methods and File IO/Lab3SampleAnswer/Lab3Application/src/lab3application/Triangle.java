import javax.swing.JOptionPane;

class Triangle {

    public static void main(String[] args) {
        // Get the three sides of the triangle from the command line.
        // Assume that these are correctly typed
        String lengthStr;
        lengthStr = JOptionPane.showInputDialog("length a?");
        double a = Double.parseDouble(lengthStr);
        lengthStr = JOptionPane.showInputDialog("length b?");
        double b = Double.parseDouble(lengthStr);
        lengthStr = JOptionPane.showInputDialog("length c?");
        double c = Double.parseDouble(lengthStr);

        // Use a well-known mathematical formula to calculate the area
        //double s = (a + b + c) / 2;
        //double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        double area = findArea(a,b,c);
        // We use the square root function sqrt from the library class
        // Math. This has many static mathematical functions like sin,
        // cos, random (for random numbers) etc.
        // Here we assume that s * (s - a) * (s - b) * (s - c) is not
        // negative - if it is, e.g. if a = b = 1.0 and c = 3.0, an
        // error will occur.

        System.out.println(
                "Triangle with sides " + a + ", " + b + ", " + c + " has area " + area);
    }
    
    private static double findArea (double a, double b,double c){
        double ar,s=0;
        s = (a + b + c) / 2;
        ar = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        return ar;
    }
}
