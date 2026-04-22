import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final int[] array2 = new int[nextInt2];
        final int[] array3 = new int[102];
        for (int i = 0; i <= 101; ++i) {
            array3[i] = i;
        }
        for (int j = 0; j < nextInt2; ++j) {
            array3[array2[j] = scanner.nextInt()] = -1;
        }
        int abs = 99999;
        int k = 0;
        if (nextInt2 == 0) {
            k = nextInt;
        }
        for (int l = 0; l <= 101; ++l) {
            if (array3[l] != -1 && Math.abs(l - nextInt) < abs) {
                k = l;
                abs = Math.abs(l - nextInt);
            }
        }
        System.out.print(k);
    }
}