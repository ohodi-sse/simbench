import java.io.IOException;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) throws IOException {
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        scanner.close();
        int x = 0;
        int n = 0;
        for (int i = 0; i < next.length(); ++i) {
            if (next.charAt(i) == 'R') {
                ++n;
            }
            else if (x < n) {
                x = n;
                n = 0;
            }
        }
        if (x < n) {
            x = n;
        }
        System.out.println(x);
    }
}
