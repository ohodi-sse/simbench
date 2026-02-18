public final class Main
{
    private static PrintWriter out;
    
    private static void main$3231c38a() throws IOException {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2 = scanner.nextInt();
        final HashMap hashMap = new HashMap();
        for (int i = -1; i <= 101; ++i) {
            hashMap.put(i, 0);
        }
        for (int j = 1; j <= nextInt2; ++j) {
            final int nextInt3 = scanner.nextInt();
            if (hashMap.containsKey(nextInt3)) {
                hashMap.remove(nextInt3);
            }
        }
        final ArrayList list = new ArrayList(hashMap.keySet());
        int abs = Integer.MAX_VALUE;
        int x = 0;
        for (final int intValue : list) {
            if (Math.abs(nextInt - intValue) < abs) {
                x = intValue;
                abs = Math.abs(nextInt - intValue);
            }
        }
        System.out.println(x);
    }
    
    private static ArrayList<Integer> primefactor(int i) {
        final int n = (int)Math.sqrt(i);
        final ArrayList list = new ArrayList();
        while (i % 2 == 0) {
            list.add(2);
            i /= 2;
        }
        for (int j = 3; j <= n; j += 2) {
            while (i % j == 0) {
                list.add(j);
                i /= j;
            }
        }
        if (i > 2) {
            list.add(i);
        }
        return list;
    }
    
    private static long sum(long n) {
        long n2 = 0L;
        while (n != 0L) {
            n2 += n % 10L;
            n /= 10L;
        }
        return n2;
    }
    
    private static ArrayList<Integer> factor(final int n) {
        final int n2 = (int)Math.sqrt(n);
        final ArrayList list = new ArrayList();
        for (int i = 1; i <= n2; ++i) {
            if (n % i == 0) {
                final int n3 = i;
                final int n4 = n / i;
                list.add(i);
                if (n3 != n4) {
                    list.add(n / i);
                }
            }
        }
        return list;
    }
    
    private static int power(final int n, final int n2) {
        if (n2 == 0) {
            return 1;
        }
        final int power = power(n, n2 / 2);
        if (n2 % 2 == 0) {
            final int n3 = power;
            return n3 * n3;
        }
        return n * power * power;
    }
    
    private static ArrayList<Integer> comp() {
        final ArrayList list = new ArrayList();
        final boolean[] array = new boolean[200001];
        for (int n = (int)Math.sqrt(200000.0), i = 2; i <= n; ++i) {
            if (!array[i]) {
                final int n2 = i;
                for (int j = n2 * n2; j <= 200000; j += i) {
                    array[j] = true;
                }
            }
        }
        for (int k = 2; k <= 200000; ++k) {
            if (!array[k]) {
                list.add(k);
            }
        }
        return list;
    }
    
    private static long gcd(long n, long n2) {
        while (n2 != 0L) {
            final long n3 = n2;
            n2 = n % n2;
            n = n3;
        }
        return n;
    }
    
    static {
        new PrintWriter(new BufferedOutputStream(System.out));
    }
    
    public static final class pair
    {
        int x;
        int y;
        
        private pair(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static final class comp implements Comparator<pair>
    {
        private static int compare(final pair pair, final pair pair2) {
            if (pair.y == pair2.y) {
                return pair2.x - pair.x;
            }
            return pair2.y - pair.y;
        }
    }
    
    static final class Node
    {
        private int node;
        private int d;
        private ArrayList<Integer> al;
        
        Node() {
            this.al = new ArrayList<Integer>();
        }
    }
    
    static final class FastReader
    {
        private final int BUFFER_SIZE = 65536;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer;
        private int bytesRead;
        
        public FastReader() {
            this.din = new DataInputStream(System.in);
            this.buffer = new byte[65536];
            final int n = 0;
            this.bytesRead = n;
            this.bufferPointer = n;
        }
        
        private FastReader(final String name) throws IOException {
            this.din = new DataInputStream(new FileInputStream(name));
            this.buffer = new byte[65536];
            final int n = 0;
            this.bytesRead = n;
            this.bufferPointer = n;
        }
        
        private String readLine() throws IOException {
            final byte[] bytes = new byte[64];
            int length = 0;
            byte read;
            while ((read = this.read()) != -1 && read != 10) {
                bytes[length++] = read;
            }
            return new String(bytes, 0, length);
        }
        
        private int nextInt() throws IOException {
            int n = 0;
            byte b;
            for (b = this.read(); b <= 32; b = this.read()) {}
            final boolean b2;
            if (b2 = (b == 45)) {
                b = this.read();
            }
            do {
                n = n * 10 + b - 48;
            } while ((b = this.read()) >= 48 && b <= 57);
            if (b2) {
                return -n;
            }
            return n;
        }
        
        private long nextLong() throws IOException {
            long n = 0L;
            byte b;
            for (b = this.read(); b <= 32; b = this.read()) {}
            final boolean b2;
            if (b2 = (b == 45)) {
                b = this.read();
            }
            do {
                n = n * 10L + b - 48L;
            } while ((b = this.read()) >= 48 && b <= 57);
            if (b2) {
                return -n;
            }
            return n;
        }
        
        private double nextDouble() throws IOException {
            double n = 0.0;
            double n2 = 1.0;
            byte b;
            for (b = this.read(); b <= 32; b = this.read()) {}
            final boolean b2;
            if (b2 = (b == 45)) {
                b = this.read();
            }
            do {
                n = n * 10.0 + b - 48.0;
            } while ((b = this.read()) >= 48 && b <= 57);
            if (b == 46) {
                byte read;
                while ((read = this.read()) >= 48 && read <= 57) {
                    n += (read - 48) / (n2 *= 10.0);
                }
            }
            if (b2) {
                return -n;
            }
            return n;
        }
        
        private void fillBuffer() throws IOException {
            final DataInputStream din = this.din;
            final byte[] buffer = this.buffer;
            final int n = 0;
            this.bufferPointer = n;
            this.bytesRead = din.read(buffer, n, 65536);
            if (this.bytesRead == -1) {
                this.buffer[0] = -1;
            }
        }
        
        private byte read() throws IOException {
            if (this.bufferPointer == this.bytesRead) {
                this.fillBuffer();
            }
            return this.buffer[this.bufferPointer++];
        }
        
        private void close() throws IOException {
            if (this.din == null) {
                return;
            }
            this.din.close();
        }
    }
}