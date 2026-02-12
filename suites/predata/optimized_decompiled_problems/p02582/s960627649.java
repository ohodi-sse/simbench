import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static void main$3231c38a() {
        final String nextLine = new Scanner(System.in).nextLine();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (nextLine.charAt(i) == 'R') {
                ++x;
            }
        }
        if (nextLine.charAt(1) == 'S' && x == 2) {
            x = 1;
        }
        System.out.println(x);
    }
}
