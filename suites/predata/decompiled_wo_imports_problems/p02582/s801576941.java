final class ChenBitUtil
{
    private static int popCount(final int i) {
        return Integer.bitCount(i);
    }
    
    private static boolean isFlag(final int n, final int n2) {
        return 0x0 != (n & 1 << n2);
    }
    
    private static int setTrue(final int n, final int n2) {
        return n | 1 << n2;
    }
    
    private static int setFalse(final int n, final int n2) {
        return n & ~(1 << n2);
    }
    
    private static int setReverse(final int n, final int n2) {
        if (0x0 != (n & 1 << n2)) {
            return n & ~(1 << n2);
        }
        return n | 1 << n2;
    }
    
    private static int reverseAll(final int n) {
        return ~n;
    }
}









final class ChenNumberUtil
{
    private static Collection<Integer> getDivisors(final int n) {
        final ArrayList list = new ArrayList();
        int i = 1;
        while (true) {
            final int n2 = i;
            if (n2 * n2 > n) {
                break;
            }
            if (n % i == 0) {
                list.add(i);
                if (n / i != i) {
                    list.add(n / i);
                }
            }
            ++i;
        }
        Collections.sort((List<Comparable>)list);
        return list;
    }
}







public final class Main
{
    private static void main$3231c38a() {
        final Object run;
        if ((run = run()) != null) {
            System.out.println(run);
        }
    }
    
    private static Object run() {
        try (final Scanner scanner = new Scanner(System.in)) {
            final ArrayList list = new ArrayList();
            int i = 0;
            char[] charArray;
            for (int length = (charArray = scanner.next().toCharArray()).length, j = 0; j < length; ++j) {
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