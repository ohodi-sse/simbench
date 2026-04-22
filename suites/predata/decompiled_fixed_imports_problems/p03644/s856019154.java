import java.util.Scanner;

public class Main
{
    static Scanner scanner;
    
    public static void main(final String[] array) {
        Main.scanner = new Scanner(System.in);
        final int gi = gi();
        int i = 1;
        for (int n = 0; Math.pow(2.0, n) <= gi; ++n) {
            i = (int)Math.pow(2.0, n);
        }
        System.out.print(i);
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