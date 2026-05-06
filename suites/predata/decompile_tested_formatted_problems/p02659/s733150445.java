import java.io.IOException;
import java.math.BigDecimal;
import java.util.StringTokenizer;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) throws IOException {
        final StringTokenizer stringTokenizer = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        System.out.println(new StringTokenizer(new BigDecimal(stringTokenizer.nextToken()).multiply(new BigDecimal(stringTokenizer.nextToken())).toString(), ".").nextElement());
    }
}
