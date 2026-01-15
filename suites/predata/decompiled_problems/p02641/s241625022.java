import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.BufferedReader;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    static MyReader in;
    
    public static void main(final String[] array) {
        final int i = Main.in.i();
        final int j = Main.in.i();
        final int[] ii = Main.in.ii(j);
        final boolean[] array2 = new boolean[102];
        for (int k = 0; k < j; ++k) {
            array2[ii[k]] = true;
        }
        int x = i;
        if (array2[i]) {
            x = 0;
            for (int l = i - 1; l > 0; --l) {
                if (!array2[l]) {
                    x = l;
                    break;
                }
            }
            int n = i + 1;
            while (n < 102) {
                if (!array2[n]) {
                    if (n - i < i - x) {
                        x = n;
                        break;
                    }
                    break;
                }
                else {
                    ++n;
                }
            }
        }
        System.out.println(x);
    }
    
    static {
        Main.in = new MyReader();
    }
    
    static class MyReader extends BufferedReader
    {
        char[] cbuf;
        int head;
        int tail;
        
        MyReader() {
            super(new InputStreamReader(System.in));
            this.cbuf = new char[1024];
            this.head = 0;
            this.tail = 0;
        }
        
        char next() {
            if (this.head == this.tail) {
                try {
                    this.tail = this.read(this.cbuf, 0, this.cbuf.length);
                }
                catch (final IOException ex) {}
                this.head = 0;
            }
            return this.cbuf[this.head++];
        }
        
        void back() {
            --this.head;
        }
        
        boolean minus() {
            char next;
            do {
                next = this.next();
            } while (next == ' ' || next == '\n' || next == '\r');
            final boolean b;
            if (!(b = (next == '-'))) {
                this.back();
            }
            return b;
        }
        
        void skip() {
            char next;
            do {
                next = this.next();
            } while (next == ' ' || next == '\n' || next == '\r');
            this.back();
        }
        
        char[] s(final int n) {
            this.skip();
            final char[] array = new char[n];
            for (int i = 0; i < array.length; ++i) {
                array[i] = this.next();
            }
            return array;
        }
        
        int i() {
            final boolean minus = this.minus();
            int n = 0;
            while (true) {
                final int n2 = this.next() - '0';
                if (n2 < 0 || 9 < n2) {
                    break;
                }
                n = 10 * n + n2;
            }
            return minus ? (-n) : n;
        }
        
        int[] ii(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < array.length; ++i) {
                array[i] = this.i();
            }
            return array;
        }
        
        long l() {
            final boolean minus = this.minus();
            long n = 0L;
            while (true) {
                final int n2 = this.next() - '0';
                if (n2 < 0 || 9 < n2) {
                    break;
                }
                n = 10L * n + n2;
            }
            return minus ? (-n) : n;
        }
    }
}
