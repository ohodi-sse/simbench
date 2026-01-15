import java.io.IOException;
import java.math.BigDecimal;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 
// Decompiled by Procyon v0.6.0
// 

class Main
{
    public static void main(final String[] array) throws IOException {
        try (final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            final String[] split = bufferedReader.readLine().split(" ");
            System.out.println(Long.parseLong(split[0]) * new BigDecimal(split[1]).multiply(new BigDecimal("100")).intValue() / 100L);
        }
    }
}
