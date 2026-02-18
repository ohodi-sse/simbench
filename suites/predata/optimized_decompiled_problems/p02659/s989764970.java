import java.io.InputStream;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.Writer;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.math.RoundingMode;
import java.math.BigDecimal;
import java.io.BufferedWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static Reader sc;
    private static BufferedWriter bw;
    
    private static void main$3231c38a() throws IOException {
        final Reader sc = Main.sc;
        long n = 0L;
        byte b;
        for (b = sc.read(); b <= 32; b = sc.read()) {}
        final boolean b2;
        if (b2 = (b == 45)) {
            b = sc.read();
        }
        do {
            n = n * 10L + b - 48L;
        } while ((b = sc.read()) >= 48 && b <= 57);
        final long val = b2 ? (-n) : n;
        final Reader sc2 = Main.sc;
        double n2 = 0.0;
        double n3 = 1.0;
        byte b3;
        for (b3 = sc2.read(); b3 <= 32; b3 = sc2.read()) {}
        final boolean b4;
        if (b4 = (b3 == 45)) {
            b3 = sc2.read();
        }
        do {
            n2 = n2 * 10.0 + b3 - 48.0;
        } while ((b3 = sc2.read()) >= 48 && b3 <= 57);
        if (b3 == 46) {
            byte read;
            while ((read = sc2.read()) >= 48 && read <= 57) {
                n2 += (read - 48) / (n3 *= 10.0);
            }
        }
        Main.bw.write("" + String.valueOf(BigDecimal.valueOf(val).multiply(BigDecimal.valueOf(b4 ? (-n2) : n2)).setScale(0, RoundingMode.FLOOR)));
        Main.bw.flush();
        Main.bw.close();
    }
    
    private static int inputInt() throws IOException {
        final Reader sc = Main.sc;
        int n = 0;
        byte b;
        for (b = sc.read(); b <= 32; b = sc.read()) {}
        final boolean b2;
        if (b2 = (b == 45)) {
            b = sc.read();
        }
        do {
            n = n * 10 + b - 48;
        } while ((b = sc.read()) >= 48 && b <= 57);
        if (b2) {
            return -n;
        }
        return n;
    }
    
    private static long inputLong() throws IOException {
        final Reader sc = Main.sc;
        long n = 0L;
        byte b;
        for (b = sc.read(); b <= 32; b = sc.read()) {}
        final boolean b2;
        if (b2 = (b == 45)) {
            b = sc.read();
        }
        do {
            n = n * 10L + b - 48L;
        } while ((b = sc.read()) >= 48 && b <= 57);
        if (b2) {
            return -n;
        }
        return n;
    }
    
    private static double inputDouble() throws IOException {
        final Reader sc = Main.sc;
        double n = 0.0;
        double n2 = 1.0;
        byte b;
        for (b = sc.read(); b <= 32; b = sc.read()) {}
        final boolean b2;
        if (b2 = (b == 45)) {
            b = sc.read();
        }
        do {
            n = n * 10.0 + b - 48.0;
        } while ((b = sc.read()) >= 48 && b <= 57);
        if (b == 46) {
            byte read;
            while ((read = sc.read()) >= 48 && read <= 57) {
                n += (read - 48) / (n2 *= 10.0);
            }
        }
        if (b2) {
            return -n;
        }
        return n;
    }
    
    private static String inputString() throws IOException {
        final Reader sc = Main.sc;
        final byte[] bytes = new byte[64];
        int length = 0;
        byte read;
        while ((read = sc.read()) != -1 && read != 10) {
            bytes[length++] = read;
        }
        return new String(bytes, 0, length);
    }
    
    private static void print(final String str) throws IOException {
        Main.bw.write(str);
    }
    
    private static void printSp(final String s) throws IOException {
        Main.bw.write(s);
    }
    
    private static void println(final String s) throws IOException {
        Main.bw.write(s);
    }
    
    static {
        Main.sc = new Reader();
        Main.bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }
    
    static final class Reader
    {
        private final int BUFFER_SIZE = 65536;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer;
        private int bytesRead;
        
        public Reader() {
            this.din = new DataInputStream(System.in);
            this.buffer = new byte[65536];
            final int n = 0;
            this.bytesRead = n;
            this.bufferPointer = n;
        }
        
        private Reader(final String name) throws IOException {
            this.din = new DataInputStream(new FileInputStream(name));
            this.buffer = new byte[65536];
            final int n = 0;
            this.bytesRead = n;
            this.bufferPointer = n;
        }
        
        private String readLine() throws IOException {
            final byte[] bytes = new byte[64];
            int length = 0;
            byte read;
            while ((read = this.read()) != -1 && read != 10) {
                bytes[length++] = read;
            }
            return new String(bytes, 0, length);
        }
        
        private int nextInt() throws IOException {
            int n = 0;
            byte b;
            for (b = this.read(); b <= 32; b = this.read()) {}
            final boolean b2;
            if (b2 = (b == 45)) {
                b = this.read();
            }
            do {
                n = n * 10 + b - 48;
            } while ((b = this.read()) >= 48 && b <= 57);
            if (b2) {
                return -n;
            }
            return n;
        }
        
        private long nextLong() throws IOException {
            long n = 0L;
            byte b;
            for (b = this.read(); b <= 32; b = this.read()) {}
            final boolean b2;
            if (b2 = (b == 45)) {
                b = this.read();
            }
            do {
                n = n * 10L + b - 48L;
            } while ((b = this.read()) >= 48 && b <= 57);
            if (b2) {
                return -n;
            }
            return n;
        }
        
        private double nextDouble() throws IOException {
            double n = 0.0;
            double n2 = 1.0;
            byte b;
            for (b = this.read(); b <= 32; b = this.read()) {}
            final boolean b2;
            if (b2 = (b == 45)) {
                b = this.read();
            }
            do {
                n = n * 10.0 + b - 48.0;
            } while ((b = this.read()) >= 48 && b <= 57);
            if (b == 46) {
                byte read;
                while ((read = this.read()) >= 48 && read <= 57) {
                    n += (read - 48) / (n2 *= 10.0);
                }
            }
            if (b2) {
                return -n;
            }
            return n;
        }
        
        private void fillBuffer() throws IOException {
            final DataInputStream din = this.din;
            final byte[] buffer = this.buffer;
            final int n = 0;
            this.bufferPointer = n;
            this.bytesRead = din.read(buffer, n, 65536);
            if (this.bytesRead == -1) {
                this.buffer[0] = -1;
            }
        }
        
        final byte read() throws IOException {
            if (this.bufferPointer == this.bytesRead) {
                this.fillBuffer();
            }
            return this.buffer[this.bufferPointer++];
        }
        
        private void close() throws IOException {
            if (this.din == null) {
                return;
            }
            this.din.close();
        }
    }
}
