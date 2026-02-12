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
        final Scanner scanner;
        final int int1 = Integer.parseInt((scanner = new Scanner(System.in)).next());
        int x = 1;
        int i = 1;
        int n = 0;
        while (i <= int1) {
            int n2;
            int n3;
            for (n2 = i, n3 = 0; n2 % 2 == 0; n2 /= 2, ++n3) {}
            final int n4 = n3;
            if (n < n4) {
                x = i;
                n = n4;
            }
            ++i;
        }
        Main.out.println(x);
        Main.out.close();
        scanner.close();
    }
    
    private static void run() {
        Main.out = new PrintWriter(new BufferedOutputStream(System.out));
        final Scanner scanner;
        final int int1 = Integer.parseInt((scanner = new Scanner(System.in)).next());
        int x = 1;
        int i = 1;
        int n = 0;
        while (i <= int1) {
            int n2;
            int n3;
            for (n2 = i, n3 = 0; n2 % 2 == 0; n2 /= 2, ++n3) {}
            final int n4 = n3;
            if (n < n4) {
                x = i;
                n = n4;
            }
            ++i;
        }
        Main.out.println(x);
        Main.out.close();
        scanner.close();
    }
    
    private static int countOfDividedByTwo(int n) {
        int n2;
        for (n2 = 0; n % 2 == 0; n /= 2, ++n2) {}
        return n2;
    }
}
