import java.util.HashSet;
import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        int nextInt2 = scanner.nextInt();
        final HashSet set = new HashSet();
        while (nextInt2-- != 0) {
            set.add(scanner.nextInt());
        }
        int n;
        for (n = 0; set.contains(nextInt - n) && set.contains(nextInt + n); ++n) {}
        if (!set.contains(nextInt - n)) {
            System.out.println(nextInt - n);
        }
        else if (!set.contains(nextInt + n)) {
            System.out.println(nextInt + n);
        }
    }
}