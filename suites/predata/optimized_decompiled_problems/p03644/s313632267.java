import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        new Main();
        int nextInt;
        int n;
        for (nextInt = new Scanner(System.in).nextInt(), n = 0; 1 << n + 1 <= nextInt; ++n) {}
        System.out.println(1 << n);
    }
    
    private static void solve() {
        int nextInt;
        int n;
        for (nextInt = new Scanner(System.in).nextInt(), n = 0; 1 << n + 1 <= nextInt; ++n) {}
        System.out.println(1 << n);
    }
}
