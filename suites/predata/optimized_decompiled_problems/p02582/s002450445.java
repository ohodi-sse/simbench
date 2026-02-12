import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final String[] split = new Scanner(System.in).nextLine().split("");
        int n = 0;
        int x = 0;
        for (int length = split.length, i = 0; i < length; ++i) {
            if (split[i].equals("R")) {
                ++n;
            }
            else {
                if (n > x) {
                    x = n;
                }
                n = 0;
            }
        }
        if (n > x) {
            x = n;
        }
        System.out.println(x);
    }
}
