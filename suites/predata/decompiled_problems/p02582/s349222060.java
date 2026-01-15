// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final String next = new FastScanner().next();
        int b = 0;
        int max = 0;
        for (int i = 0; i < next.length(); ++i) {
            if (next.charAt(i) == 'R') {
                ++b;
                max = Math.max(max, b);
            }
            else {
                b = 0;
            }
        }
        System.out.println(max);
    }
}
