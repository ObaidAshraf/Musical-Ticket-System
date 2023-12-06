import static java.lang.System.*;

class Formatted {

    public static void main(String[] args) {
        // integer conversion examples
        out.printf("%d\n", 26);
        out.printf("%d\n", +26);
        out.printf("%d\n", -26);
        out.printf("%o\n", 26);
        out.printf("%x\n", 26);
        out.printf("%X\n", 26);
        out.println();

        // floating and fixed point conversion examples
        out.printf("%e\n", 12345678.9);
        out.printf("%e\n", +12345678.9);
        out.printf("%e\n", -12345678.9);
        out.printf("%E\n", 12345678.9);
        out.printf("%f\n", 12345678.9);
        out.println();

        // printing Strings, Characters and Integers
        char character = 'A';
        String string = "Another string";
        Integer integer = 1234;
        out.printf("%c\n", character);
        out.printf("%s\n", "This is a string");
        out.printf("%s\n", string);
        out.printf("%S\n", string);
        out.printf("%s\n", integer); // implicitly calls toString
        out.println();

        // dates and times - first, get current date and time
        java.util.Calendar dateTime = java.util.Calendar.getInstance();
        out.printf("%tc\n", dateTime);
        out.printf("%tF\n", dateTime);
        out.printf("%tD\n", dateTime);
        out.printf("%tr\n", dateTime);
        out.printf("%tT\n", dateTime);
        out.println();

        // other conversions
        Object test = null;
        out.printf("%b\n", false);
        out.printf("%b\n", true);
        out.printf("%b\n", "Test");
        out.printf("%B\n", test);
        out.printf("Hashcode of \"hello\" is %h\n", "hello");
        out.printf("Hashcode of \"Hello\" is %h\n", "Hello");
        out.printf("Printing %%\n");
        out.printf("Another way of printing a new line%nnext line%n");
        out.println();

        // right justifying integers - width 4 used here
        out.printf("%4d\n", 1);
        out.printf("%4d\n", 12);
        out.printf("%4d\n", 123);
        out.printf("%4d\n", 1234);
        out.printf("%4d\n", 12345); // too big
        out.println();
        out.printf("%4d\n", -1);
        out.printf("%4d\n", -12);
        out.printf("%4d\n", -123);
        out.printf("%4d\n", -1234);  // too big
        out.printf("%4d\n", -12345); // too big
        out.println();

        // Precision for floating point numbers
        double f = 123.98765;
        out.printf("%.3f\n%.3e\n", f, f);
        out.println();

        // Using flags: the - flag for left justification
        out.printf("%10s%10d%10c%10f\n", "hello", 7, 'a', 1.23);
        out.printf("%-10s%-10d%-10c%-10f\n", "hello", 7, 'a', 1.23);
        out.println();

        // Using flags: the + and space flags
        out.printf("%d\t%d\n", 78, -78);
        out.printf("%+d\t%+d\n", 78, -78);
        out.printf("% d\t% d\n", 78, -78);
        out.println();

        // Using flags - filling in leading zeros
        out.printf("%+09d\n", 452);
        out.printf("%09d\n", 452);
        out.printf("% 09d\n", 452);
        out.println();

        // Using the , flag to display numbers
        out.printf("%,d\n", 12345);
        out.printf("%,.2f\n", 12345.214);
        out.printf("%,.2f\n", 123456789.215);
        out.println();
    }
}
