import java.util.Arrays;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        new HashMap();
        final PrintWriter printWriter = new PrintWriter(System.out);
        final int int1 = Integer.parseInt(scanner.next());
        final int int2 = Integer.parseInt(scanner.next());
        final boolean[] array;
        Arrays.fill(array = new boolean[102], true);
        for (int i = 0; i < int2; ++i) {
            array[Integer.parseInt(scanner.next())] = false;
        }
        int n = 0;
        int j = 1;
        while (j != 0) {
            if (array[Math.max(0, int1 - n)]) {
                printWriter.print("" + (int1 - n));
                j = 0;
            }
            else if (array[Math.min(101, int1 + n)]) {
                printWriter.print("" + (int1 + n));
                j = 0;
            }
            ++n;
        }
        scanner.close();
        printWriter.flush();
    }
}
