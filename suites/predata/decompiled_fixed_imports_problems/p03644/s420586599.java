import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        if (nextInt == 1) {
            System.out.println(1);
            System.exit(0);
        }
        final HashMap hashMap = new HashMap();
        for (int i = 1; i <= nextInt; ++i) {
            int n = i;
            int j = 0;
            while (n % 2 == 0) {
                ++j;
                n /= 2;
            }
            hashMap.put(i, j);
        }
        int intValue = 0;
        int intValue2 = 0;
        for (final Map.Entry entry : hashMap.entrySet()) {
            if ((int)entry.getValue() > intValue2) {
                intValue2 = (int)entry.getValue();
                intValue = (int)entry.getKey();
            }
        }
        System.out.println(intValue);
    }
}