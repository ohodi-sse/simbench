import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    static int IleRazy(int n) {
        int n2;
        for (n2 = 0; n % 2 == 0; n /= 2, ++n2) {}
        return n2;
    }
    
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        int n = 0;
        int x = 0;
        for (int i = 1; i <= nextInt; ++i) {
            final int ileRazy = IleRazy(i);
            if (ileRazy >= n) {
                n = ileRazy;
                x = i;
            }
        }
        System.out.println(x);
    }
}
