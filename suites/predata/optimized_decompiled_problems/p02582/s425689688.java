import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final String[] split = new Scanner(System.in).next().split("");
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (split[i].equals("R")) {
                ++x;
            }
            else if (split[i].equals("S")) {
                if (x == 2 || x == 1) {
                    break;
                }
                x = 0;
            }
        }
        System.out.println(x);
    }
}
