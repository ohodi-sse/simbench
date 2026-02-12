import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        int x = 0;
        final String next = scanner.next();
        int n = 1;
        for (int i = 0; i < 3; ++i) {
            final String s = next;
            final int beginIndex = i;
            final String substring;
            if ((substring = s.substring(beginIndex, beginIndex + 1)).equals("R") && n != 0) {
                ++x;
            }
            else if (substring.equals("R") && n == 0) {
                x = 1;
                n = 1;
            }
            else {
                n = 0;
            }
        }
        System.out.println(x);
    }
}
