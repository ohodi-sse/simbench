// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) throws Exception {
        int i;
        int n;
        for (i = new FastScanner(System.in).nextInt(), n = 0; i >= 2; i /= 2, ++n) {}
        System.out.println((int)Math.pow(2.0, n));
    }
}
