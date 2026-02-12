import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static Scanner scanner;
    
    private static void main$3231c38a() {
        final int int1 = Integer.parseInt((Main.scanner = new Scanner(System.in)).next());
        int i = 1;
        for (int n = 0; Math.pow(2.0, n) <= int1; ++n) {
            i = (int)Math.pow(2.0, n);
        }
        System.out.print(i);
    }
    
    private static String gs() {
        return Main.scanner.next();
    }
    
    private static int gi() {
        return Integer.parseInt(Main.scanner.next());
    }
    
    private static long gl() {
        return Long.parseLong(Main.scanner.next());
    }
    
    private static double gd() {
        return Double.parseDouble(Main.scanner.next());
    }
}
