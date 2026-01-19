import java.math.BigDecimal;
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
        new Task().solve(1, scanner, printWriter);
        printWriter.close();
    }
    
    static class Task
    {
        public void solve(final int n, final Scanner scanner, final PrintWriter printWriter) {
            printWriter.println(new BigDecimal("" + scanner.nextDouble()).multiply(new BigDecimal("" + scanner.nextDouble())).toBigInteger());
        }
    }
}
import java.math.BigDecimal;
import java.io.PrintWriter;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

static class Task
{
    public void solve(final int n, final Scanner scanner, final PrintWriter printWriter) {
        printWriter.println(new BigDecimal("" + scanner.nextDouble()).multiply(new BigDecimal("" + scanner.nextDouble())).toBigInteger());
    }
}
