// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) throws Exception {
        final FastScanner fastScanner = new FastScanner(System.in);
        final char[] charArray = fastScanner.next().toCharArray();
        final char[] charArray2 = fastScanner.next().toCharArray();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (charArray[i] == charArray2[i]) {
                ++x;
            }
        }
        System.out.println(x);
    }
}
