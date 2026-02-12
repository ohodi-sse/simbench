import java.math.BigDecimal;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() throws Exception {
        try (final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            final String[] split = bufferedReader.readLine().split(" ");
            bufferedReader.close();
            System.out.println(new BigDecimal(split[0]).multiply(new BigDecimal(split[1])).toBigInteger());
        }
    }
}
