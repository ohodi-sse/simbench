import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        new Main().solve();
    }
    
    void solve() {
        int nextInt;
        int n;
        for (nextInt = new Scanner(System.in).nextInt(), n = 0; 1 << n + 1 <= nextInt; ++n) {}
        System.out.println(1 << n);
    }
}
