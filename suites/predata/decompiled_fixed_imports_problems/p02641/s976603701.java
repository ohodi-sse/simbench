import java.util.HashSet;
import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final HashSet set = new HashSet();
        for (int i = 0; i < nextInt2; ++i) {
            set.add(scanner.nextInt());
        }
        int n = 200;
        int x = 0;
        for (int j = 0; j <= 101; ++j) {
            if (!set.contains(j)) {
                final int abs = Math.abs(j - nextInt);
                if (abs < n) {
                    n = abs;
                    x = j;
                }
            }
        }
        System.out.println(x);
    }
}