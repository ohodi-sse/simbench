import java.util.ArrayList;
import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        final int nextInt = scanner.nextInt();
        final ArrayList list = new ArrayList();
        for (int i = 0; i < nextInt; ++i) {
            list.add(scanner.next());
        }
        if (list.size() == 0 || !list.contains(next)) {
            System.out.println(next);
            return;
        }
        int n = 1;
        String value;
        String value2;
        while (true) {
            value = String.valueOf(Integer.parseInt(next) - n);
            value2 = String.valueOf(Integer.parseInt(next) + n);
            if (!list.contains(value) || !list.contains(value2)) {
                break;
            }
            ++n;
        }
        if (!list.contains(value) && !list.contains(value2)) {
            System.out.println(value);
        }
        else if (!list.contains(value)) {
            System.out.println(value);
        }
        else {
            System.out.println(value2);
        }
    }
}