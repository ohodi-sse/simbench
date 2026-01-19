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
        new TaskB().solve(1, scanner, printWriter);
        printWriter.close();
    }
    
    static class TaskB
    {
        public static int div(int n) {
            int n2 = 0;
            while (n % 2 == 0) {
                ++n2;
                n /= 2;
            }
            return n2;
        }
        
        public void solve(final int n, final Scanner scanner, final PrintWriter printWriter) {
            final int nextInt = scanner.nextInt();
            int div = 0;
            int x = 1;
            for (int i = 2; i <= nextInt; ++i) {
                if (div < div(i)) {
                    div = div(i);
                    x = i;
                }
            }
            printWriter.println(x);
        }
    }
}
import java.io.PrintWriter;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

static class TaskB
{
    public static int div(int n) {
        int n2 = 0;
        while (n % 2 == 0) {
            ++n2;
            n /= 2;
        }
        return n2;
    }
    
    public void solve(final int n, final Scanner scanner, final PrintWriter printWriter) {
        final int nextInt = scanner.nextInt();
        int div = 0;
        int x = 1;
        for (int i = 2; i <= nextInt; ++i) {
            if (div < div(i)) {
                div = div(i);
                x = i;
            }
        }
        printWriter.println(x);
    }
}
