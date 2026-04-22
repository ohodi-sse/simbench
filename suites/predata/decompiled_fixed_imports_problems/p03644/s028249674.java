import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        int x = 1;
        int n = 0;
        for (int i = 2; i <= nextInt; ++i) {
            int n2;
            for (n2 = 1; i % Math.pow(2.0, n2) == 0.0 && Math.pow(2.0, n2) < i; ++n2) {}
            if (n2 > n) {
                n = n2;
                x = i;
            }
        }
        System.out.println(x);
    }
}