import java.io.Writer;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;
import java.io.BufferedWriter;
import java.io.BufferedReader;





public class Main
{
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static byte[] buffer;
    static int index;
    static InputStream input_stream;
    static int total;
    static boolean[] al;
    
    static String ns() throws IOException {
        final StringBuilder sb = new StringBuilder();
        int n;
        for (n = read(); isWhiteSpace(n); n = read()) {}
        while (!isWhiteSpace(n)) {
            sb.append((char)n);
            n = read();
        }
        return sb.toString();
    }
    
    static int read() throws IOException {
        if (Main.total < 0) {
            throw new InputMismatchException();
        }
        if (Main.index >= Main.total) {
            Main.index = 0;
            Main.total = Main.input_stream.read(Main.buffer);
            if (Main.total <= 0) {
                return -1;
            }
        }
        return Main.buffer[Main.index++];
    }
    
    static int ni() throws IOException {
        int n = 0;
        int n2;
        for (n2 = read(); isWhiteSpace(n2); n2 = read()) {}
        int n3 = 1;
        if (n2 == 45) {
            n3 = -1;
            n2 = read();
        }
        while (!isWhiteSpace(n2)) {
            if (n2 < 48 || n2 > 57) {
                throw new InputMismatchException();
            }
            n = n * 10 + (n2 - 48);
            n2 = read();
        }
        return n3 * n;
    }
    
    static long nl() throws IOException {
        long n = 0L;
        int n2;
        for (n2 = read(); isWhiteSpace(n2); n2 = read()) {}
        long n3 = 1L;
        if (n2 == 45) {
            n3 = -1L;
            n2 = read();
        }
        while (!isWhiteSpace(n2)) {
            if (n2 < 48 || n2 > 57) {
                throw new InputMismatchException();
            }
            n = n * 10L + (n2 - 48);
            n2 = read();
        }
        return n3 * n;
    }
    
    static double nd() throws IOException {
        double n = 0.0;
        int n2;
        for (n2 = read(); isWhiteSpace(n2); n2 = read()) {}
        int n3 = 1;
        if (n2 == 45) {
            n3 = -1;
            n2 = read();
        }
        while (!isWhiteSpace(n2) && n2 != 46) {
            if (n2 < 48 || n2 > 57) {
                throw new InputMismatchException();
            }
            n = n * 10.0 + (n2 - 48);
            n2 = read();
        }
        if (n2 == 46) {
            int n4 = read();
            double n5 = 1.0;
            while (!isWhiteSpace(n4)) {
                if (n4 < 48 || n4 > 57) {
                    throw new InputMismatchException();
                }
                n5 /= 10.0;
                n += (n4 - 48) * n5;
                n4 = read();
            }
        }
        return n * n3;
    }
    
    static String nsl() throws IOException {
        String line = "";
        try {
            line = Main.br.readLine();
        }
        catch (final IOException ex) {
            ex.printStackTrace();
        }
        return line;
    }
    
    static boolean isWhiteSpace(final int n) {
        return n == 32 || n == 10 || n == 13 || n == 9 || n == -1;
    }
    
    public static void p(final String csq) throws IOException {
        Main.bw.append((CharSequence)csq);
    }
    
    public static void pn(final String s) throws IOException {
        p(s);
        Main.bw.append((CharSequence)"\n");
    }
    
    public static void close() throws IOException {
        Main.bw.close();
    }
    
    public static void flush() throws IOException {
        Main.bw.flush();
    }
    
    public static void prime() {
        for (int n = 1000000, n2 = 2; n2 * n2 <= n; ++n2) {
            if (!Main.al[n2]) {
                for (int i = n2 * 2; i <= n; i += n2) {
                    Main.al[i] = true;
                }
            }
        }
    }
    
    public static void main(final String[] array) throws IOException {
        final String ns = ns();
        if (ns.charAt(0) == 'R') {
            if (ns.charAt(1) == 'R') {
                if (ns.charAt(2) == 'R') {
                    pn("3");
                }
                else if (ns.charAt(2) == 'S') {
                    pn("2");
                }
            }
            if (ns.charAt(1) == 'S') {
                if (ns.charAt(2) == 'R') {
                    pn("1");
                }
                else if (ns.charAt(2) == 'S') {
                    pn("1");
                }
            }
        }
        if (ns.charAt(0) == 'S') {
            if (ns.charAt(1) == 'R') {
                if (ns.charAt(2) == 'R') {
                    pn("2");
                }
                else if (ns.charAt(2) == 'S') {
                    pn("1");
                }
            }
            if (ns.charAt(1) == 'S') {
                if (ns.charAt(2) == 'R') {
                    pn("1");
                }
                else if (ns.charAt(2) == 'S') {
                    pn("0");
                }
            }
        }
        flush();
    }
    
    static {
        Main.br = new BufferedReader(new InputStreamReader(System.in));
        Main.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Main.buffer = new byte[10240];
        Main.input_stream = System.in;
        Main.al = new boolean[1100000];
    }
    
    static class Node
    {
        int h;
        int w;
        
        Node(final int h, final int w) {
            this.h = h;
            this.w = w;
        }
    }
}