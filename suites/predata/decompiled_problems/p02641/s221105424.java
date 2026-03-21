import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        if (nextInt2 == 0) {
            System.out.println(nextInt);
        }
        else {
            final int[] array2 = new int[nextInt2];
            for (int i = 0; i < array2.length; ++i) {
                array2[i] = scanner.nextInt();
            }
            do {
                for (int j = 0; j < array2.length; ++j) {
                    if (array2[j] == nextInt + n3) {
                        ++n3;
                    }
                }
            } while (++n <= n3);
            do {
                for (int k = 0; k < array2.length; ++k) {
                    if (array2[k] == nextInt + n4) {
                        --n4;
                    }
                }
            } while (--n2 >= n4);
            final int n5 = n3 + n4;
            if (n5 >= 0) {
                System.out.println(nextInt + n4);
            }
            else if (n5 < 0) {
                System.out.println(nextInt + n3);
            }
        }
    }
}