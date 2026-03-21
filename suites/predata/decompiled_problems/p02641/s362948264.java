import java.util.HashSet;
import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        if (nextInt2 == 0) {
            System.out.println(nextInt);
        }
        else {
            final HashSet set = new HashSet();
            for (int i = 0; i < nextInt2; ++i) {
                set.add(scanner.nextInt());
            }
            if (!set.contains(nextInt)) {
                System.out.println(nextInt);
            }
            else {
                for (int j = 1; j <= 100; ++j) {
                    if (!set.contains(nextInt - j)) {
                        System.out.println(nextInt - j);
                        break;
                    }
                    if (!set.contains(nextInt + j)) {
                        System.out.println(nextInt + j);
                        break;
                    }
                }
            }
        }
    }
}