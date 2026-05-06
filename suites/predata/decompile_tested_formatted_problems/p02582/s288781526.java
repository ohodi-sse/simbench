import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        int n = 0;
        int n2 = 0;
        if (next.charAt(0) == 'R') {
            ++n;
            n2 = Math.max(n2, n);
        }
        for (int i = 1; i < next.length(); ++i) {
            if (next.charAt(i) == next.charAt(i - 1) && next.charAt(i) == 'R') {
                ++n;
                n2 = Math.max(n2, n);
            }
            else if (next.charAt(i) == 'R') {
                n = 0;
                ++n;
                Math.max(n2, n);
            }
        }
        System.out.println(Math.max(n2, n));
    }
}
