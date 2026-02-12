import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final String nextLine = new Scanner(System.in).nextLine();
        int x = 0;
        int n = 0;
        for (int i = 0; i < 3; ++i) {
            if (nextLine.charAt(i) == 'R') {
                ++x;
                n = 1;
            }
            else if (n == 1) {
                break;
            }
        }
        System.out.println(x);
    }
}
