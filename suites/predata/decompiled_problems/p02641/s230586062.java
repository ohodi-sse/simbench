import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final boolean[] array2 = new boolean[201];
        for (int i = 0; i < nextInt2; ++i) {
            array2[scanner.nextInt()] = true;
        }
        int min = 500;
        int n = 500;
        for (int j = 0; j <= 200; ++j) {
            if (!array2[j]) {
                final int abs = Math.abs(nextInt - j);
                if (abs < n) {
                    min = j;
                    n = abs;
                }
                else if (abs == n) {
                    min = Math.min(min, j);
                }
            }
        }
        System.out.println(min);
    }
}