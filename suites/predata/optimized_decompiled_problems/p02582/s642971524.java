import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private Scanner sc;
    private String S;
    
    private static void main$3231c38a() throws Exception {
        final Scanner scanner = new Scanner(System.in);
        final Main main = new Main(scanner);
        int x = 0;
        int n = 0;
        for (int i = 0; i < main.S.length() - 1; ++i) {
            if (main.S.charAt(i) == 'R' || main.S.charAt(2) == 'R') {
                x = 1;
            }
            if (main.S.charAt(i) == 'R' && main.S.charAt(i + 1) == 'R') {
                ++n;
            }
        }
        if (n == 1) {
            x = 2;
        }
        else if (n == 2) {
            x = 3;
        }
        System.out.println(x);
        scanner.close();
    }
    
    private Main(final Scanner sc) {
        this.sc = sc;
        this.S = sc.next();
    }
    
    private int solve() {
        int n = 0;
        int n2 = 0;
        for (int i = 0; i < this.S.length() - 1; ++i) {
            if (this.S.charAt(i) == 'R' || this.S.charAt(2) == 'R') {
                n = 1;
            }
            if (this.S.charAt(i) == 'R' && this.S.charAt(i + 1) == 'R') {
                ++n2;
            }
        }
        if (n2 == 1) {
            n = 2;
        }
        else if (n2 == 2) {
            n = 3;
        }
        return n;
    }
    
    private static void show(final int x) {
        System.out.println(x);
    }
}
