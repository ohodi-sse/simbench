import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final int[] array2 = new int[nextInt2];
        final int n = nextInt;
        int x = nextInt;
        int x2 = nextInt;
        int n2 = 0;
        for (int i = 0; i < nextInt2; ++i) {
            array2[i] = scanner.nextInt();
        }
        for (int j = 0; j < nextInt2 + 1; ++j) {
            for (int k = 0; k < nextInt2; ++k) {
                if (array2[k] != nextInt) {
                    ++n2;
                }
            }
            if (n2 == nextInt2) {
                x = nextInt;
                break;
            }
            n2 = 0;
            --nextInt;
        }
        int n3 = n;
        int n4 = 0;
        for (int l = 0; l < nextInt2 + 1; ++l) {
            for (int n5 = 0; n5 < nextInt2; ++n5) {
                if (array2[n5] != n3) {
                    ++n4;
                }
            }
            if (n4 == nextInt2) {
                x2 = n3;
                break;
            }
            n4 = 0;
            ++n3;
        }
        if (n - x <= x2 - n) {
            System.out.println(x);
        }
        else {
            System.out.println(x2);
        }
    }
}