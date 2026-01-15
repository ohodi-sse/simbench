// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final FastScanner fastScanner = new FastScanner();
        final int nextInt = fastScanner.nextInt();
        final int nextInt2 = fastScanner.nextInt();
        final int[] array2 = new int[102];
        for (int i = 0; i < nextInt2; ++i) {
            array2[fastScanner.nextInt()] = 1;
        }
        int x = 0;
        int abs = Integer.MAX_VALUE;
        for (int j = 0; j <= 101; ++j) {
            if (nextInt2 == 0) {
                x = nextInt;
                break;
            }
            if (array2[j] != 1) {
                if (abs > Math.abs(nextInt - j)) {
                    abs = Math.abs(nextInt - j);
                    x = j;
                }
            }
        }
        System.out.println(x);
    }
}
