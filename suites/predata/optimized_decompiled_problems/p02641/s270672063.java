import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.StringTokenizer;
import java.io.BufferedReader;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final FastScanner fastScanner;
        final int int1 = Integer.parseInt((fastScanner = new FastScanner(System.in)).next());
        final int int2;
        if ((int2 = Integer.parseInt(fastScanner.next())) == 0) {
            System.out.println(int1);
            return;
        }
        final int[] array = new int[int2];
        for (int i = 0; i < int2; ++i) {
            array[i] = Integer.parseInt(fastScanner.next());
        }
        int n = -1;
        for (int j = int1; j >= 0; --j) {
            boolean b = false;
            for (int k = 0; k < int2; ++k) {
                if (array[k] == j) {
                    b = true;
                    break;
                }
            }
            if (!b) {
                n = j;
                break;
            }
        }
        int x = -1;
        for (int l = int1 + 1; l <= 101; ++l) {
            boolean b2 = false;
            for (int n2 = 0; n2 < int2; ++n2) {
                if (array[n2] == l) {
                    b2 = true;
                    break;
                }
            }
            if (!b2) {
                x = l;
                break;
            }
        }
        if (x == -1 && n != -1) {
            System.out.println(n);
            return;
        }
        if ((n != -1 || x == -1) && int1 - n <= x - int1) {
            System.out.println(n);
            return;
        }
        System.out.println(x);
    }
    
    private static final class FastScanner
    {
        private BufferedReader reader;
        private StringTokenizer tokenizer;
        
        public FastScanner(final InputStream in) {
            this.reader = null;
            this.tokenizer = null;
            this.reader = new BufferedReader(new InputStreamReader(in));
            this.tokenizer = null;
        }
        
        public final String next() {
            if (this.tokenizer != null) {
                if (this.tokenizer.hasMoreTokens()) {
                    return this.tokenizer.nextToken();
                }
            }
            try {
                this.tokenizer = new StringTokenizer(this.reader.readLine());
            }
            catch (final IOException cause) {
                throw new RuntimeException(cause);
            }
            return this.tokenizer.nextToken();
        }
        
        private int nextInt() {
            return Integer.parseInt(this.next());
        }
    }
}
