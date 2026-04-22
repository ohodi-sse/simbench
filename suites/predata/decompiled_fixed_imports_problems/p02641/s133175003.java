import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        if (nextInt2 == 0) {
            System.out.println(nextInt);
            return;
        }
        final int[] array2 = new int[102];
        for (int i = 0; i < nextInt2; ++i) {
            array2[scanner.nextInt()] = 1;
        }
        int n = 999;
        int x = 0;
        for (int j = 0; j <= 101; ++j) {
            if (array2[j] != 1) {
                final int abs = Math.abs(nextInt - j);
                if (abs < n) {
                    n = abs;
                    x = j;
                }
            }
        }
        System.out.println(x);
    }
}