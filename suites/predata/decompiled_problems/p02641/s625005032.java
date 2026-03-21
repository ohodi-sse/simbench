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
        int x = 0;
        int abs = 1073741823;
        for (int j = -100; j <= 200; ++j) {
            if (!set.contains(j) && Math.abs(j - nextInt) < abs) {
                x = j;
                abs = Math.abs(j - nextInt);
            }
        }
        System.out.println(x);
    }
}