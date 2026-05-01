import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        int x = 110;
        final int[] array2 = new int[110];
        if (nextInt2 != 0) {
            for (int i = 0; i < nextInt2; ++i) {
                final int nextInt3 = scanner.nextInt();
                array2[nextInt3] = nextInt3;
            }
            int n = 110;
            for (int j = 0; j <= 101; ++j) {
                final int abs = Math.abs(nextInt - j);
                if (array2[j] == 0 && abs < n) {
                    n = abs;
                    x = j;
                }
            }
        }
        else {
            x = nextInt;
        }
        System.out.println(x);
    }
}