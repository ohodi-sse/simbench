import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final ArrayList list = new ArrayList();
        if (nextInt2 == 0) {}
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        Collections.sort((List<Comparable>)list);
        int min = 101;
        for (int j = 0; j < 102; ++j) {
            if (!list.contains(j)) {
                min = Math.min(min, Math.abs(nextInt - j));
            }
        }
        if (true != false) {
            if (list.contains(nextInt - min)) {
                System.out.println(nextInt + min);
            }
            else {
                System.out.println(nextInt - min);
            }
        }
        else {
            System.out.println(nextInt);
        }
    }
}