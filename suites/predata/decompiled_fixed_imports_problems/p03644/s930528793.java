import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        int max = 1;
        for (int n = nextInt; 0 < n; --n) {
            int b = 0;
            for (int n2 = 2; n % n2 == 0; n2 *= 2) {
                b = n2;
            }
            max = Math.max(max, b);
        }
        System.out.println(max);
    }
}