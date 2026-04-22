import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final Integer[] a = new Integer[nextInt2];
        int abs = 100;
        int x = nextInt;
        for (int i = 0; i < nextInt2; ++i) {
            a[i] = scanner.nextInt();
        }
        for (int j = 0; j <= 200; ++j) {
            if (Math.abs(nextInt - j) < abs && !Arrays.asList(a).contains(j)) {
                abs = Math.abs(nextInt - j);
                x = j;
            }
        }
        System.out.println(x);
    }
}