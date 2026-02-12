import java.io.PrintStream;
import java.io.InputStream;
import java.util.Arrays;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final Scanner scanner = new Scanner(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new ABC170_c();
        final Scanner scanner2 = scanner;
        final PrintWriter printWriter2 = printWriter;
        final Scanner scanner3 = scanner2;
        final int nextInt = scanner2.nextInt();
        final int nextInt2;
        final int[] a = new int[nextInt2 = scanner3.nextInt()];
        final int[] array = new int[110];
        for (int i = 0; i < array.length; ++i) {
            array[i] = Integer.MAX_VALUE;
        }
        for (int j = 0; j < nextInt2; ++j) {
            a[j] = scanner3.nextInt();
        }
        Arrays.sort(a);
        for (int k = 0; k < a.length; ++k) {
            array[a[k]] = a[k];
        }
        if (array[nextInt] == Integer.MAX_VALUE) {
            printWriter2.println(nextInt);
        }
        else {
            int x = 0;
            for (int l = nextInt; l < array.length; ++l) {
                if (array[l] == Integer.MAX_VALUE) {
                    x = l;
                    break;
                }
            }
            int x2 = 0;
            for (int n = nextInt; n >= 0; --n) {
                if (array[n] == Integer.MAX_VALUE) {
                    x2 = n;
                    break;
                }
            }
            if (Math.abs(nextInt - x) >= Math.abs(nextInt - x2)) {
                printWriter2.println(x2);
            }
            else {
                printWriter2.println(x);
            }
        }
        printWriter.close();
    }
    
    static final class ABC170_c
    {
        private static void solve$32964a28(final Scanner scanner, final PrintWriter printWriter) {
            final int nextInt = scanner.nextInt();
            final int nextInt2;
            final int[] a = new int[nextInt2 = scanner.nextInt()];
            final int[] array = new int[110];
            for (int i = 0; i < array.length; ++i) {
                array[i] = Integer.MAX_VALUE;
            }
            for (int j = 0; j < nextInt2; ++j) {
                a[j] = scanner.nextInt();
            }
            Arrays.sort(a);
            for (int k = 0; k < a.length; ++k) {
                array[a[k]] = a[k];
            }
            if (array[nextInt] == Integer.MAX_VALUE) {
                printWriter.println(nextInt);
                return;
            }
            int x = 0;
            for (int l = nextInt; l < array.length; ++l) {
                if (array[l] == Integer.MAX_VALUE) {
                    x = l;
                    break;
                }
            }
            int x2 = 0;
            for (int n = nextInt; n >= 0; --n) {
                if (array[n] == Integer.MAX_VALUE) {
                    x2 = n;
                    break;
                }
            }
            if (Math.abs(nextInt - x) >= Math.abs(nextInt - x2)) {
                printWriter.println(x2);
                return;
            }
            printWriter.println(x);
        }
    }
}
