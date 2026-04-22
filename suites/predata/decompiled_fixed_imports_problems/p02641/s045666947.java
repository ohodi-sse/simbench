import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final Integer[] a = new Integer[nextInt2];
        int n = 1000;
        int x = 0;
        for (int i = 0; i < nextInt2; ++i) {
            a[i] = scanner.nextInt();
        }
        scanner.close();
        for (int j = 0; j < nextInt * 2; ++j) {
            if (!Arrays.asList(a).contains(j)) {
                final int abs = Math.abs(nextInt - j);
                if (n > abs) {
                    n = abs;
                    x = j;
                }
            }
        }
        System.out.println(x);
    }
}