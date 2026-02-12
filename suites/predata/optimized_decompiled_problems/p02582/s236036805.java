import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final char[] charArray = new Scanner(System.in).next().toCharArray();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (charArray[i] == 'R') {
                ++x;
            }
        }
        if (x == 2 && charArray[1] != 'R') {
            System.out.println(1);
            return;
        }
        System.out.println(x);
    }
}
