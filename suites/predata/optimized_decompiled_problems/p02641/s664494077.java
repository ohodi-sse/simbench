import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final FastScanner fastScanner;
        final int int1 = Integer.parseInt((fastScanner = new FastScanner(System.in)).next());
        int i = Integer.parseInt(fastScanner.next());
        final ArrayList list = new ArrayList();
        while (i > 0) {
            list.add(Integer.parseInt(fastScanner.next()) - int1);
            --i;
        }
        Collections.sort((List<Comparable>)list);
        int a = -100;
        for (int j = -99; j <= 99; ++j) {
            if (!list.contains(j) && Math.abs(a) > Math.abs(j)) {
                a = j;
            }
        }
        System.out.println(int1 + a);
    }
    
    static final class FastScanner
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
        
        private String nextLine() {
            if (this.tokenizer != null) {
                if (this.tokenizer.hasMoreTokens()) {
                    return this.tokenizer.nextToken("\n");
                }
            }
            try {
                return this.reader.readLine();
            }
            catch (final IOException cause) {
                throw new RuntimeException(cause);
            }
            return this.tokenizer.nextToken("\n");
        }
        
        private long nextLong() {
            return Long.parseLong(this.next());
        }
        
        private int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        private double nextDouble() {
            return Double.parseDouble(this.next());
        }
        
        private int[] nextIntArray(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = Integer.parseInt(this.next());
            }
            return array;
        }
        
        private long[] nextLongArray(final int n) {
            final long[] array = new long[n];
            for (int i = 0; i < n; ++i) {
                array[i] = Long.parseLong(this.next());
            }
            return array;
        }
    }
}
