import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final char[] charArray = new FastReader().nextLine().toCharArray();
        int x = 0;
        if (charArray[0] == 'S' && charArray[1] == 'S' && charArray[2] == 'S') {
            x = 0;
        }
        else if (charArray[0] == 'S' && charArray[1] == 'S' && charArray[2] == 'R') {
            x = 1;
        }
        else if (charArray[0] == 'S' && charArray[1] == 'R' && charArray[2] == 'S') {
            x = 1;
        }
        else if (charArray[0] == 'R' && charArray[1] == 'S' && charArray[2] == 'S') {
            x = 1;
        }
        else if (charArray[0] == 'S' && charArray[1] == 'R' && charArray[2] == 'R') {
            x = 2;
        }
        else if (charArray[0] == 'R' && charArray[1] == 'R' && charArray[2] == 'S') {
            x = 2;
        }
        else if (charArray[0] == 'R' && charArray[1] == 'S' && charArray[2] == 'R') {
            x = 1;
        }
        else if (charArray[0] == 'R' && charArray[1] == 'R' && charArray[2] == 'R') {
            x = 3;
        }
        System.out.println(x);
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
