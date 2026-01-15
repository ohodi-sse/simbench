import java.util.ArrayList;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Object run = run();
        if (run != null) {
            System.out.println(run);
        }
    }
    
    static Object run() {
        try (final Scanner scanner = new Scanner(System.in)) {
            final ArrayList list = new ArrayList();
            int i = 0;
            final char[] charArray = scanner.next().toCharArray();
            for (int length = charArray.length, j = 0; j < length; ++j) {
                list.add(charArray[j]);
            }
            if ((char)list.get(0) == 'R') {
                ++i;
            }
            if (list.get(1) == 'S' && i == 1) {
                final Integer value = 1;
                scanner.close();
                return value;
            }
            if ((char)list.get(1) == 'R') {
                ++i;
            }
            if ((char)list.get(2) == 'R') {
                ++i;
            }
            return i;
        }
    }
}
