import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        int x = 0;
        int n = 0;
        final String next = scanner.next();
        for (int i = 0; i < 3; ++i) {
            if (next.charAt(i) == 'R') {
                if (n == 1) {
                    ++x;
                }
                else {
                    x = 1;
                }
                n = 1;
            }
            else {
                n = 0;
            }
        }
        System.out.println(x);
        scanner.close();
    }
}
