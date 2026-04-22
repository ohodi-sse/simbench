import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        try (final Scanner scanner = new Scanner(System.in)) {
            final int nextInt = scanner.nextInt();
            final int nextInt2 = scanner.nextInt();
            final int[] array2 = new int[102];
            for (int i = 0; i <= 101; ++i) {
                array2[i] = Math.abs(nextInt - i);
            }
            for (int j = 0; j < nextInt2; ++j) {
                array2[scanner.nextInt()] = Integer.MAX_VALUE;
            }
            int x = 0;
            int n = array2[0];
            for (int k = 1; k <= 101; ++k) {
                if (array2[k] < n) {
                    x = k;
                    n = array2[k];
                }
            }
            System.out.println(x);
        }
    }
}