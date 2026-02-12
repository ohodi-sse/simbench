import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        final PrintWriter printWriter = new PrintWriter(System.out);
        final int int1;
        int x;
        if ((int1 = Integer.parseInt(scanner.next())) == 1) {
            x = 1;
        }
        else if (int1 < 4) {
            x = 2;
        }
        else if (int1 < 8) {
            x = 4;
        }
        else if (int1 < 16) {
            x = 8;
        }
        else if (int1 < 32) {
            x = 16;
        }
        else if (int1 < 64) {
            x = 32;
        }
        else {
            x = 64;
        }
        printWriter.println(x);
        printWriter.flush();
    }
}
