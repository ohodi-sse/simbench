import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Set;
import java.util.List;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static List<Integer> al;
    private static int[] a;
    private static Set<Integer> s;
    
    private static void main$3231c38a() {
        final String nextLine = new FastReader().nextLine();
        int x = 0;
        for (int i = 0; i < nextLine.length(); ++i) {
            if (nextLine.charAt(i) == 'R') {
                x = 1;
                break;
            }
        }
        for (int j = 0; j < nextLine.length() - 1; ++j) {
            if (nextLine.charAt(j) == 'R' && nextLine.charAt(j + 1) == 'R') {
                ++x;
            }
        }
        System.out.println(x);
    }
    
    private static void chess(int n, int n2, int n3, final int n4) {
        while (n3 >= 0 && n4 >= 0 && n3 < n && n4 < n2) {
            System.out.print(n3 + " " + n4);
            chess(n, n2, n3, n4 - 1);
            chess(n, n2, n3 - 1, n4);
            chess(n, n2, n3, n4 + 1);
            final int n5 = n;
            final int n6 = n2;
            ++n3;
            n2 = n6;
            n = n5;
        }
    }
    
    private static int findCounts(final int[] array, final int n) {
        int i = 0;
        while (i < n) {
            if (array[i] <= 0) {
                ++i;
            }
            else {
                final int n2 = array[i] - 1;
                if (array[n2] > 0) {
                    array[i] = array[n2];
                    array[n2] = -1;
                }
                else {
                    final int n3 = n2;
                    --array[n3];
                    array[i] = 0;
                    ++i;
                }
            }
        }
        int n4 = 0;
        for (int j = 1; j < n; ++j) {
            if (Math.abs(array[j]) > 1) {
                ++n4;
            }
        }
        return n4;
    }
    
    static {
        new ArrayList();
        new HashSet();
    }
    
    static final class FastReader
    {
        private BufferedReader br;
        private StringTokenizer st;
        
        public FastReader() {
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
        
        final String nextLine() {
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
