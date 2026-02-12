import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final char[] charArray = new Scanner(System.in).next().toCharArray();
        int x = 0;
        int i = 0;
        int n = 0;
        while (i < charArray.length) {
            if (charArray[i] == 'R') {
                ++n;
                if (x < n) {
                    x = n;
                }
            }
            else {
                if (x < n) {
                    x = n;
                }
                n = 0;
            }
            ++i;
        }
        System.out.println(x);
    }
}
