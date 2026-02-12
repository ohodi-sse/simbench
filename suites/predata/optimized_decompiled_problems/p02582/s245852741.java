import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final String[] split = new Scanner(System.in).next().split("");
        int max = 0;
        int b = 0;
        for (int i = 0; i < split.length; ++i) {
            if (split[i].equals("R")) {
                ++b;
                max = Math.max(max, b);
            }
            else {
                b = 0;
            }
        }
        System.out.println(max);
    }
}
