import java.util.Scanner;





public class Main
{
    static Scanner scanner;
    
    public static void main(final String[] array) {
        Main.scanner = new Scanner(System.in);
        final String gs = gs();
        final String gs2 = gs();
        int i = 0;
        for (int j = 0; j < 3; ++j) {
            if (gs.charAt(j) == gs2.charAt(j)) {
                ++i;
            }
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