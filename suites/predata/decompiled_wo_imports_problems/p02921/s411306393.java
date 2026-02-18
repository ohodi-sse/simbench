public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        final String next2 = scanner.next();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            final String s = next;
            final int beginIndex = i;
            final String substring = s.substring(beginIndex, beginIndex + 1);
            final String s2 = next2;
            final int beginIndex2 = i;
            if (substring.equals(s2.substring(beginIndex2, beginIndex2 + 1))) {
                ++x;
            }
        }
        System.out.println(x);
    }
    
    private static long lcm(final long n, final long n2) {
        final long n3 = n * n2;
        long n4 = n2;
        long n5 = n;
        while (true) {
            if (n5 < n4) {
                final long n6 = n4;
                n4 = n5;
                n5 = n6;
            }
            else {
                if (n4 == 0L) {
                    break;
                }
                final long n7 = n4;
                n4 = n5 % n4;
                n5 = n7;
            }
        }
        return n3 / n5;
    }
    
    private static long gcd(long n, long n2) {
        while (true) {
            if (n < n2) {
                final long n3 = n2;
                n2 = n;
                n = n3;
            }
            else {
                if (n2 == 0L) {
                    break;
                }
                final long n4 = n2;
                n2 = n % n2;
                n = n4;
            }
        }
        return n;
    }
}