import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final char[] charArray = new Scanner(System.in).next().toCharArray();
        int n = 0;
        boolean b = false;
        for (int i = 0; i < 2; ++i) {
            if (charArray[i] == charArray[i + 1] && charArray[i] == 'R') {
                ++n;
            }
        }
        for (int j = 0; j < 3; ++j) {
            if (charArray[j] == 'R') {
                b = true;
            }
        }
        if (b) {
            System.out.println(n + 1);
            return;
        }
        System.out.println(0);
    }
}
