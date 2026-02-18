public final class Main
{
    private static void main$3231c38a() throws IOException {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        final String next2 = scanner.next();
        int x = 0;
        final char[] charArray = next.toCharArray();
        final char[] charArray2 = next2.toCharArray();
        for (int i = 0; i < charArray.length; ++i) {
            if (charArray[i] == charArray2[i]) {
                ++x;
            }
        }
        System.out.println(x);
    }
    
    private static long myMod(final long n, final long n2) {
        long n3;
        if ((n3 = n % n2) < 0L) {
            n3 += n2;
        }
        return n3;
    }
    
    private static long myModPow(long n, long n2, final long n3) {
        long n4 = 1L;
        if (n2 == 0L) {
            return 1L;
        }
        if (n3 == 0L) {
            while (n2 > 0L) {
                if (n2 % 2L == 0L) {
                    final long n5 = n;
                    n = n5 * n5;
                    n2 /= 2L;
                }
                else {
                    n4 *= n;
                    --n2;
                }
            }
            return n4;
        }
        while (n2 > 0L) {
            if (n2 % 2L == 0L) {
                final long n6 = n;
                n = n6 * myMod(n6, n3);
                n2 /= 2L;
            }
            else {
                n4 *= myMod(n, n3);
                --n2;
            }
        }
        return myMod(n4, n3);
    }
}