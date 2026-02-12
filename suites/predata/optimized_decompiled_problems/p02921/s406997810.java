import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static Scanner scanner;
    
    private static void main$3231c38a() {
        final String next = (Main.scanner = new Scanner(System.in)).next();
        final String next2 = Main.scanner.next();
        int i = 0;
        for (int j = 0; j < 3; ++j) {
            if (next.charAt(j) == next2.charAt(j)) {
                ++i;
            }
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
