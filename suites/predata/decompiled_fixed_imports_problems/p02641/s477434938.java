import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        if (nextInt2 == 0) {
            System.out.println(String.valueOf(nextInt));
            return;
        }
        final ArrayList list = new ArrayList();
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        while (true) {
            int n;
            for (n = 0; list.contains(nextInt - n); ++n) {
                if (!list.contains(nextInt + n)) {
                    final int j = nextInt + n;
                    System.out.println(String.valueOf(j));
                    return;
                }
            }
            final int j = nextInt - n;
            continue;
        }
    }
}