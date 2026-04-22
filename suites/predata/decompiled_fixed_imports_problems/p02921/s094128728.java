import java.util.Scanner;

public class Main
{
    private static final Scanner sc;
    
    public static void main(final String[] array) {
        final String next = Main.sc.next();
        final String next2 = Main.sc.next();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (next2.charAt(i) == next.charAt(i)) {
                ++x;
            }
        }
        System.out.println(x);
    }
    
    static {
        sc = new Scanner(System.in);
    }
}