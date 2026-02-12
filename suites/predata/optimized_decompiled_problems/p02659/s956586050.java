import java.io.IOException;
import java.math.BigDecimal;
import java.util.StringTokenizer;
import java.io.Writer;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        printWriter.println(new BigDecimal(stringTokenizer.nextToken()).multiply(new BigDecimal(stringTokenizer.nextToken())).setScale(0, 1));
        printWriter.close();
    }
}
