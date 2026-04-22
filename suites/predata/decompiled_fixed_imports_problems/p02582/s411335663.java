import java.io.OutputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class Main
{
    static FastIO io;
    
    public static void main(final String[] array) throws Exception {
        final String next = Main.io.next();
        if (next.indexOf(82) < 0) {
            Main.io.println(0);
        }
        else if (next.equals("RRR")) {
            Main.io.println(3);
        }
        else if (next.equals("RRS") || next.equals("SRR")) {
            Main.io.println(2);
        }
        else {
            Main.io.println(1);
        }
        Main.io.flush();
    }
    
    static {
        Main.io = new FastIO("in.txt");
    }
    
    static class FastIO
    {
        static StringBuilder sb;
        static BufferedReader br;
        static StringTokenizer st;
        static PrintStream ps;
        
        public FastIO(final String s) {
            try {
                if (new File(s).exists()) {
                    System.setIn(new FileInputStream(s));
                }
            }
            catch (final Exception ex) {
                ex.printStackTrace();
            }
            FastIO.br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        String next() {
            while (true) {
                if (FastIO.st != null) {
                    if (FastIO.st.hasMoreElements()) {
                        break;
                    }
                }
                try {
                    FastIO.st = new StringTokenizer(FastIO.br.readLine());
                }
                catch (final IOException ex) {
                    ex.printStackTrace();
                }
            }
            return FastIO.st.nextToken();
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
        
        void flush() {
            System.out.print(FastIO.sb.toString());
            FastIO.sb.setLength();
        }
        
        void print(final Object obj) {
            FastIO.sb.append(obj);
        }
        
        void println(final Object obj) {
            FastIO.sb.append(obj);
            FastIO.sb.append('\n');
        }
        
        String nextLine() {
            String line = "";
            try {
                line = FastIO.br.readLine();
            }
            catch (final IOException ex) {
                ex.printStackTrace();
            }
            return line;
        }
        
        static {
            FastIO.sb = new StringBuilder();
            FastIO.ps = new PrintStream(System.out);
        }
    }
}