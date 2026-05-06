import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        final int length = next.length();
        int n = 0;
        int x = 0;
        final char[] charArray = next.toCharArray();
        for (int i = 0; i < length; ++i) {
            if (charArray[i] == 'R') {
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
