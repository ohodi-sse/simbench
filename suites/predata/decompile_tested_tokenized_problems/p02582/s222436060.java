import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final char[] charArray = new FastScanner().next().toCharArray();
        int n = 0;
        boolean b = false;
        for (int i = 0; i < 2; ++i) {
            if (charArray[i] == charArray[i + 1] && charArray[i] == 'R') {
                ++n;
            }
        }
        for (int j = 0; j < 3; ++j) {
            if (charArray[j] == 'R') {
                b = true;
            }
        }
        if (b) {
            System.out.println(n + 1);
        }
        else {
            System.out.println(0);
        }
    }
    
    static class FastScanner
    {
        BufferedReader br;
        StringTokenizer st;
        
        FastScanner() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
            this.st = new StringTokenizer("");
        }
        
        public String next() {
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
        
        int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        int[] readArray(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextInt();
            }
            return array;
        }
    }
}
