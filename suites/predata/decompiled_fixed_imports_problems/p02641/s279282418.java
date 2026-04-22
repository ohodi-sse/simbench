import java.util.HashSet;
import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final int[] array2 = new int[nextInt2];
        final HashSet set = new HashSet();
        for (int i = 0; i < nextInt2; ++i) {
            array2[i] = scanner.nextInt();
            set.add(array2[i]);
        }
        int abs = Integer.MAX_VALUE;
        int x = 0;
        for (int j = nextInt; j >= -1000; --j) {
            if (!set.contains(j) && abs > Math.abs(nextInt - j)) {
                abs = Math.abs(nextInt - j);
                x = j;
                break;
            }
        }
        for (int k = nextInt; k <= 1000; ++k) {
            if (!set.contains(k) && abs > Math.abs(nextInt - k)) {
                Math.abs(nextInt - k);
                x = k;
                break;
            }
        }
        System.out.println(x);
    }
}