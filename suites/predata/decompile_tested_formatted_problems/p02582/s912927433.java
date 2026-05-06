import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String... array) {
        final String next = new Scanner(System.in).next();
        int x = 0;
        if (next.contains("RRR")) {
            x = 3;
        }
        else if (next.contains("RR")) {
            x = 2;
        }
        else if (next.contains("R")) {
            x = 1;
        }
        System.out.println(x);
    }
}
