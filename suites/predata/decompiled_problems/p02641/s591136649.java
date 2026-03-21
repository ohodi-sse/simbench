import java.util.HashSet;
import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        try (final Scanner scanner = new Scanner(System.in)) {
            final int nextInt = scanner.nextInt();
            final int nextInt2 = scanner.nextInt();
            final HashSet set = new HashSet();
            for (int i = 0; i < nextInt2; ++i) {
                set.add(scanner.nextInt());
            }
            int n = 0;
            while (true) {
                final int n2 = nextInt - n;
                if (!set.contains(n2)) {
                    System.out.println(n2);
                    break;
                }
                final int n3 = nextInt + n;
                if (!set.contains(n3)) {
                    System.out.println(n3);
                    break;
                }
                ++n;
            }
        }
    }
}