import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static void main$3231c38a() throws Exception {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        final String next2 = scanner.next();
        final String s = next;
        final String s2 = next2;
        final String s3 = s;
        int x = 0;
        for (int i = 0; i < s3.length(); ++i) {
            if (s3.charAt(i) == s2.charAt(i)) {
                ++x;
            }
        }
        System.out.println(x);
    }
    
    private static void solve(final String s, final String s2) {
        int x = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == s2.charAt(i)) {
                ++x;
            }
        }
        System.out.println(x);
    }
}
