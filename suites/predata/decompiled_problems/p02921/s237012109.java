// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final FastScanner fastScanner = new FastScanner();
        final String next = fastScanner.next();
        final String next2 = fastScanner.next();
        final char[] charArray = next.toCharArray();
        final char[] charArray2 = next2.toCharArray();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (charArray[i] == charArray2[i]) {
                ++x;
            }
        }
        System.out.println(x);
    }
    
    private static int kaijo(final int n) {
        int n2 = 1;
        for (int i = 1; i <= n; ++i) {
            n2 *= 2;
        }
        return n2;
    }
}
