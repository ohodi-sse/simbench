import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) throws IOException {
        final PrintWriter printWriter = new PrintWriter(System.out);
        new test().solve(new FastReader(), printWriter);
        printWriter.close();
    }
}
