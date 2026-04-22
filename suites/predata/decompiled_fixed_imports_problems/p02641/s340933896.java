import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final String[] array2 = new String[nextInt2];
        for (int i = 0; i < nextInt2; ++i) {
            array2[i] = scanner.next();
        }
        for (int j = 0; j <= 51; ++j) {
            final int k = nextInt - j;
            final int l = nextInt + j;
            final String value = String.valueOf(k);
            final String value2 = String.valueOf(l);
            if (!Arrays.asList(array2).contains(value)) {
                System.out.println(nextInt - j);
                return;
            }
            if (!Arrays.asList(array2).contains(value2)) {
                System.out.println(nextInt + j);
                return;
            }
        }
        scanner.close();
    }
}