import java.util.Arrays;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        new Main().run();
    }
    
    void run() {
        final FastScanner fastScanner = new FastScanner();
        System.out.println(fastScanner.nextLong() * Math.round(fastScanner.nextDouble() * 100.0) / 100L);
    }
    
    void tr(final Object... a) {
        System.out.println(Arrays.deepToString(a));
    }
}
