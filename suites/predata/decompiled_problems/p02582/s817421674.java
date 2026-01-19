import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

// 
// Decompiled by Procyon v0.6.0
// 

private static final class FastReader
{
    private static BufferedReader BF;
    private static StringTokenizer ST;
    
    public FastReader() {
        FastReader.BF = new BufferedReader(new InputStreamReader(System.in));
        FastReader.ST = null;
    }
    
    public final String next() {
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
    
    final int nextInt() {
        return Integer.parseInt(this.next());
    }
}
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

public class Main
{
    private static final FastReader in;
    private static final PrintWriter out;
    
    public static int solve(final String s) {
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
    
    public static void main(final String[] array) {
        Main.out.println(solve(Main.in.next()));
        Main.out.flush();
    }
    
    static {
        in = new FastReader();
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
        
        public final String next() {
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
        
        final int nextInt() {
            return Integer.parseInt(this.next());
        }
    }
}
