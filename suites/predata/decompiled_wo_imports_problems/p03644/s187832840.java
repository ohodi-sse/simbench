public final class Main
{
    private static void main$3231c38a() throws IOException {
        new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        final int nextInt = new Scanner(System.in).nextInt();
        long n = 0L;
        int n2 = 0;
        for (int i = 0; i <= nextInt; ++i) {
            int n3 = 0;
            for (int n4 = i; n4 > 1 && n4 % 2 == 0; n4 /= 2) {
                if (n4 % 2 == 0) {
                    ++n3;
                }
            }
            if (n3 > n) {
                n2 = i;
                n = n3;
            }
        }
        System.out.println((n2 == 0) ? 1 : n2);
        bufferedWriter.flush();
    }
    
    private static void forl_0(final int n, final int[] array, final Scanner scanner) {
        for (int i = 0; i < n; ++i) {
            array[i] = scanner.nextInt();
        }
    }
    
    private static void forl_1(final int n, final int[] array, final Scanner scanner) {
        for (int i = 1; i <= n; ++i) {
            array[i] = scanner.nextInt();
        }
    }
    
    private static void two_d(final int n, final int n2, final int[][] array, final Scanner scanner) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n2; ++j) {
                array[i][j] = scanner.nextInt();
            }
        }
    }
    
    private static boolean isPrime(final long n) {
        if (n < 2L) {
            return false;
        }
        if (n == 2L || n == 3L) {
            return true;
        }
        if (n % 2L == 0L || n % 3L == 0L) {
            return false;
        }
        for (long n2 = (long)Math.sqrt((double)n) + 1L, n3 = 6L; n3 <= n2; n3 += 6L) {
            if (n % (n3 - 1L) == 0L || n % (n3 + 1L) == 0L) {
                return false;
            }
        }
        return true;
    }
    
    private static long gcd(long n, long n2) {
        while (n2 != 0L) {
            final long n3 = n2;
            n2 = n % n2;
            n = n3;
        }
        return n;
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
    
    static final class Pair implements Comparable<Pair>
    {
        private int a;
        private int b;
        
        private Pair(final int a, final int b) {
            this.a = a;
            this.b = b;
        }
        
        private int compareTo(final Pair pair) {
            return this.a - pair.a;
        }
    }
}