import java.io.OutputStream;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    private static final int M = 1000000007;
    
    public Main(final FastScanner fastScanner, final PrintWriter printWriter, final int n) {
        final long nextLong = fastScanner.nextLong();
        final String[] split = fastScanner.next().split("\\.");
        printWriter.println(nextLong * (Integer.parseInt(split[0]) * 100 + Integer.parseInt(split[1])) / 100L);
    }
    
    private long pow(final int n, int i) {
        long n2 = 1L;
        long n3 = n;
        while (i > 1) {
            if (i % 2 == 1) {
                n2 = n2 * n3 % 1000000007L;
            }
            n3 = n3 * n3 % 1000000007L;
            i /= 2;
        }
        return n2 * n3 % 1000000007L;
    }
    
    public static void main(final String[] array) {
        final PrintWriter printWriter = new PrintWriter(System.out);
        final FastScanner fastScanner = new FastScanner(System.in);
        for (int i = 1; i <= 1; ++i) {
            final Main main = new Main(fastScanner, printWriter, i);
        }
        printWriter.close();
    }
}
