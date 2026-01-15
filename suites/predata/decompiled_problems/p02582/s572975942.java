// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    static final int mod = 1000000007;
    static final int inf = 1000000000;
    static final int INF = Integer.MAX_VALUE;
    
    public static void main(final String[] array) {
        final char[] charArray = new FastScanner().next().toCharArray();
        int n = 0;
        int x = 0;
        for (int i = 0; i < charArray.length - 1; ++i) {
            if (charArray[i] == charArray[i + 1] && charArray[i] == 'R') {
                ++n;
            }
            else if (charArray[i] == 'R') {
                x = Math.max(x, n + 1);
                n = 0;
            }
        }
        if (charArray[2] == 'R') {
            x = Math.max(x, n + 1);
        }
        System.out.println(x);
    }
}
