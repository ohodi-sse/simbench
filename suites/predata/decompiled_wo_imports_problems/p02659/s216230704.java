public final class Main
{
    private static Scanner sc;
    private static int MOD = 1000000007;
    private static double PI = 3.141592653589793;
    private static PrintWriter out;
    
    private static void main$3231c38a() {
        final String string = Main.sc.nextBigDecimal().multiply(Main.sc.nextBigDecimal()).toString();
        String x = "";
        char char1;
        for (int index = 0; index < string.length() && (char1 = string.charAt(index)) != '.'; ++index) {
            x += char1;
        }
        Main.out.println(x);
        Main.out.close();
    }
    
    private static int[] init(final int n) {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = Main.sc.nextInt();
        }
        return array;
    }
    
    private static int gcd(int i, int n) {
        while (i != 0) {
            final int n2 = n % i;
            n = i;
            i = n2;
        }
        return n;
    }
    
    private static boolean prime(final int n) {
        if (n < 2) {
            return false;
        }
        int n2 = 2;
        while (true) {
            final int n3 = n2;
            if (n3 * n3 > n) {
                return true;
            }
            if (n % n2 == 0) {
                return false;
            }
            ++n2;
        }
    }
    
    static {
        Main.sc = new Scanner(System.in);
        Main.out = new PrintWriter(new BufferedOutputStream(System.out));
    }
    
    static final class Pair<S extends Comparable<S>, T extends Comparable<T>> implements Comparable<Pair<S, T>>
    {
        private S first;
        private T second;
        
        public Pair() {
        }
        
        private Pair(final S first, final T second) {
            this.first = first;
            this.second = second;
        }
        
        private S getX() {
            return this.first;
        }
        
        private T getY() {
            return this.second;
        }
        
        private int compareTo(final Pair<S, T> pair) {
            final int compareTo;
            if ((compareTo = this.first.compareTo(pair.first)) == 0) {
                return this.second.compareTo(pair.second);
            }
            return compareTo;
        }
        
        private void show() {
            System.out.println("[" + String.valueOf(this.first) + " , " + String.valueOf(this.second));
        }
        
        @Override
        public final int hashCode() {
            return (31 + this.first.hashCode()) * 31 + this.second.hashCode();
        }
        
        @Override
        public final boolean equals(final Object o) {
            if (!(o instanceof Pair)) {
                return false;
            }
            if (o == this) {
                return true;
            }
            final Pair pair = (Pair)o;
            return this.first.equals(pair.first) && this.second.equals(pair.second);
        }
        
        @Override
        public final String toString() {
            return "Pair{" + String.valueOf(this.first) + ", " + String.valueOf(this.second);
        }
    }
    
    public static final class MyScanner
    {
        private BufferedReader br;
        private StringTokenizer st;
        
        public MyScanner() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        private String next() {
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