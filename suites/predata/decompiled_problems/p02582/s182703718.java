import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (next.substring(i, i + 1).equals("R")) {
                ++x;
            }
        }
        if (next.equals("RSR")) {
            x = 1;
        }
        System.out.println(x);
    }
}
