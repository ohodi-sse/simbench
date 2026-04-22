import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final int[] a = new int[nextInt2];
        for (int i = 0; i < nextInt2; ++i) {
            final int nextInt3 = scanner.nextInt();
            if (nextInt3 < nextInt) {
                a[i] = Math.abs(nextInt - nextInt3) * 2;
            }
            else {
                a[i] = Math.abs(nextInt - nextInt3) * 2 + 1;
            }
        }
        Arrays.sort(a);
        int n = 1;
        for (int n2 = 0; n2 < nextInt2 && a[n2] == n; ++n, ++n2) {}
        int x;
        if (n % 2 == 0) {
            x = nextInt - n / 2;
        }
        else {
            x = nextInt + n / 2;
        }
        System.out.println(x);
    }
}