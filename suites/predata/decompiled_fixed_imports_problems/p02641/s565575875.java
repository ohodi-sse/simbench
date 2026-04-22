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
        Arrays.sort(a);
        while (true) {
            int n;
            for (n = 0; Arrays.binarySearch(a, nextInt - n) >= 0; ++n) {
                if (Arrays.binarySearch(a, nextInt + n) < 0) {
                    final int x = nextInt + n;
                    System.out.println(x);
                    return;
                }
            }
            final int x = nextInt - n;
            continue;
        }
    }
}