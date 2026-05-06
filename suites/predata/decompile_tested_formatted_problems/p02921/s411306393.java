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
            if (next.substring(i, i + 1).equals(next2.substring(i, i + 1))) {
                ++x;
            }
        }
        System.out.println(x);
    }
    
    private static long lcm(final long n, final long n2) {
        return n * n2 / gcd(n, n2);
    }
    
    private static long gcd(final long n, final long n2) {
        if (n < n2) {
            return gcd(n2, n);
        }
        if (n2 == 0L) {
            return n;
        }
        return gcd(n2, n % n2);
    }
}
