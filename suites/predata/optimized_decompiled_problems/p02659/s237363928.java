import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final long long1 = Long.parseLong((scanner = new Scanner(System.in)).next());
        final String next = scanner.next();
        long n = 0L;
        int n2 = 100;
        for (int i = 0; i < 4; ++i) {
            final String s = next;
            final int beginIndex = i;
            if (!s.substring(beginIndex, beginIndex + 1).equals(".")) {
                final long n3 = n;
                final int n4 = n2;
                final String s2 = next;
                final int beginIndex2 = i;
                n = n3 + n4 * Integer.parseInt(s2.substring(beginIndex2, beginIndex2 + 1));
                n2 /= 10;
            }
        }
        final long n5 = long1 * n;
        System.out.println((n5 - n5 % 100L) / 100L);
    }
}
