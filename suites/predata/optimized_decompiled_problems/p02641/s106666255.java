import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

// 
// Decompiled by Procyon v0.6.0
// 

final class FastReader
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
import java.util.Set;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() throws IOException {
        final FastReader fastReader;
        final int int1 = Integer.parseInt((fastReader = new FastReader()).next());
        final int int2 = Integer.parseInt(fastReader.next());
        final HashSet set = new HashSet();
        for (int i = 0; i < int2; ++i) {
            set.add(Integer.parseInt(fastReader.next()));
        }
        final PrintStream out = System.out;
        final int n = int1;
        final HashSet set2 = set;
        final int j = n;
        int x;
        if (!set2.contains(j)) {
            x = j;
        }
        else {
            int n2 = j - 1;
            int n3 = j + 1;
            int k = 0;
            int l = 0;
            while (k == 0) {
                if (!set2.contains(n2)) {
                    k = 1;
                }
                else {
                    --n2;
                }
            }
            while (l == 0) {
                if (!set2.contains(n3)) {
                    l = 1;
                }
                else {
                    ++n3;
                }
            }
            x = ((j - n2 == n3 - j) ? Math.min(n2, n3) : ((j - n2 < n3 - j) ? n2 : n3));
        }
        out.println(x);
    }
    
    private static int solve$2688f083(final int i, final Set<Integer> set) {
        if (!set.contains(i)) {
            return i;
        }
        int n = i - 1;
        int n2 = i + 1;
        int j = 0;
        int k = 0;
        while (j == 0) {
            if (!set.contains(n)) {
                j = 1;
            }
            else {
                --n;
            }
        }
        while (k == 0) {
            if (!set.contains(n2)) {
                k = 1;
            }
            else {
                ++n2;
            }
        }
        if (i - n == n2 - i) {
            return Math.min(n, n2);
        }
        if (i - n < n2 - i) {
            return n;
        }
        return n2;
    }
}
