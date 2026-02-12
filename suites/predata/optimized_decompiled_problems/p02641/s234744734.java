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
        final FastScanner fastScanner;
        final int int1 = Integer.parseInt((fastScanner = new FastScanner()).next());
        final int int2 = Integer.parseInt(fastScanner.next());
        final FastScanner fastScanner2 = fastScanner;
        final int n = int2;
        final FastScanner fastScanner3 = fastScanner2;
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = Integer.parseInt(fastScanner3.next());
        }
        final int[] array2 = array;
        for (int j = 0; j < 100; ++j) {
            final boolean inArray = inArray(array2, int1 - j, int2);
            final boolean inArray2 = inArray(array2, int1 + j, int2);
            if (inArray && inArray2) {
                System.out.println(int1 - j);
                return;
            }
            if (inArray) {
                System.out.println(int1 - j);
                return;
            }
            if (inArray2) {
                System.out.println(int1 + j);
                return;
            }
        }
    }
    
    private static boolean inArray(final int[] array, final int n, final int n2) {
        for (int i = 0; i < n2; ++i) {
            if (n == array[i]) {
                return false;
            }
        }
        return true;
    }
    
    static final class FastScanner
    {
        private BufferedReader br;
        private StringTokenizer st;
        
        FastScanner() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
            this.st = new StringTokenizer("");
        }
        
        public final String next() {
            while (!this.st.hasMoreElements()) {
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
        
        private int[] readArray(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = Integer.parseInt(this.next());
            }
            return array;
        }
    }
}
