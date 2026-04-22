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
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        int j = nextInt - 1;
        int k = nextInt + 1;
        Collections.sort((List<Comparable>)list);
        if (!list.contains(nextInt)) {
            System.out.print(nextInt);
        }
        else {
            int l = 0;
            while (l < nextInt2) {
                if (list.contains(j)) {
                    --j;
                }
                if (list.contains(k)) {
                    ++k;
                }
                if (!list.contains(j) && !list.contains(k)) {
                    if (Math.abs(nextInt - j) > Math.abs(nextInt - k)) {
                        System.out.print(k);
                        return;
                    }
                    System.out.print(j);
                }
                else {
                    ++l;
                }
            }
        }
    }
}