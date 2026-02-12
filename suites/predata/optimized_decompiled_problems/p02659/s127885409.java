import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private Scanner sc;
    private int MOD;
    
    public Main() {
        this.sc = new Scanner(System.in);
        this.MOD = 998244353;
    }
    
    private static void main$3231c38a() {
        final Main main = new Main();
        System.out.println(main.sc.nextLong() * Math.round(main.sc.nextDouble() * 100.0) / 100L);
    }
    
    private void run() {
        System.out.println(this.sc.nextLong() * Math.round(this.sc.nextDouble() * 100.0) / 100L);
    }
}
