import java.util.Arrays;
import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final Integer[] array2 = new Integer[nextInt2];
        for (int i = 0; i < nextInt2; ++i) {
            array2[i] = scanner.nextInt();
        }
        while (true) {
            int n;
            for (n = 0; Arrays.asList(array2).contains(nextInt - n); ++n) {
                if (!Arrays.asList(array2).contains(nextInt + n)) {
                    final int n2 = n;
                    System.out.println(nextInt + n2);
                    return;
                }
            }
            final int n2 = -n;
            continue;
        }
    }
}