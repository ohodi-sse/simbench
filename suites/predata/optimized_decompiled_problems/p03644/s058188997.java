import java.util.Scanner;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static PrintWriter out;
    
    private static void main$3231c38a() {
        Main.out = new PrintWriter(new BufferedOutputStream(System.out));
        final Scanner scanner = new Scanner(System.in);
        final PrintWriter out = Main.out;
        final int int1 = Integer.parseInt(scanner.next());
        int x = 0;
        for (int n = 0; (int)Math.pow(2.0, n) <= int1; ++n) {
            x = (int)Math.pow(2.0, n);
        }
        out.println(x);
        Main.out.close();
        scanner.close();
    }
    
    private static void run() {
        Main.out = new PrintWriter(new BufferedOutputStream(System.out));
        final Scanner scanner = new Scanner(System.in);
        final PrintWriter out = Main.out;
        final int int1 = Integer.parseInt(scanner.next());
        int x = 0;
        for (int n = 0; (int)Math.pow(2.0, n) <= int1; ++n) {
            x = (int)Math.pow(2.0, n);
        }
        out.println(x);
        Main.out.close();
        scanner.close();
    }
    
    private static int count(final int n) {
        int n2 = 0;
        for (int n3 = 0; (int)Math.pow(2.0, n3) <= n; ++n3) {
            n2 = (int)Math.pow(2.0, n3);
        }
        return n2;
    }
}
