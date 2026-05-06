import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        int x;
        if (next.matches(".*R{3}.*")) {
            x = 3;
        }
        else if (next.matches(".*R{2}.*")) {
            x = 2;
        }
        else if (next.matches(".*R{1}.*")) {
            x = 1;
        }
        else {
            x = 0;
        }
        System.out.println(x);
    }
}
