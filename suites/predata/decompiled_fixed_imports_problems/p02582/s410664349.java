import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        scanner.close();
        final ArrayList coll = new ArrayList();
        coll.add(0);
        int n = 0;
        for (int i = 0; i < 3; ++i) {
            if (next.charAt(i) == 'R') {
                coll.set(n, (int)coll.get(n) + 1);
            }
            if (next.charAt(i) == 'S') {
                ++n;
                coll.add(0);
            }
        }
        System.out.println(Collections.max((Collection<?>)coll));
    }
}