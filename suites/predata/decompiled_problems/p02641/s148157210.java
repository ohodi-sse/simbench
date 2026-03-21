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
        int j = nextInt;
        int n = nextInt;
        while (true) {
            while (set.contains(j)) {
                int x;
                if (!set.contains(n - 1)) {
                    x = n - 1;
                }
                else {
                    if (set.contains(j + 1)) {
                        ++j;
                        --n;
                        continue;
                    }
                    x = j + 1;
                }
                System.out.println(x);
                return;
            }
            int x = j;
            continue;
        }
    }
}