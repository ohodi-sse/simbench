import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static Scanner scanner;
    
    private static void main$3231c38a() {
        Main.scanner = new Scanner(System.in);
        int gi = gi();
        final int gi2;
        final int[] array = new int[gi2 = gi()];
        for (int i = 0; i < gi2; ++i) {
            array[i] = gi();
        }
        int n = 0;
        boolean b;
        do {
            gi += (int)(Math.pow(-1.0, n) * n);
            b = false;
            for (int j = 0; j < gi2; ++j) {
                if (array[j] == gi) {
                    ++n;
                    b = true;
                    break;
                }
            }
        } while (b);
        System.out.println(gi);
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
