import java.util.Scanner;





public class Main
{
    static Scanner scanner;
    
    public static void main(final String[] array) {
        Main.scanner = new Scanner(System.in);
        final String value = String.valueOf(gl() * Math.round(gd() * 100.0));
        if (value.length() <= 2) {
            System.out.print("0");
            return;
        }
        for (int i = 0; i < value.length() - 2; ++i) {
            System.out.print(value.charAt(i));
        }
    }
    
    public static String gs() {
        return Main.scanner.next();
    }
    
    public static int gi() {
        return Integer.parseInt(Main.scanner.next());
    }
    
    public static long gl() {
        return Long.parseLong(Main.scanner.next());
    }
    
    public static double gd() {
        return Double.parseDouble(Main.scanner.next());
    }
}