import java.io.PrintWriter;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final InputReader inputReader = new InputReader(System.in);
        final PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)), true);
        new TaskB().solve(1, inputReader, printWriter);
        printWriter.flush();
        printWriter.close();
    }
}
