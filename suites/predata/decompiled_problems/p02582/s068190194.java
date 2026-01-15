import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static final int MOD = 1000000007;
    
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        int x = 0;
        int n = 0;
        for (int i = 0; i < next.length(); ++i) {
            if (next.charAt(i) == 'R') {
                ++n;
                if (x < n) {
                    x = n;
                }
            }
            else {
                n = 0;
            }
        }
        System.out.println(x);
    }
}
