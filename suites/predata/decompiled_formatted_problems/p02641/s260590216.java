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
        final int[] array2 = new int[100];
        for (int i = 0; i < 100; ++i) {
            array2[i] = 0;
        }
        for (int j = 0; j < nextInt2; ++j) {
            array2[scanner.nextInt() - 1] = 1;
        }
        int x = 101;
        for (int k = nextInt - 1; k < 100; ++k) {
            if (array2[k] == 0) {
                x = k + 1;
                break;
            }
        }
        int l = nextInt - 1;
        while (l >= 0) {
            if (array2[l] == 0) {
                if (Math.abs(nextInt - x) < Math.abs(nextInt - (l + 1))) {
                    break;
                }
                x = l + 1;
                break;
            }
            else {
                if (l == 0 && Math.abs(nextInt - x) >= nextInt) {
                    x = 0;
                }
                --l;
            }
        }
        System.out.println(x);
    }
}