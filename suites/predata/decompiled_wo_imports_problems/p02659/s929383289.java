public final class Main
{
    private static Scanner sc;
    private static long mod;
    private static long longINF;
    private static int INF;
    
    private static void main$3231c38a() {
        final long nextLong = Main.sc.nextLong();
        final StringBuffer sb;
        (sb = new StringBuffer(Main.sc.next())).deleteCharAt(1);
        System.out.println(nextLong * Integer.parseInt(sb.toString()) / 100L);
    }
    
    private static long bi(final int n) {
        long n2 = 1L;
        for (int i = 1; i <= n; ++i) {
            n2 = n2 * i % Main.mod;
        }
        return n2;
    }
    
    private static long modPow(final long n, final long n2) {
        long n3 = 1L;
        for (int n4 = 0; n4 < n2; ++n4) {
            n3 = n3 * n % Main.mod;
        }
        return n3;
    }
    
    private static void bit() {
        final String[] array = { "a", "b", "c" };
        for (int i = 0; i < 8; ++i) {
            String s = "";
            for (int j = 0; j < 3; ++j) {
                if ((0x1 & i >> j) == 0x1) {
                    s += array[j];
                }
            }
            System.out.println("S=" + s);
        }
    }
    
    private static long lcm(final long n, final long n2) {
        long n3;
        long n4;
        long n5;
        for (n3 = n2, n4 = n; n3 != 0L; n3 = n4 % n3, n4 = n5) {
            n5 = n3;
        }
        return n / n4 * n2;
    }
    
    private static long gcd(long n, long n2) {
        while (n2 != 0L) {
            final long n3 = n2;
            n2 = n % n2;
            n = n3;
        }
        return n;
    }
    
    private static String nextPermutation(final String s) {
        final ArrayList list = new ArrayList();
        for (int i = 0; i < s.length(); ++i) {
            list.add(s.charAt(i));
        }
        int j = -1;
        char charValue = '\0';
        for (int k = list.size() - 2; k >= 0; --k) {
            if ((char)list.get(k) < (char)list.get(k + 1)) {
                j = k;
                charValue = (char)list.get(k);
                break;
            }
        }
        if (j == -1 && charValue == '\0') {
            return "Final";
        }
        final int fromIndex = j + 1;
        final int n = list.size() - 1;
        int l = -1;
        char charValue2 = '\uffff';
        for (int index = n; index >= fromIndex; --index) {
            if (charValue < (char)list.get(index) && (char)list.get(index) < charValue2) {
                charValue2 = (char)list.get(index);
                l = index;
            }
        }
        Collections.swap(list, j, l);
        Collections.sort((List<Comparable>)list.subList(fromIndex, n + 1));
        final StringBuilder sb = new StringBuilder();
        for (int index2 = 0; index2 < list.size(); ++index2) {
            sb.append(list.get(index2));
        }
        return sb.toString();
    }
    
    private static void p(final String x) {
        System.out.println(x);
    }
    
    private static void p(final int x) {
        System.out.println(x);
    }
    
    private static void p() {
        System.out.println();
    }
    
    private static void p(final long x) {
        System.out.println(x);
    }
    
    private static void p(final double x) {
        System.out.println(x);
    }
    
    static {
        Main.sc = new Scanner(System.in);
        Main.mod = 1000000007L;
    }
}