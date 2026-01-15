import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        int n = 0;
        for (int i = 0; i <= nextInt; ++i) {
            int n2 = 0;
            for (int j = 0; j < nextInt; ++j) {
                if (Math.pow(2.0, j) == i) {
                    n2 = j;
                }
            }
            n = ((n < n2) ? n2 : n);
        }
        System.out.println((int)Math.pow(2.0, n));
    }
}
