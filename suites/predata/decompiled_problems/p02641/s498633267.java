// 
// Decompiled by Procyon v0.6.0
// 

static class trie
{
    trie[] a;
    int cnt;
    
    trie() {
        this.a = new trie[26];
        this.cnt = 0;
    }
}
import java.io.OutputStream;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.math.BigInteger;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.io.BufferedReader;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer t;
    static long mod;
    static boolean[] v;
    static DecimalFormat df;
    static int maxn;
    
    static String sn() {
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
    
    static int ni() {
        return Integer.parseInt(sn());
    }
    
    static long nlo() {
        return Long.parseLong(sn());
    }
    
    static long pro(final long n, final long n2) {
        return n % Main.mod * n2 % Main.mod % Main.mod;
    }
    
    static long add(final long n, final long n2) {
        return (n + n2) % Main.mod;
    }
    
    static long sub(final long n, final long n2) {
        return (n % Main.mod - n2 % Main.mod + Main.mod) % Main.mod;
    }
    
    static int pow(final int n) {
        return (int)(Math.log10(n) / Math.log10(2.0));
    }
    
    static int modpow(int n, int i) {
        int n2 = 1;
        while (i > 0) {
            if (i % 2 != 0) {
                n2 *= n;
            }
            n *= n;
            i /= 2;
        }
        return n2;
    }
    
    static long modInverse(final long i) {
        return Long.parseLong(new BigInteger(Long.toString(i)).modInverse(new BigInteger(Long.toString(Main.mod))).toString()) % Main.mod;
    }
    
    static void seive() {
        Main.v[1] = true;
        for (int i = 2; i < 1000005; ++i) {
            if (!Main.v[i]) {
                for (int j = 2 * i; j < 1000005; j += i) {
                    Main.v[j] = true;
                }
            }
        }
    }
    
    static boolean isprime(final long n) {
        if (n == 1L) {
            return false;
        }
        for (int n2 = 2; n2 * n2 <= n; ++n2) {
            if (n % n2 == 0L) {
                return false;
            }
        }
        return true;
    }
    
    static int gcd(final int n, final int n2) {
        if (n2 == 0) {
            return n;
        }
        return gcd(n2, n % n2);
    }
    
    static long gcd(final long n, final long n2) {
        if (n2 == 0L) {
            return n;
        }
        return gcd(n2, n % n2);
    }
    
    static void solve() {
        final int ni = ni();
        final int ni2 = ni();
        final HashMap hashMap = new HashMap();
        for (int i = 0; i < ni2; ++i) {
            hashMap.put(ni(), 1);
        }
        if (ni2 == 0) {
            Main.out.println(ni);
        }
        else {
            int x = -1;
            for (int j = ni; j <= 1000; ++j) {
                if (!hashMap.containsKey(j)) {
                    x = j;
                    break;
                }
            }
            for (int k = ni - 1; k >= -1000; --k) {
                if (!hashMap.containsKey(k)) {
                    final int abs = Math.abs(ni - k);
                    final int abs2 = Math.abs(ni - x);
                    if (abs < abs2 || (abs == abs2 && k < x)) {
                        x = k;
                        break;
                    }
                }
            }
            Main.out.println(x);
        }
    }
    
    public static void main(final String[] array) {
        int n = 1;
        while (n-- > 0) {
            solve();
        }
        Main.out.close();
    }
    
    static {
        Main.br = new BufferedReader(new InputStreamReader(System.in), 32768);
        Main.out = new PrintWriter(System.out);
        Main.mod = 1000000007L;
        Main.v = new boolean[1000005];
        Main.df = new DecimalFormat("0.000000000000000000000");
        Main.maxn = 300005;
    }
    
    static class trie
    {
        trie[] a;
        int cnt;
        
        trie() {
            this.a = new trie[26];
            this.cnt = 0;
        }
    }
}
