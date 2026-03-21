import java.util.ArrayList;
import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        int abs = 102;
        int x = 0;
        final ArrayList list = new ArrayList();
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        for (int j = 101; j >= 0; --j) {
            if (!list.contains(j) && abs >= Math.abs(nextInt - j)) {
                abs = Math.abs(nextInt - j);
                x = j;
            }
        }
        System.out.println(x);
    }
}