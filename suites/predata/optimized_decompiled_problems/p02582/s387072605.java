import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void solve() {
        final Scanner scanner = new Scanner(System.in);
        int x = 0;
        int n = 46;
        char[] charArray;
        for (int length = (charArray = scanner.next().toCharArray()).length, i = 0; i < length; ++i) {
            final char c = charArray[i];
            x = (((n == 46 || n == 83) && c == 'R') ? 1 : x);
            if (c == 'R' && n == 82) {
                ++x;
            }
            n = c;
        }
        System.out.println(x);
        scanner.close();
    }
    
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        int x = 0;
        int n = 46;
        char[] charArray;
        for (int length = (charArray = scanner.next().toCharArray()).length, i = 0; i < length; ++i) {
            final char c = charArray[i];
            x = (((n == 46 || n == 83) && c == 'R') ? 1 : x);
            if (c == 'R' && n == 82) {
                ++x;
            }
            n = c;
        }
        System.out.println(x);
        scanner.close();
    }
}
