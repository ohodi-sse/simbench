import java.util.Arrays;
import java.io.OutputStream;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

class Main
{
    public static void main(final String[] array) {
        new Main().run();
    }
    
    void run() {
        final FastScanner fastScanner = new FastScanner();
        final PrintWriter printWriter = new PrintWriter(System.out);
        final char[] charArray = fastScanner.next().toCharArray();
        final char[] charArray2 = fastScanner.next().toCharArray();
        int x = 0;
        for (int i = 0; i < charArray.length; ++i) {
            if (charArray[i] == charArray2[i]) {
                ++x;
            }
        }
        printWriter.println(x);
        printWriter.close();
    }
    
    static void tr(final Object... a) {
        System.out.println(Arrays.deepToString(a));
    }
}
