import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final int[] a = new int[nextInt2];
        for (int i = 0; i < nextInt2; ++i) {
            a[i] = scanner.nextInt();
        }
        if (nextInt2 == 0) {
            System.out.println(nextInt);
        }
        else {
            Arrays.sort(a);
            int n;
            for (n = 0; a[n] < nextInt; ++n) {}
            int n2 = 0;
            boolean b = true;
            int j;
            for (j = 0; j <= nextInt + 100; ++j) {
                if (nextInt - j != a[Math.max(0, n - n2)]) {
                    break;
                }
                if (nextInt + j != a[Math.min(nextInt2 - 1, n + n2)]) {
                    b = false;
                    break;
                }
                ++n2;
            }
            if (b) {
                System.out.println(nextInt - j);
            }
            else {
                System.out.println(nextInt + j);
            }
        }
    }
}