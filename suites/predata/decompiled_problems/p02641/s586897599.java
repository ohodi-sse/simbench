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
        scanner.close();
        int n;
        for (n = 0; Arrays.asList(array2).contains(String.valueOf(nextInt - n)); ++n) {
            if (!Arrays.asList(array2).contains(String.valueOf(nextInt + n))) {
                System.out.println(nextInt + n);
                return;
            }
        }
        System.out.println(nextInt - n);
    }
}