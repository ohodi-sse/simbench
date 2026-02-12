import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static Scanner sc;
    
    private static void main$3231c38a() {
        final long nextLong = Main.sc.nextLong();
        final String next = Main.sc.next();
        System.out.println((0L + 100L * nextLong * Character.getNumericValue(next.charAt(0)) + 10L * nextLong * Character.getNumericValue(next.charAt(2)) + nextLong * Character.getNumericValue(next.charAt(3))) / 100L);
    }
    
    static {
        Main.sc = new Scanner(System.in);
    }
}
