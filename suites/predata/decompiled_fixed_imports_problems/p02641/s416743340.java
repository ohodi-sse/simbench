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
        final int[] array2 = new int[nextInt2];
        for (int i = 0; i < nextInt2; ++i) {
            array2[i] = scanner.nextInt();
        }
        int x = nextInt;
        for (int j = 0; j < 101; ++j) {
            boolean b = true;
            for (int k = 0; k < nextInt2; ++k) {
                if (array2[k] == x) {
                    b = false;
                }
            }
            if (b) {
                System.out.println(x);
                return;
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