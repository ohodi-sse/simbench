public final class Main
{
    private static BufferedReader br;
    private static PrintWriter out;
    private static StringTokenizer t;
    private static long mod;
    private static boolean[] v;
    private static DecimalFormat df;
    private static int maxn;
    
    private static String sn() {
        while (true) {
            if (Main.t != null) {
                if (Main.t.hasMoreTokens()) {
                    break;
                }
            }
            try {
                Main.t = new StringTokenizer(Main.br.readLine());
                continue;
            }
            catch (final IOException ex) {
                throw new RuntimeException();
            }
            break;
        }
        return Main.t.nextToken();
    }
    
    private static int ni() {
        return Integer.parseInt(sn());
    }
    
    private static long nlo() {
        return Long.parseLong(sn());
    }
    
    private static long pro(final long n, final long n2) {
        return n % Main.mod * n2 % Main.mod % Main.mod;
    }
    
    private static long add(final long n, final long n2) {
        return (n + n2) % Main.mod;
    }
    
    private static long sub(final long n, final long n2) {
        return (n % Main.mod - n2 % Main.mod + Main.mod) % Main.mod;
    }
    
    private static int pow(final int n) {
        return (int)(Math.log10(n) / Math.log10(2.0));
    }
    
    private static int modpow(int n, int i) {
        int n2 = 1;
        while (i > 0) {
            if (i % 2 != 0) {
                n2 *= n;
            }
            final int n3 = n;
            n = n3 * n3;
            i /= 2;
        }
        return n2;
    }
    
    private static long modInverse(final long i) {
        return Long.parseLong(new BigInteger(Long.toString(i)).modInverse(new BigInteger(Long.toString(Main.mod))).toString()) % Main.mod;
    }
    
    private static void seive() {
        Main.v[1] = true;
        for (int i = 2; i < 1000005; ++i) {
            if (!Main.v[i]) {
                for (int j = 2 * i; j < 1000005; j += i) {
                    Main.v[j] = true;
                }
            }
        }
    }
    
    private static boolean isprime(final long n) {
        if (n == 1L) {
            return false;
        }
        int n2 = 2;
        while (true) {
            final int n3 = n2;
            if (n3 * n3 > n) {
                return true;
            }
            if (n % n2 == 0L) {
                return false;
            }
            ++n2;
        }
    }
    
    private static int gcd(int n, int i) {
        while (i != 0) {
            final int n2 = i;
            i = n % i;
            n = n2;
        }
        return n;
    }
    
    private static long gcd(long n, long n2) {
        while (n2 != 0L) {
            final long n3 = n2;
            n2 = n % n2;
            n = n3;
        }
        return n;
    }
    
    private static void solve() {
        final int int1 = Integer.parseInt(sn());
        final int int2 = Integer.parseInt(sn());
        final HashMap hashMap = new HashMap();
        for (int i = 0; i < int2; ++i) {
            hashMap.put(Integer.parseInt(sn()), 1);
        }
        if (int2 == 0) {
            Main.out.println(int1);
            return;
        }
        int x = -1;
        for (int j = int1; j <= 1000; ++j) {
            if (!hashMap.containsKey(j)) {
                x = j;
                break;
            }
        }
        for (int k = int1 - 1; k >= -1000; --k) {
            if (!hashMap.containsKey(k)) {
                final int abs = Math.abs(int1 - k);
                final int abs2 = Math.abs(int1 - x);
                if (abs < abs2 || (abs == abs2 && k < x)) {
                    x = k;
                    break;
                }
            }
        }
        Main.out.println(x);
    }
    
    private static void main$3231c38a() {
        int n = 1;
        while (n-- > 0) {
            final int int1 = Integer.parseInt(sn());
            final int int2 = Integer.parseInt(sn());
            final HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
            for (int i = 0; i < int2; ++i) {
                hashMap.put(Integer.parseInt(sn()), 1);
            }
            if (int2 == 0) {
                Main.out.println(int1);
            }
            else {
                int x = -1;
                for (int j = int1; j <= 1000; ++j) {
                    if (!hashMap.containsKey(j)) {
                        x = j;
                        break;
                    }
                }
                for (int k = int1 - 1; k >= -1000; --k) {
                    if (!hashMap.containsKey(k)) {
                        final int abs = Math.abs(int1 - k);
                        final int abs2 = Math.abs(int1 - x);
                        if (abs < abs2 || (abs == abs2 && k < x)) {
                            x = k;
                            break;
                        }
                    }
                }
                Main.out.println(x);
            }
        }
        Main.out.close();
    }
    
    static {
        Main.br = new BufferedReader(new InputStreamReader(System.in), 32768);
        Main.out = new PrintWriter(System.out);
        Main.mod = 1000000007L;
        Main.v = new boolean[1000005];
        new DecimalFormat("0.000000000000000000000");
    }
    
    static final class trie
    {
        private trie[] a;
        private int cnt;
        
        trie() {
            this.a = new trie[26];
            this.cnt = 0;
        }
    }
}