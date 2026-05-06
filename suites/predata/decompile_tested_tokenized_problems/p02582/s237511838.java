import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        scanner.close();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (next.charAt(i) == 'R') {
                if (i == 2 && next.charAt(1) == 'S') {
                    x = 0;
                }
                ++x;
            }
        }
        System.out.println(x);
    }
}
