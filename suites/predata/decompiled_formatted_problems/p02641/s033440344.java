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
        Collections.sort((List<Comparable>)list);
        if (nextInt2 == 0 || !list.contains(nextInt)) {
            System.out.println(nextInt);
            return;
        }
        int n = 1;
        int n2;
        int n3;
        while (true) {
            n2 = nextInt - n;
            n3 = nextInt + n;
            if (!list.contains(n2) || !list.contains(n3)) {
                break;
            }
            ++n;
        }
        if (!list.contains(n2) && !list.contains(n2)) {
            System.out.println(n2);
        }
        else if (!list.contains(n2)) {
            System.out.println(n2);
        }
        else {
            System.out.println(n3);
        }
    }
}