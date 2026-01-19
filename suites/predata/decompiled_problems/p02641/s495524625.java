import java.util.Arrays;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final Scanner scanner = new Scanner(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new ABC170_c().solve(1, scanner, printWriter);
        printWriter.close();
    }
    
    static class ABC170_c
    {
        public void solve(final int n, final Scanner scanner, final PrintWriter printWriter) {
            final int nextInt = scanner.nextInt();
            final int nextInt2 = scanner.nextInt();
            final int[] a = new int[nextInt2];
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
            for (int n2 = nextInt; n2 >= 0; --n2) {
                if (array[n2] == Integer.MAX_VALUE) {
                    x2 = n2;
                    break;
                }
            }
            if (Math.abs(nextInt - x) >= Math.abs(nextInt - x2)) {
                printWriter.println(x2);
            }
            else {
                printWriter.println(x);
            }
        }
    }
}
import java.util.Arrays;
import java.io.PrintWriter;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

static class ABC170_c
{
    public void solve(final int n, final Scanner scanner, final PrintWriter printWriter) {
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final int[] a = new int[nextInt2];
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
        for (int n2 = nextInt; n2 >= 0; --n2) {
            if (array[n2] == Integer.MAX_VALUE) {
                x2 = n2;
                break;
            }
        }
        if (Math.abs(nextInt - x) >= Math.abs(nextInt - x2)) {
            printWriter.println(x2);
        }
        else {
            printWriter.println(x);
        }
    }
}
