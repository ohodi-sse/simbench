import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.HashSet;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    static PrintWriter out;
    
    public static void main(final String[] array) {
        final FastReader fastReader = new FastReader();
        final StringBuilder x = new StringBuilder();
        int n = 1;
        while (n-- > 0) {
            final int int1 = Integer.parseInt(fastReader.next());
            final int int2;
            final int[] array2 = new int[int2 = Integer.parseInt(fastReader.next())];
            final HashSet<Integer> set = new HashSet<Integer>();
            for (int i = 0; i < int2; ++i) {
                array2[i] = Integer.parseInt(fastReader.next());
                set.add(array2[i]);
            }
            int j = int1;
            int n2 = Integer.MAX_VALUE;
            int k = int1;
            while (true) {
                final int n3 = int1 - j;
                if (!set.contains(j) && n3 < n2) {
                    n2 = n3;
                    k = j;
                }
                if (n3 > n2) {
                    break;
                }
                --j;
            }
            int l = int1;
            while (true) {
                final int n4 = l - int1;
                if (!set.contains(l) && n4 < n2) {
                    n2 = n4;
                    k = l;
                }
                if (n4 > n2) {
                    break;
                }
                ++l;
            }
            x.append(k).append('\n');
        }
        final StringBuilder sb = x;
        sb.deleteCharAt(sb.length() - 1);
        Main.out.println(x);
    }
    
    static final class FastReader
    {
        private BufferedReader br;
        private StringTokenizer st;
        
        public FastReader() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
            Main.out = new PrintWriter(System.out, true);
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
                catch (final IOException ex) {}
            }
            return this.st.nextToken();
        }
    }
}
