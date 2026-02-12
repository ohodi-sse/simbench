import java.util.Iterator;
import java.io.PrintStream;
import java.io.InputStream;
import java.util.TreeMap;
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
        new C();
        final Scanner scanner2 = scanner;
        final PrintWriter printWriter2 = printWriter;
        final Scanner scanner3 = scanner2;
        final int int1 = Integer.parseInt(scanner2.next());
        final int int2;
        if ((int2 = Integer.parseInt(scanner3.next())) == 0) {
            printWriter2.println(int1);
        }
        else {
            final int[] a = new int[int2];
            for (int i = 0; i < int2; ++i) {
                a[i] = Integer.parseInt(scanner3.next());
            }
            Arrays.sort(a);
            int n = 0;
            final TreeMap treeMap = new TreeMap();
            for (int j = 101; j >= 0; --j) {
                for (int k = 0; k < int2; ++k) {
                    if (j == a[k]) {
                        n = 1;
                        break;
                    }
                }
                if (n == 0) {
                    treeMap.put(Math.abs(int1 - j), j);
                }
                n = 0;
            }
            final Iterator iterator;
            if ((iterator = treeMap.values().iterator()).hasNext()) {
                printWriter2.println(((Integer)iterator.next()).toString());
            }
        }
        printWriter.close();
    }
    
    static final class C
    {
        private static void solve$32964a28(final Scanner scanner, final PrintWriter printWriter) {
            final int int1 = Integer.parseInt(scanner.next());
            final int int2;
            if ((int2 = Integer.parseInt(scanner.next())) == 0) {
                printWriter.println(int1);
                return;
            }
            final int[] a = new int[int2];
            for (int i = 0; i < int2; ++i) {
                a[i] = Integer.parseInt(scanner.next());
            }
            Arrays.sort(a);
            int n = 0;
            final TreeMap treeMap = new TreeMap();
            for (int j = 101; j >= 0; --j) {
                for (int k = 0; k < int2; ++k) {
                    if (j == a[k]) {
                        n = 1;
                        break;
                    }
                }
                if (n == 0) {
                    treeMap.put(Math.abs(int1 - j), j);
                }
                n = 0;
            }
            final Iterator iterator;
            if ((iterator = treeMap.values().iterator()).hasNext()) {
                printWriter.println(((Integer)iterator.next()).toString());
            }
        }
    }
}
