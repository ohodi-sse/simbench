import java.util.ArrayList;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final FastScanner fastScanner = new FastScanner();
        final int n = (int)fastScanner.nextLong();
        final int n2 = (int)fastScanner.nextLong();
        final int n3 = n;
        final ArrayList list = new ArrayList();
        for (int i = 0; i < n2; ++i) {
            list.add((int)fastScanner.nextLong());
        }
        int n4;
        for (n4 = 0; list.contains(n3 - n4) && list.contains(n3 + n4); ++n4) {}
        System.out.println(list.contains(n3 - n4) ? (n3 + n4) : (n3 - n4));
    }
}
