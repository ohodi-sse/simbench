import java.util.HashSet;
import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        boolean b = false;
        if (nextInt2 == 0) {
            System.out.println(nextInt);
        }
        else {
            final HashSet set = new HashSet();
            for (int i = 0; i < nextInt2; ++i) {
                set.add(scanner.nextInt());
            }
            for (int j = 0; j < Math.min(nextInt, 101 - nextInt) + 1; ++j) {
                if (!set.contains(nextInt - j)) {
                    System.out.println(nextInt - j);
                    b = true;
                    break;
                }
                if (!set.contains(nextInt + j)) {
                    System.out.println(nextInt + j);
                    b = true;
                    break;
                }
            }
            if (!b) {
                if (nextInt <= 50) {
                    System.out.println(0);
                }
                else {
                    System.out.println(101);
                }
            }
        }
    }
}