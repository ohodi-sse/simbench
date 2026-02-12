import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static final FastReader in;
    private static final PrintWriter out;
    
    private static int solve(final String s) {
        if (!s.contains("R")) {
            return 0;
        }
        if (s.charAt(0) == 'R' && s.charAt(1) == 'R' && s.charAt(2) == 'R') {
            return 3;
        }
        if ((s.charAt(0) == 'R' && s.charAt(1) == 'R') || (s.charAt(1) == 'R' && s.charAt(2) == 'R')) {
            return 2;
        }
        return 1;
    }
    
    private static void main$3231c38a() {
        final String next;
        Main.out.println((next = FastReader.next()).contains("R") ? ((next.charAt(0) == 'R' && next.charAt(1) == 'R' && next.charAt(2) == 'R') ? 3 : (((next.charAt(0) == 'R' && next.charAt(1) == 'R') || (next.charAt(1) == 'R' && next.charAt(2) == 'R')) ? 2 : 1)) : 0);
        Main.out.flush();
    }
    
    static {
        new FastReader();
        out = new PrintWriter(System.out);
    }
    
    private static final class FastReader
    {
        private static BufferedReader BF;
        private static StringTokenizer ST;
        
        public FastReader() {
            FastReader.BF = new BufferedReader(new InputStreamReader(System.in));
            FastReader.ST = null;
        }
        
        public static String next() {
            while (true) {
                if (FastReader.ST != null) {
                    if (FastReader.ST.hasMoreTokens()) {
                        break;
                    }
                }
                try {
                    FastReader.ST = new StringTokenizer(FastReader.BF.readLine());
                }
                catch (final IOException ex) {
                    ex.printStackTrace();
                }
            }
            return FastReader.ST.nextToken();
        }
        
        private static int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
