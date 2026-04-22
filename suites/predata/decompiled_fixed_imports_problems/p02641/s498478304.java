import java.util.Iterator;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final ArrayList list = new ArrayList();
        final ArrayList list2 = new ArrayList();
        for (int i = 0; i < nextInt2; ++i) {
            final int n = scanner.nextInt() - nextInt;
            if (n >= 0) {
                list.add(n);
            }
            else {
                list2.add(n);
            }
        }
        int n2 = 0;
        for (int j = 0; j < 101; ++j) {
            boolean b = true;
            final Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                if (j == (int)iterator.next()) {
                    b = false;
                }
            }
            if (b) {
                n2 = j;
                break;
            }
        }
        int a = -101;
        for (int k = -1; k > -101; --k) {
            boolean b2 = true;
            final Iterator iterator2 = list2.iterator();
            while (iterator2.hasNext()) {
                if (k == (int)iterator2.next()) {
                    b2 = false;
                }
            }
            if (b2) {
                a = k;
                break;
            }
        }
        final int abs = Math.abs(a);
        if (n2 == abs) {
            System.out.println(nextInt + a);
        }
        else if (n2 > abs) {
            System.out.println(nextInt + a);
        }
        else {
            System.out.println(nextInt + n2);
        }
    }
}