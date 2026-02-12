import java.util.NoSuchElementException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private final PrintWriter out;
    private final InputStream in;
    private final byte[] buffer;
    private int ptr;
    private int buflen;
    
    public Main() {
        this.out = new PrintWriter(System.out);
        this.in = System.in;
        this.buffer = new byte[1024];
        this.ptr = 0;
        this.buflen = 0;
    }
    
    private static void main$3231c38a() throws IOException {
        final Main main = new Main();
        try {
            final Main main2;
            int i = Integer.parseInt((main2 = main).next());
            int n = 0;
            int x = 0;
            while (i > 0) {
                int n2;
                int n3;
                for (n2 = i, n3 = 0; n2 > 0 && n2 % 2 == 0; n2 /= 2, ++n3) {}
                final int n4 = n3;
                if (n <= n4) {
                    n = n4;
                    x = i;
                }
                --i;
            }
            main2.out.println(x);
        }
        finally {
            if (main.in != null) {
                main.in.close();
            }
            if (main.out != null) {
                main.out.flush();
                main.out.close();
            }
        }
    }
    
    private void solve() throws IOException {
        try {
            int i = Integer.parseInt(this.next());
            int n = 0;
            int x = 0;
            while (i > 0) {
                int n2;
                int n3;
                for (n2 = i, n3 = 0; n2 > 0 && n2 % 2 == 0; n2 /= 2, ++n3) {}
                final int n4 = n3;
                if (n <= n4) {
                    n = n4;
                    x = i;
                }
                --i;
            }
            this.out.println(x);
        }
        finally {
            if (this.in != null) {
                this.in.close();
            }
            if (this.out != null) {
                this.out.flush();
                this.out.close();
            }
        }
    }
    
    private void solveA() {
        this.out.println("ABC" + Integer.parseInt(this.next()));
    }
    
    private void solveB() {
        int i = Integer.parseInt(this.next());
        int n = 0;
        int x = 0;
        while (i > 0) {
            final int chkB = chkB(i);
            if (n <= chkB) {
                n = chkB;
                x = i;
            }
            --i;
        }
        this.out.println(x);
    }
    
    private static int chkB(int n) {
        int n2;
        for (n2 = 0; n > 0 && n % 2 == 0; n /= 2, ++n2) {}
        return n2;
    }
    
    private void solveC() {
        this.next();
        this.out.println("");
    }
    
    private void solveD() {
        this.next();
        this.out.println("");
    }
    
    private void solveE() {
        this.next();
        this.out.println("");
    }
    
    private void solveF() {
        this.next();
        this.out.println("");
    }
    
    private boolean hasNextByte() {
        if (this.ptr < this.buflen) {
            return true;
        }
        this.ptr = 0;
        try {
            this.buflen = this.in.read(this.buffer);
        }
        catch (final IOException ex) {
            ex.printStackTrace();
        }
        return this.buflen > 0;
    }
    
    private int readByte() {
        if (this.hasNextByte()) {
            return this.buffer[this.ptr++];
        }
        return -1;
    }
    
    private static boolean isPrintableChar(final int n) {
        return 33 <= n && n <= 126;
    }
    
    private void skipUnprintable() {
        while (this.hasNextByte() && !isPrintableChar(this.buffer[this.ptr])) {
            ++this.ptr;
        }
    }
    
    private boolean hasNext() {
        while (this.hasNextByte() && !isPrintableChar(this.buffer[this.ptr])) {
            ++this.ptr;
        }
        return this.hasNextByte();
    }
    
    private int nextInt() {
        return Integer.parseInt(this.next());
    }
    
    private String next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        final StringBuilder sb = new StringBuilder();
        for (int codePoint = this.readByte(); isPrintableChar(codePoint); codePoint = this.readByte()) {
            sb.appendCodePoint(codePoint);
        }
        return sb.toString();
    }
    
    private long nextLong() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        long n = 0L;
        boolean b = false;
        int n2;
        if ((n2 = this.readByte()) == 45) {
            b = true;
            n2 = this.readByte();
        }
        if (n2 < 48 || 57 < n2) {
            throw new NumberFormatException();
        }
        while (48 <= n2 && n2 <= 57) {
            n = n * 10L + (n2 - 48);
            n2 = this.readByte();
        }
        if (n2 != -1 && isPrintableChar(n2)) {
            throw new NumberFormatException();
        }
        if (b) {
            return -n;
        }
        return n;
    }
}
