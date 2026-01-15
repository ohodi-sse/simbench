import java.io.OutputStream;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    private static int solve(int i) {
        int n;
        for (n = 0; i > 1; i /= 2, ++n) {}
        return 1 << n;
    }
    
    private static void execute(final ContestReader contestReader, final PrintWriter printWriter) {
        printWriter.println(solve(contestReader.nextInt()));
    }
    
    public static void main(final String[] array) {
        final ContestReader contestReader = new ContestReader(System.in);
        final PrintWriter printWriter = new PrintWriter(System.out);
        execute(contestReader, printWriter);
        printWriter.flush();
    }
}
