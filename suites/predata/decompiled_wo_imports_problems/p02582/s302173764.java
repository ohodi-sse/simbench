static class FastReader
{
    BufferedReader br;
    StringTokenizer st;
    
    public FastReader() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }
    
    String next() {
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
    
    int nextInt() {
        return Integer.parseInt(this.next());
    }
    
    long nextLong() {
        return Long.parseLong(this.next());
    }
    
    double nextDouble() {
        return Double.parseDouble(this.next());
    }
    
    int[] readArray(final int n) {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.nextInt();
        }
        return array;
    }
    
    long[] readLongArray(final int n) {
        final long[] array = new long[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.nextLong();
        }
        return array;
    }
    
    String nextLine() {
        String line = "";
        try {
            line = this.br.readLine();
        }
        catch (final IOException ex) {
            ex.printStackTrace();
        }
        return line;
    }
}public class Main
{
    static final String alpha;
    
    static int getGcd(int i, int n) {
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
    
    static boolean isSorted(final int[] array, final int n) {
        for (int i = 1; i < n; ++i) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }
    
    static boolean isPrime(final long n) {
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
    
    static boolean isPrime(final int n) {
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= n / 2; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    static void printArray(final int[] array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            System.out.print("" + array[i]);
        }
        System.out.println();
    }
    
    static long Fact(final int n) {
        long n2 = 1L;
        for (int i = 1; i <= n; ++i) {
            n2 *= i;
        }
        return n2;
    }
    
    static int findLargestDiv(final int n) {
        if (n % 2 == 0) {
            return n / 2;
        }
        for (int i = 3; i <= n / 2; i += 2) {
            if (n % i == 0) {
                return n / i;
            }
        }
        return 1;
    }
    
    public static void main(final String[] array) throws NumberFormatException, IOException {
        final String nextLine = new FastReader().nextLine();
        int n = 0;
        int x = 0;
        for (int i = 0; i < nextLine.length(); ++i) {
            if (nextLine.charAt(i) == 'R') {
                ++n;
                if (i == 2) {
                    x = Math.max(x, n);
                }
            }
            else {
                x = Math.max(x, n);
                n = 0;
            }
        }
        System.out.println(x);
    }
    
    static {
        alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase();
    }
    
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
        
        public FastReader() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        String next() {
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
        
        int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        long nextLong() {
            return Long.parseLong(this.next());
        }
        
        double nextDouble() {
            return Double.parseDouble(this.next());
        }
        
        int[] readArray(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextInt();
            }
            return array;
        }
        
        long[] readLongArray(final int n) {
            final long[] array = new long[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextLong();
            }
            return array;
        }
        
        String nextLine() {
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