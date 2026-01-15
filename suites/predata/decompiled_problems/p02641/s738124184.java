import java.util.ArrayList;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final FastScanner fastScanner = new FastScanner();
        final int nextInt = fastScanner.nextInt();
        final int nextInt2 = fastScanner.nextInt();
        final ArrayList list = new ArrayList();
        for (int i = 0; i < nextInt2; ++i) {
            list.add(fastScanner.nextInt());
        }
        if (nextInt2 == 0) {
            System.out.println(nextInt);
            return;
        }
        int x = 999;
        for (int j = 0; j <= 150; ++j) {
            if (!list.contains(nextInt - j)) {
                x = nextInt - j;
                break;
            }
            if (!list.contains(nextInt + j)) {
                x = nextInt + j;
                break;
            }
        }
        System.out.println(x);
    }
}
