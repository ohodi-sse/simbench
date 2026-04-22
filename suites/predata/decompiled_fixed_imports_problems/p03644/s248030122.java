import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        int x = 0;
        int a = 0;
        for (int i = 1; i <= nextInt; ++i) {
            int n;
            int b;
            for (n = i, b = 0; n % 2 == 0; n /= 2, ++b) {}
            if (Math.max(a, b) == b) {
                x = i;
                a = b;
            }
        }
        System.out.println(x);
    }
}