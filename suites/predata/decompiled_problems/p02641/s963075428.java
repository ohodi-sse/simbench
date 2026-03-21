import java.util.Arrays;
import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final int[] a = new int[nextInt2];
        int n = 0;
        boolean b = false;
        for (int i = 0; i < nextInt2; ++i) {
            a[i] = scanner.nextInt();
            if (a[i] == nextInt) {
                n = 1;
                b = true;
            }
        }
        int n2 = nextInt;
        int n3 = 1;
        Arrays.sort(a);
        for (int n4 = 0; n4 < nextInt2 && n == 1 && n3 == 1; ++n4) {
            n3 = 0;
            n = 0;
            for (int n5 = nextInt2 - 1; n5 >= 0 && n == 0; --n5) {
                if (a[n5] == nextInt + n4) {
                    n3 = 1;
                    n2 = a[n5];
                }
                if (a[n5] == nextInt - n4) {
                    n = 1;
                    n2 = a[n5];
                }
            }
        }
        if (n2 > nextInt && b && n3 == 0) {
            System.out.println(2 * nextInt - n2 - 1);
        }
        if (n2 > nextInt && b && n3 == 1) {
            System.out.println(2 * nextInt - n2);
        }
        if (n2 < nextInt && b && n == 0) {
            System.out.println(n2 - 1);
        }
        if (n2 < nextInt && b && n == 1 && n3 == 0) {
            System.out.println(2 * nextInt - n2);
        }
        if (n2 == nextInt && b) {
            System.out.println(n2 - 1);
        }
        if (!b) {
            System.out.println(nextInt);
        }
    }
}