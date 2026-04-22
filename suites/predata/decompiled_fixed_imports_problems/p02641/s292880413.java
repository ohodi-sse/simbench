import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        int x = 0;
        int abs = 100;
        final ArrayList list = new ArrayList();
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        if (nextInt2 == 0 || !list.contains(nextInt)) {
            System.out.println(nextInt);
        }
        else {
            for (int j = 0; j <= 200; ++j) {
                if (!list.contains(j) && Math.abs(nextInt - j) < abs) {
                    abs = Math.abs(nextInt - j);
                    x = j;
                }
            }
            System.out.println(x);
        }
    }
}