import java.util.HashSet;
import java.util.Scanner;

class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final HashSet set = new HashSet();
        for (int i = 0; i < nextInt2; ++i) {
            set.add(scanner.nextInt());
        }
        int n = 0;
        int j = 0;
        int n2 = 0;
        while (j == 0) {
            if (!set.contains(nextInt - n)) {
                j = 1;
            }
            if ((n2 = n) > 0) {
                n = 0 - n;
            }
            else {
                n = 0 - n + 1;
            }
        }
        System.out.println(nextInt - n2);
    }
}