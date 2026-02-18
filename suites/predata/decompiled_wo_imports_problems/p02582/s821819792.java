public final class Main
{
    private static AnotherReader sc;
    private static PrintWriter out;
    private static boolean multipleTC;
    
    private static void process() throws IOException {
        final String next = Main.sc.next();
        long n = 0L;
        long max = 0L;
        for (int i = 0; i < 3; ++i) {
            if (next.charAt(i) == 'R') {
                ++n;
            }
            else {
                max = Math.max(n, max);
                n = 0L;
            }
        }
        Main.out.println((Object)Math.max(n, max));
    }
    
    private static void main$3231c38a() throws IOException {
        Main.out = new PrintWriter(System.out);
        final String next = (Main.sc = new AnotherReader()).next();
        long n = 0L;
        long max = 0L;
        for (int i = 0; i < 3; ++i) {
            if (next.charAt(i) == 'R') {
                ++n;
            }
            else {
                max = Math.max(n, max);
                n = 0L;
            }
        }
        Main.out.println((Object)Math.max(n, max));
        Main.out.flush();
        System.out.close();
    }
    
    private static void sort(final long[] a, final int n) {
        final Random random = new Random();
        for (int i = 0; i < n; ++i) {
            final long n2 = a[i];
            final int n3 = i + random.nextInt(n - i);
            a[i] = a[n3];
            a[n3] = n2;
        }
        Arrays.sort(a);
    }
    
    private static void shuffle(final long[] array, final int n) {
        final Random random = new Random();
        for (int i = 0; i < n; ++i) {
            final long n2 = array[i];
            final int n3 = i + random.nextInt(n - i);
            array[i] = array[n3];
            array[n3] = n2;
        }
    }
    
    private static void pn(final Object x) {
        Main.out.println(x);
    }
    
    private static void p(final Object obj) {
        Main.out.print(obj);
    }
    
    private static void pni(final Object x) {
        Main.out.println(x);
        System.out.flush();
    }
    
    private static int ni() throws IOException {
        return Integer.parseInt(Main.sc.next());
    }
    
    private static long nl() throws IOException {
        return Long.parseLong(Main.sc.next());
    }
    
    private static double nd() throws IOException {
        return Double.parseDouble(Main.sc.next());
    }
    
    private static String nln() throws IOException {
        return Main.sc.nextLine();
    }
    
    private static String nn() throws IOException {
        return Main.sc.next();
    }
    
    private static long gcd(long n, long n2) throws IOException {
        while (n2 != 0L) {
            final long n3 = n2;
            n2 = n % n2;
            n = n3;
        }
        return n;
    }
    
    private static int gcd(int n, int i) throws IOException {
        while (i != 0) {
            final int n2 = i;
            i = n % i;
            n = n2;
        }
        return n;
    }
    
    private static int bit(final long n) throws IOException {
        if (n == 0L) {
            return 0;
        }
        return 1 + bit(n & n - 1L);
    }
    
    private static int[] iarr(final int n) throws IOException {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = Integer.parseInt(Main.sc.next());
        }
        return array;
    }
    
    private static long[] larr(final int n) throws IOException {
        final long[] array = new long[n];
        for (int i = 0; i < n; ++i) {
            array[i] = Long.parseLong(Main.sc.next());
        }
        return array;
    }
    
    static final class AnotherReader
    {
        private BufferedReader br;
        private StringTokenizer st;
        
        AnotherReader() throws FileNotFoundException {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        private AnotherReader(final byte b) throws FileNotFoundException {
            this.br = new BufferedReader(new FileReader("input.txt"));
        }
        
        final String next() throws IOException {
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
        
        private int nextInt() throws IOException {
            return Integer.parseInt(this.next());
        }
        
        private long nextLong() throws IOException {
            return Long.parseLong(this.next());
        }
        
        private double nextDouble() throws IOException {
            return Double.parseDouble(this.next());
        }
        
        final String nextLine() throws IOException {
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