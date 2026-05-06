import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        int max = 0;
        for (int i = 0; i < next.length(); ++i) {
            int b = 0;
            for (int index = i; index < next.length() && next.charAt(index) == 'R'; ++index) {
                ++b;
            }
            max = Math.max(max, b);
        }
        System.out.println(max);
        scanner.close();
    }
}
