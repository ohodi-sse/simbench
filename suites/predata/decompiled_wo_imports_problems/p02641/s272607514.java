public final class Main
{
    private static int getgcd(int i, int n) {
        while (i != n) {
            if (i > n) {
                i -= n;
            }
            else {
                n -= i;
            }
        }
        return i;
    }
    
    private static boolean isSorted(final int[] array, final int n) {
        for (int i = 1; i < n; ++i) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean isPrime(final long n) {
        if (n == 2L) {
            return true;
        }
        if (n % 2L == 0L) {
            return false;
        }
        for (int n2 = 3; n2 <= n / 2L; n2 += 2) {
            if (n % n2 == 0L) {
                return false;
            }
        }
        return true;
    }
    
    private static void printArray(final int[] array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            System.out.print("" + array[i]);
        }
        System.out.println();
    }
    
    private static void main$3231c38a() throws NumberFormatException, IOException {
        final FastReader fastReader;
        int int1 = Integer.parseInt((fastReader = new FastReader()).next());
        final int int2 = Integer.parseInt(fastReader.next());
        final HashSet set = new HashSet();
        for (int i = 0; i < int2; ++i) {
            set.add(Integer.parseInt(fastReader.next()));
        }
        if (!set.contains(int1)) {
            System.out.println(int1);
            return;
        }
        int x = int1;
        while (set.contains(--x)) {
            if (!set.contains(++int1)) {
                System.out.println(int1);
                return;
            }
        }
        System.out.println(x);
    }
    
    static final class FastReader
    {
        private BufferedReader br;
        private StringTokenizer st;
        
        public FastReader() {
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
        
        private int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        private long nextLong() {
            return Long.parseLong(this.next());
        }
        
        private double nextDouble() {
            return Double.parseDouble(this.next());
        }
        
        private int[] readArray(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = Integer.parseInt(this.next());
            }
            return array;
        }
        
        private long[] readLongArray(final int n) {
            final long[] array = new long[n];
            for (int i = 0; i < n; ++i) {
                array[i] = Long.parseLong(this.next());
            }
            return array;
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