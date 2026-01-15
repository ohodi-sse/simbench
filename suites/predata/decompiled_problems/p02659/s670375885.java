import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) throws IOException {
        final FastReader fastReader = new FastReader();
        final PrintWriter printWriter = new PrintWriter(System.out);
        System.out.println((long)(fastReader.nextDouble() * 100.0 + 0.05) * fastReader.nextLong() / 100L);
    }
}
