import java.util.HashSet;
import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final HashSet set = new HashSet();
        for (int i = 1; i <= nextInt2; ++i) {
            set.add(scanner.nextInt());
        }
        for (int j = 0; j <= 100; ++j) {
            if (!set.contains(nextInt - j)) {
                System.out.println(nextInt - j);
                return;
            }
            if (!set.contains(nextInt + j)) {
                System.out.println(nextInt + j);
                return;
            }
        }
        System.out.println(0);
    }
}