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
        int x = nextInt;
        Boolean b = true;
        for (int n = 0; n <= nextInt && b; ++n) {
            if (!Arrays.asList(array2).contains(nextInt - n)) {
                x = nextInt - n;
                b = false;
            }
            else if (!Arrays.asList(array2).contains(nextInt + n)) {
                x = nextInt + n;
                b = false;
            }
        }
        System.out.println(x);
    }
}