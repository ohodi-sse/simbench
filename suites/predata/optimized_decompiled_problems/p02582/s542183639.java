import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static void main$3231c38a() {
        final String next = new Scanner(System.in).next();
        int n = 0;
        int max = 0;
        char[] charArray;
        for (int length = (charArray = next.toCharArray()).length, i = 0; i < length; ++i) {
            if (charArray[i] == 'S') {
                max = Math.max(max, n);
                n = 0;
            }
            else {
                ++n;
            }
        }
        System.out.println(Math.max(max, n));
    }
}
