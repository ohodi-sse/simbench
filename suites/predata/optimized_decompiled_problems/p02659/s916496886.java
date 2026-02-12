import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static Scanner sc;
    
    private static void main$3231c38a() {
        System.out.println(Main.sc.nextLong() * Math.round(Main.sc.nextDouble() * 100.0) / 100L);
    }
    
    static {
        Main.sc = new Scanner(System.in);
    }
}
