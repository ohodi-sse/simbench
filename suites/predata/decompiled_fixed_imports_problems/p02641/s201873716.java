import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        if (nextInt2 == 0) {
            System.out.println(nextInt);
            System.exit(0);
        }
        final ArrayList list = new ArrayList();
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        final boolean b = true;
        int n = 0;
        while (b) {
            if (!list.contains(nextInt - n)) {
                System.out.println(nextInt - n);
                break;
            }
            if (!list.contains(nextInt + n)) {
                System.out.println(nextInt + n);
                break;
            }
            ++n;
        }
    }
}