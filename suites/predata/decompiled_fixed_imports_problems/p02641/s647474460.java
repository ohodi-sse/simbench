import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final int[] array2 = new int[nextInt2];
        int x = nextInt;
        if (nextInt2 == 0) {
            System.out.println(nextInt);
            System.exit(0);
        }
        for (int i = 0; i < nextInt2; ++i) {
            array2[i] = scanner.nextInt();
        }
        for (int j = 0; j <= 100; ++j) {
            boolean b = true;
            for (int k = 0; k < nextInt2; ++k) {
                if (x == array2[k]) {
                    b = false;
                }
            }
            if (b) {
                System.out.println(x);
                System.exit(0);
            }
            if (j % 2 == 0) {
                x -= j + 1;
            }
            else {
                x += j + 1;
            }
        }
    }
}