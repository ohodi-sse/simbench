class ChenBitUtil
{
    static int popCount(final int i) {
        return Integer.bitCount(i);
    }
    
    static boolean isFlag(final int n, final int n2) {
        return 0x0 != (n & 1 << n2);
    }
    
    static int setTrue(int n, final int n2) {
        return n |= 1 << n2;
    }
    
    static int setFalse(int n, final int n2) {
        return n &= ~(1 << n2);
    }
    
    static int setReverse(final int n, final int n2) {
        return isFlag(n, n2) ? setFalse(n, n2) : setTrue(n, n2);
    }
    
    static int reverseAll(final int n) {
        return ~n;
    }
}
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Collection;





class ChenNumberUtil
{
    static Collection<Integer> getDivisors(final int n) {
        final ArrayList list = new ArrayList();
        for (int i = 1; i * i <= n; ++i) {
            if (n % i == 0) {
                list.add(i);
                if (n / i != i) {
                    list.add(n / i);
                }
            }
        }
        Collections.sort((List<Comparable>)list);
        return list;
    }
}
import java.util.ArrayList;
import java.util.Scanner;





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