import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        if (nextInt2 == 0) {
            System.out.println(nextInt);
            System.exit(0);
        }
        final int[] array2 = new int[102];
        for (int i = 0; i < nextInt2; ++i) {
            array2[scanner.nextInt()] = 1;
        }
        int n = 0;
        int x = 0;
        for (int j = 0; j <= 101; ++j) {
            if (array2[j] != 1) {
                final int abs = Math.abs(nextInt - j);
                if (j == 0) {
                    n = abs;
                }
                if (n > abs) {
                    n = abs;
                    x = j;
                }
            }
        }
        System.out.println(x);
    }
}