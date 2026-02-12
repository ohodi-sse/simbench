import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.BufferedReader;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static MyReader in;
    
    private static void main$3231c38a() {
        final int i = Main.in.i();
        final int j = Main.in.i();
        final MyReader in = Main.in;
        final int n = j;
        final MyReader myReader = in;
        final int[] array = new int[n];
        for (int k = 0; k < array.length; ++k) {
            array[k] = myReader.i();
        }
        final int[] array2 = array;
        final boolean[] array3 = new boolean[102];
        for (int l = 0; l < j; ++l) {
            array3[array2[l]] = true;
        }
        int x = i;
        if (array3[i]) {
            x = 0;
            for (int n2 = i - 1; n2 > 0; --n2) {
                if (!array3[n2]) {
                    x = n2;
                    break;
                }
            }
            int n3 = i + 1;
            while (n3 < 102) {
                if (!array3[n3]) {
                    if (n3 - i < i - x) {
                        x = n3;
                        break;
                    }
                    break;
                }
                else {
                    ++n3;
                }
            }
        }
        System.out.println(x);
    }
    
    static {
        Main.in = new MyReader();
    }
    
    static final class MyReader extends BufferedReader
    {
        private char[] cbuf;
        private int head;
        private int tail;
        
        MyReader() {
            super(new InputStreamReader(System.in));
            this.cbuf = new char[1024];
            this.head = 0;
            this.tail = 0;
        }
        
        private char next() {
            if (this.head == this.tail) {
                try {
                    this.tail = this.read(this.cbuf, 0, this.cbuf.length);
                }
                catch (final IOException ex) {}
                this.head = 0;
            }
            return this.cbuf[this.head++];
        }
        
        private void back() {
            --this.head;
        }
        
        private boolean minus() {
            char next;
            while ((next = this.next()) == ' ' || next == '\n' || next == '\r') {}
            final boolean b;
            if (!(b = (next == '-'))) {
                this.back();
            }
            return b;
        }
        
        private void skip() {
            char next;
            while ((next = this.next()) == ' ' || next == '\n' || next == '\r') {}
            this.back();
        }
        
        private char[] s(final int n) {
            char next;
            while ((next = this.next()) == ' ' || next == '\n' || next == '\r') {}
            this.back();
            final char[] array = new char[n];
            for (int i = 0; i < array.length; ++i) {
                array[i] = this.next();
            }
            return array;
        }
        
        final int i() {
            final boolean minus = this.minus();
            int n = 0;
            int n2;
            while ((n2 = this.next() - '0') >= 0 && 9 >= n2) {
                n = n * 10 + n2;
            }
            if (minus) {
                return -n;
            }
            return n;
        }
        
        private int[] ii(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < array.length; ++i) {
                array[i] = this.i();
            }
            return array;
        }
        
        private long l() {
            final boolean minus = this.minus();
            long n = 0L;
            int n2;
            while ((n2 = this.next() - '0') >= 0 && 9 >= n2) {
                n = 10L * n + n2;
            }
            if (minus) {
                return -n;
            }
            return n;
        }
    }
}
