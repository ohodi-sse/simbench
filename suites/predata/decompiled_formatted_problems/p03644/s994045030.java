import java.util.Scanner;





public class Main
{
    private static Scanner sc;
    
    public static void main(final String[] array) {
        final int nextInt = Main.sc.nextInt();
        int x = 1;
        int n = 0;
        for (int i = 2; i <= nextInt; ++i) {
            int n2;
            int n3;
            for (n2 = i, n3 = 0; n2 % 2 == 0; n2 /= 2, ++n3) {}
            if (n < n3) {
                n = n3;
                x = i;
            }
        }
        System.out.println(x);
    }
    
    static {
        Main.sc = new Scanner(System.in);
    }
}