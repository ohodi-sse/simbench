import java.util.Scanner;

public class Main
{
    public static Scanner Scan;
    
    public static void main(final String[] array) {
        final String next = Main.Scan.next();
        int b = 0;
        int max = 0;
        for (int i = 0; i < next.length(); ++i) {
            if (next.charAt(i) == 'R') {
                ++b;
            }
            else {
                b = 0;
            }
            max = Math.max(max, b);
        }
        System.out.println(max);
    }
    
    static {
        Main.Scan = new Scanner(System.in);
    }
}