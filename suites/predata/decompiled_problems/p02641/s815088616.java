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
