import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        int x = 0;
        scanner.close();
        for (int i = 0; i < 3; ++i) {
            if (next.charAt(i) == 'R') {
                ++x;
            }
        }
        if (next.equals("RSR")) {
            x = 1;
        }
        System.out.println(x);
    }
}
