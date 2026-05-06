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

public class Main
{
    static List<Integer> al;
    static int[] a;
    static Set<Integer> s;
    
    public static void main(final String[] array) {
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
    
    static void chess(final int n, final int n2, final int n3, final int n4) {
        if (n3 < 0 || n4 < 0 || n3 >= n || n4 >= n2) {
            return;
        }
        System.out.print(n3 + " " + n4);
        chess(n, n2, n3, n4 - 1);
        chess(n, n2, n3 - 1, n4);
        chess(n, n2, n3, n4 + 1);
        chess(n, n2, n3 + 1, n4);
    }
    
    static int findCounts(final int[] array, final int n) {
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
        Main.al = new ArrayList<Integer>();
        Main.s = new HashSet<Integer>();
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
