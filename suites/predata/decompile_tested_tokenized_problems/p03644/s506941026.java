import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        try (final Scanner scanner = new Scanner(System.in)) {
            solve(scanner);
        }
    }
    
    public static void solve(final Scanner scanner) {
        final int nextInt = scanner.nextInt();
        int n = 1;
        for (int i = 0; i <= 100; ++i) {
            if (n > nextInt) {
                System.out.println(n / 2);
                return;
            }
            n *= 2;
        }
    }
}
