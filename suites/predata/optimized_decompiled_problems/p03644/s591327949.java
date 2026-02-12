import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void solve() {
        Scanner scanner;
        int n;
        int n2;
        for (scanner = new Scanner(System.in), n = 1, n2 = 0; 2 * n <= scanner.nextInt(); n <<= 1, ++n2) {}
        System.out.println((int)Math.pow(2.0, n2));
        scanner.close();
    }
    
    private static void main$3231c38a() {
        Scanner scanner;
        int n;
        int n2;
        for (scanner = new Scanner(System.in), n = 1, n2 = 0; 2 * n <= scanner.nextInt(); n <<= 1, ++n2) {}
        System.out.println((int)Math.pow(2.0, n2));
        scanner.close();
    }
}
