import java.util.Iterator;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        int x = 0;
        if (nextInt2 == 0) {
            x = nextInt;
        }
        else {
            final ArrayList list = new ArrayList();
            for (int i = 0; i < nextInt2; ++i) {
                list.add(scanner.nextInt());
            }
            final HashMap hashMap = new HashMap();
            for (int j = 0; j <= 105; ++j) {
                hashMap.put(j, Math.abs(nextInt - j));
            }
            int n = Integer.MAX_VALUE;
            for (final int intValue : hashMap.keySet()) {
                final int intValue2 = (int)hashMap.get(intValue);
                if (intValue2 < n && !list.contains(intValue)) {
                    x = intValue;
                    n = intValue2;
                }
            }
        }
        scanner.close();
        System.out.println(x);
    }
}