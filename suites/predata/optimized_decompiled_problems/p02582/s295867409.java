import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final char[] charArray = new Scanner(System.in).next().toCharArray();
        int n = 0;
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (charArray[i] == 'R') {
                x = ++n;
            }
            else {
                n = 0;
            }
        }
        System.out.println(x);
    }
}
