import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    static void solve() {
        final Scanner scanner = new Scanner(System.in);
        int x = 0;
        int n = 46;
        for (final char c : scanner.next().toCharArray()) {
            x = (((n == 46 || n == 83) && c == 'R') ? 1 : x);
            if (c == 'R' && n == 82) {
                ++x;
            }
            n = c;
        }
        System.out.println(x);
        scanner.close();
    }
    
    public static void main(final String[] array) {
        solve();
    }
}
