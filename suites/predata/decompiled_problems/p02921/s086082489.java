import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        final String next2 = scanner.next();
        int x = 0;
        for (int i = 0; i < next.length(); ++i) {
            x += ((next.charAt(i) == next2.charAt(i)) ? 1 : 0);
        }
        System.out.println(x);
    }
}
