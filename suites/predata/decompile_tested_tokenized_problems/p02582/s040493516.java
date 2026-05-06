import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        int x = -1;
        for (int length = next.length(); 0 <= length; --length) {
            if (next.matches(String.format(".*R{%d}.*", length))) {
                x = length;
                length = -1;
            }
        }
        System.out.println(x);
    }
}
