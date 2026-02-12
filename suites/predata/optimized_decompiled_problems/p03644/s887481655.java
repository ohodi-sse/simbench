import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static Scanner sc;
    
    private static void main$3231c38a() {
        int i;
        int n;
        for (i = Main.sc.nextInt(), n = 1; i >= n; n <<= 1) {}
        System.out.print(n / 2);
    }
    
    static {
        Main.sc = new Scanner(System.in);
    }
}
