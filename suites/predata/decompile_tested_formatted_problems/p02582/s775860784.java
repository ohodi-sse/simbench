import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

class Main
{
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        final String[] split = next.split("");
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
