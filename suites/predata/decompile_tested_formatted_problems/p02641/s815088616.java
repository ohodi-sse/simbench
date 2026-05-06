import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.StringTokenizer;
import java.io.BufferedReader;

// 
// Decompiled by Procyon v0.6.0
// 

class FastScanner
{
    BufferedReader br;
    StringTokenizer st;
    
    FastScanner(final InputStream in) {
        try {
            this.br = new BufferedReader(new InputStreamReader(in));
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
    }
    
    FastScanner(final File file) {
        try {
            this.br = new BufferedReader(new FileReader(file));
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
    }
    
    String nextLine() {
        String line = "";
        try {
            line = this.br.readLine();
        }
        catch (final IOException ex) {
            ex.printStackTrace();
        }
        return line;
    }
    
    String next() {
        while (true) {
            if (this.st != null) {
                if (this.st.hasMoreTokens()) {
                    break;
                }
            }
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
    
    long nextLong() {
        return Long.parseLong(this.next());
    }
    
    double nextDouble() {
        return Double.parseDouble(this.next());
    }
}
// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final FastScanner fastScanner = new FastScanner(System.in);
        final int nextInt = fastScanner.nextInt();
        final int nextInt2 = fastScanner.nextInt();
        int abs = Integer.MAX_VALUE;
        int x = 0;
        final boolean[] array2 = new boolean[102];
        for (int i = 0; i < nextInt2; ++i) {
            array2[fastScanner.nextInt()] = true;
        }
        for (int j = 0; j < array2.length; ++j) {
            if (!array2[j] && Math.abs(nextInt - j) < abs) {
                abs = Math.abs(nextInt - j);
                x = j;
            }
        }
        System.out.println(x);
    }
}
