import java.io.IOException;
import java.math.RoundingMode;
import java.math.BigDecimal;
import java.util.StringTokenizer;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final PrintWriter printWriter = new PrintWriter(System.out);
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        printWriter.println(new BigDecimal(stringTokenizer.nextToken()).multiply(new BigDecimal(stringTokenizer.nextToken())).setScale(0, RoundingMode.DOWN).toPlainString());
        bufferedReader.close();
        printWriter.close();
    }
}
