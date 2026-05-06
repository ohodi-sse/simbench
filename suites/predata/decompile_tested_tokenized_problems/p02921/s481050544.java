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
        for (int i = 0; i < 3; ++i) {
            if (next.substring(i, i + 1).charAt(0) == next2.substring(i, i + 1).charAt(0)) {
                ++x;
            }
        }
        System.out.println(x);
    }
}
