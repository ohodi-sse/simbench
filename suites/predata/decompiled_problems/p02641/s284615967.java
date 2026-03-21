import java.util.Iterator;
import java.util.TreeMap;
import java.util.Arrays;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final Scanner scanner = new Scanner(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new C().solve(1, scanner, printWriter);
        printWriter.close();
    }
    
    static class C
    {
        public void solve(final int n, final Scanner scanner, final PrintWriter printWriter) {
            final int int1 = Integer.parseInt(scanner.next());
            final int int2 = Integer.parseInt(scanner.next());
            if (int2 == 0) {
                printWriter.println(int1);
                return;
            }
            final int[] a = new int[int2];
            for (int i = 0; i < int2; ++i) {
                a[i] = Integer.parseInt(scanner.next());
            }
            Arrays.sort(a);
            int n2 = 0;
            final TreeMap treeMap = new TreeMap();
            for (int j = 101; j >= 0; --j) {
                for (int k = 0; k < int2; ++k) {
                    if (j == a[k]) {
                        n2 = 1;
                        break;
                    }
                }
                if (n2 == 0) {
                    treeMap.put(Math.abs(int1 - j), j);
                }
                n2 = 0;
            }
            final Iterator iterator = treeMap.values().iterator();
            if (iterator.hasNext()) {
                printWriter.println(((Integer)iterator.next()).toString());
            }
        }
    }
}