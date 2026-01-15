import java.math.BigDecimal;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final FastScanner fastScanner = new FastScanner();
        System.out.println(new BigDecimal(fastScanner.next()).multiply(BigDecimal.valueOf(fastScanner.nextLong())).toBigInteger());
    }
}
