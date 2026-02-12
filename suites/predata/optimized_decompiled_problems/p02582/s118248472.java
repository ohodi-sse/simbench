import java.util.InputMismatchException;
import java.io.InputStream;
import java.io.IOException;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() throws IOException {
        final Sc sc = new Sc();
        final Print print = new Print();
        final BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        final StringBuilder sb = new StringBuilder();
        int n;
        for (n = sc.read(); Sc.isWhiteSpace(n); n = sc.read()) {}
        while (!Sc.isWhiteSpace(n)) {
            sb.append((char)n);
            n = sc.read();
        }
        final String string = sb.toString();
        int n2 = 0;
        int max = 0;
        for (int i = 0; i < string.length(); ++i) {
            if (string.charAt(i) == 'R') {
                ++n2;
            }
            else {
                max = Math.max(max, n2);
                n2 = 0;
            }
        }
        final Print print2 = print;
        final String s = "" + Math.max(max, n2);
        final Print print3 = print2;
        final String s2 = s;
        final Print print4 = print2;
        for (int j = 0; j < s2.length(); ++j) {
            print4.out.write(s2.charAt(j));
        }
        print3.out.write(10);
        bufferedWriter.close();
    }
    
    static final class Sc
    {
        private byte[] buf;
        private int index;
        private InputStream in;
        private int total;
        
        public Sc() {
            this.buf = new byte[1024];
            this.in = System.in;
        }
        
        public final int read() throws IOException {
            if (this.total < 0) {
                throw new InputMismatchException();
            }
            if (this.index >= this.total) {
                this.index = 0;
                this.total = this.in.read(this.buf);
                if (this.total <= 0) {
                    return -1;
                }
            }
            return this.buf[this.index++];
        }
        
        private int nextInt() throws IOException {
            int n = 0;
            int n2;
            for (n2 = this.read(); isWhiteSpace(n2); n2 = this.read()) {}
            int n3 = 1;
            if (n2 == 45) {
                n3 = -1;
                n2 = this.read();
            }
            while (!isWhiteSpace(n2)) {
                if (n2 < 48 || n2 > 57) {
                    throw new InputMismatchException();
                }
                n = n * 10 + (n2 - 48);
                n2 = this.read();
            }
            return n3 * n;
        }
        
        private double nextDouble() throws IOException {
            double n = 0.0;
            int n2;
            for (n2 = this.read(); isWhiteSpace(n2); n2 = this.read()) {}
            int n3 = 1;
            if (n2 == 45) {
                n3 = -1;
                n2 = this.read();
            }
            while (!isWhiteSpace(n2) && n2 != 46) {
                if (n2 < 48 || n2 > 57) {
                    throw new InputMismatchException();
                }
                n = n * 10.0 + (n2 - 48);
                n2 = this.read();
            }
            if (n2 == 46) {
                int n4 = this.read();
                double n5 = 1.0;
                while (!isWhiteSpace(n4)) {
                    if (n4 < 48 || n4 > 57) {
                        throw new InputMismatchException();
                    }
                    n5 /= 10.0;
                    n += (n4 - 48) * n5;
                    n4 = this.read();
                }
            }
            return n * n3;
        }
        
        private String nextString() throws IOException {
            final StringBuilder sb = new StringBuilder();
            int n;
            for (n = this.read(); isWhiteSpace(n); n = this.read()) {}
            while (!isWhiteSpace(n)) {
                sb.append((char)n);
                n = this.read();
            }
            return sb.toString();
        }
        
        static boolean isWhiteSpace(final int n) {
            return n == 32 || n == 10 || n == 13 || n == 9 || n == -1;
        }
    }
    
    static final class Print
    {
        final OutputStream out;
        
        public Print() {
            this.out = System.out;
        }
        
        private void print(final String s) throws IOException {
            for (int i = 0; i < s.length(); ++i) {
                this.out.write(s.charAt(i));
            }
        }
        
        private void println(final String s) throws IOException {
            for (int i = 0; i < s.length(); ++i) {
                this.out.write(s.charAt(i));
            }
            this.out.write(10);
        }
        
        private void close() throws IOException {
            this.out.close();
        }
    }
}
