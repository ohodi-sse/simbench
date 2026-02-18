public final class Main
{
    private static long MOD = 998244353L;
    private static String letters;
    private static int INF = 1000000007;
    
    private static void main$3231c38a() {
        final FastScanner fastScanner = new FastScanner();
        final PrintWriter printWriter = new PrintWriter(System.out);
        final int int1 = Integer.parseInt(fastScanner.next());
        final int int2 = Integer.parseInt(fastScanner.next());
        final HashSet set = new HashSet();
        for (int i = 0; i < int2; ++i) {
            set.add(Integer.parseInt(fastScanner.next()));
        }
        for (int j = 0; j <= 100; ++j) {
            if (!set.contains(int1 - j)) {
                printWriter.println(int1 - j);
                printWriter.close();
                return;
            }
            if (!set.contains(int1 + j)) {
                printWriter.println(int1 + j);
                printWriter.close();
                return;
            }
        }
        printWriter.close();
    }
    
    private static long dist(final long[] array, final long[] array2) {
        return Math.abs(array2[0] - array[0]) + Math.abs(array2[1] - array[1]);
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
    
    private static long power(long n, long n2, final long n3) {
        if (n2 < 0L) {
            return 0L;
        }
        long n4 = 1L;
        long n5;
        for (n %= n3; n2 > 0L; n2 /= 2L, n5 = n, n = n5 * n5 % n3) {
            if (n2 % 2L == 1L) {
                n4 = n4 * n % n3;
            }
        }
        return n4;
    }
    
    private static int[] shuffle(final int[] array) {
        final Random random = new Random();
        for (int i = 0; i < array.length; ++i) {
            final int nextInt = random.nextInt(array.length);
            final int n = array[i];
            array[i] = array[nextInt];
            array[nextInt] = n;
        }
        return array;
    }
    
    private static long[] shuffle(final long[] array) {
        final Random random = new Random();
        for (int i = 0; i < array.length; ++i) {
            final int nextInt = random.nextInt(array.length);
            final long n = array[i];
            array[i] = array[nextInt];
            array[nextInt] = n;
        }
        return array;
    }
    
    private static int[][] sort(final int[][] a) {
        final Random random = new Random();
        for (int i = 0; i < a.length; ++i) {
            final int nextInt = random.nextInt(a.length);
            final int[] array = a[i];
            a[i] = a[nextInt];
            a[nextInt] = array;
        }
        Arrays.sort(a, new Comparator<int[]>() {
            private static int compare(final int[] array, final int[] array2) {
                return array[0] - array2[0];
            }
        });
        return a;
    }
    
    private static long[][] sort(final long[][] a) {
        final Random random = new Random();
        for (int i = 0; i < a.length; ++i) {
            final int nextInt = random.nextInt(a.length);
            final long[] array = a[i];
            a[i] = a[nextInt];
            a[nextInt] = array;
        }
        Arrays.sort(a, new Comparator<long[]>() {
            private static int compare(final long[] array, final long[] array2) {
                if (array[0] < array2[0]) {
                    return -1;
                }
                return 1;
            }
        });
        return a;
    }
    
    static final class FastScanner
    {
        private BufferedReader br;
        private StringTokenizer st;
        
        public FastScanner() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        final String next() {
            while (true) {
                if (this.st != null) {
                    if (this.st.hasMoreElements()) {
                        break;
                    }
                }
                try {
                    this.st = new StringTokenizer(this.br.readLine());
                }
                catch (final IOException ex) {
                    ex.printStackTrace();
                }
            }
            return this.st.nextToken();
        }
        
        private int ni() {
            return Integer.parseInt(this.next());
        }
        
        private long nl() {
            return Long.parseLong(this.next());
        }
        
        private double nd() {
            return Double.parseDouble(this.next());
        }
        
        private String nextLine() {
            String line = "";
            try {
                line = this.br.readLine();
            }
            catch (final IOException ex) {
                ex.printStackTrace();
            }
            return line;
        }
    }
}