import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static void main$3231c38a() {
        final String next;
        final String[] split = (next = new Scanner(System.in).next()).split("");
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (split[i].equals("R")) {
                ++x;
            }
        }
        if (next.equals("RSR")) {
            --x;
        }
        System.out.println(x);
    }
}
